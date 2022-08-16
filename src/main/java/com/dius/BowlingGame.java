package com.dius;

public class BowlingGame {
	
	private static final int MAX_ROLLS = 21;
	
	private int[] rolls = new int[MAX_ROLLS];
	int currentIdx = 0;

	public void roll(int noOfPins) throws Exception {
		if (currentIdx < MAX_ROLLS) {
			rolls[currentIdx++] = noOfPins;
		} else {
			throw new Exception("Player played all the rolls in this game. Start a new Game.");
		}
	}

	public int score() {
		int score = 0;
		int rollIdx = 0;
		
		for(int frame = 1; frame <= 10; frame++) {
			
			if(isStrike(rollIdx)) {
				score += rolls[rollIdx++] + rolls[rollIdx++] + rolls[rollIdx--];
			} else if(isSpare(rollIdx)) {
				score += rolls[rollIdx++] + rolls[rollIdx++] + rolls[rollIdx];
			}
			else {
				score += rolls[rollIdx++] + rolls[rollIdx++];
			}
		}
		
		return score;
	}

	private boolean isStrike(int rollIdx) {
		return (rolls[rollIdx] == 10);
	}
	
	private boolean isSpare(int rollIdx) {
		return (rolls[rollIdx++] + rolls[rollIdx++] == 10);
	}

}
