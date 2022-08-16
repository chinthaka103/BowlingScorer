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
	public void testWhenNoPoints() {
		try {
			fillGames(21, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(0, bowlingGame.score());
	}
	
	@Test
	public void testWhenAllOnePoints() {
		try {
			fillGames(21, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(20, bowlingGame.score());
	}
	
	@Test
	public void testWhenFailToKnockDownPinsInAGame() {
		
		try {
			bowlingGame.roll(4);
			bowlingGame.roll(4);
			fillGames(19, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(8, bowlingGame.score());
	}
	
	@Test
	public void testWhenSpareGame() {
		try {
			bowlingGame.roll(4);
			bowlingGame.roll(6);
			bowlingGame.roll(5);
			fillGames(18, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(20, bowlingGame.score());
	}
	
	@Test
	public void testWhenStrikeGame() {
		try {
			bowlingGame.roll(10);
			bowlingGame.roll(5);
			bowlingGame.roll(4);
			fillGames(18, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(28, bowlingGame.score());
	}
	
	@Test
	public void testWhenAllStrikeGames() {
		try {
			fillGames(12, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(300, bowlingGame.score());
	}
	
	@Test(expected = Exception.class)
	public void testWhenExceedRolls() throws Exception {
		fillGames(22, 1);
		assertEquals(22, bowlingGame.score());
	}
	
	public void fillGames(int noOfRolls, int noOfPins) throws Exception {
		for (int i = 1; i <= noOfRolls; i++) {
			bowlingGame.roll(noOfPins);
		}
	}

}
