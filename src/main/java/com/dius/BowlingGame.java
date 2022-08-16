package com.dius;

public class BowlingGame implements BolwingGameInterface {
	
	private static final int MAX_ROLLS = 21;
	
	private int[] rolls = new int[MAX_ROLLS]; 
	
	int currentIdx = 0; // current index of the roll
	
	/**
	 * This method records a roll
	 * 
	 * @param noOfPins - No of pins knocked down
	 */
	public void roll(int noOfPins) throws Exception {
		if (currentIdx < MAX_ROLLS) {
			rolls[currentIdx++] = noOfPins;
		} else {
			throw new Exception("Player played all the rolls in this game. Start a new Game.");
		}
	}

	/**
	 * This method returns the running score
	 * 
	 * @return - running score
	 */
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

	/**
	 * This method determines whether roll is a strike 
	 * 
	 * @param rollIdx - roll index
	 * @return true - if a strike, false - if not
	 */
	private boolean isStrike(int rollIdx) {
		return (rolls[rollIdx] == 10);
	}
	
	/**
	 * This method determines whether rolls in consideration are a spare 
	 * 
	 * @param rollIdx - roll index
	 * @return true - if a spare, false - if not
	 */
	private boolean isSpare(int rollIdx) {
		return (rolls[rollIdx++] + rolls[rollIdx++] == 10);
	}

}
