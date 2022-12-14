package com.dius;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTests {

	private BowlingGame bowlingGame;

	@Before
	public void init() {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void testWhenNoPointsInAGame() {
		try {
			fillFrames(21, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(0, bowlingGame.score());
	}

	@Test
	public void testWhenAllOnePointsInAGame() {
		try {
			fillFrames(21, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(20, bowlingGame.score());
	}

	@Test
	public void testWhenFailToKnockDownPinsInAFrame() {

		try {
			bowlingGame.roll(4);
			bowlingGame.roll(4);
			fillFrames(19, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(8, bowlingGame.score());
	}

	@Test
	public void testWhenSpareFrame() {
		try {
			bowlingGame.roll(4);
			bowlingGame.roll(6);
			bowlingGame.roll(5);
			fillFrames(18, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(20, bowlingGame.score());
	}

	@Test
	public void testWhenStrikeFrame() {
		try {
			bowlingGame.roll(10);
			bowlingGame.roll(5);
			bowlingGame.roll(4);
			fillFrames(18, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(28, bowlingGame.score());
	}

	@Test
	public void testWhenTenthFrameSpare() {
		try {
			fillFrames(18, 1);
			bowlingGame.roll(7);
			bowlingGame.roll(3);
			bowlingGame.roll(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(33, bowlingGame.score());
	}

	@Test
	public void testWhenTenthFrameStrike() {
		try {
			fillFrames(18, 1);
			bowlingGame.roll(10);
			bowlingGame.roll(8);
			bowlingGame.roll(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(37, bowlingGame.score());
	}

	@Test
	public void testWhenAllStrikeFrames() {
		try {
			fillFrames(12, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(300, bowlingGame.score());
	}

	@Test(expected = Exception.class)
	public void testWhenExceedRollsInAGame() throws Exception {
		fillFrames(22, 1);
		assertEquals(22, bowlingGame.score());
	}

	/**
	 * Helper method to fill the frames
	 * 
	 * @param noOfRolls - Number of rolls
	 * @param noOfPins - Number of pins in each roll
	 * @throws Exception
	 */
	public void fillFrames(int noOfRolls, int noOfPins) throws Exception {
		for (int i = 1; i <= noOfRolls; i++) {
			bowlingGame.roll(noOfPins);
		}
	}

}
