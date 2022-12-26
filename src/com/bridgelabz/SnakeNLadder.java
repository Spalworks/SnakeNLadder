package com.bridgelabz;

public class SnakeNLadder {
	
	static final int START_POSITION = 0;
	
	static final int NO_PLAY = 0;
	static final int IS_SNAKE = 1;
	static final int IS_LADDER = 2;
	
	static int diceRoll() {
		int x = (int) (1+ Math.random() * 6);
		return x;
	}
	static int getOption() {
		int x = (int) (Math.random() * 3);
		return x;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to snake and ladder problem.");
		
		int playerPosition = START_POSITION;
		
		int roll = diceRoll();
		System.out.println(roll);
		
		int option = getOption();
		switch (option) {
		case IS_SNAKE :
			System.out.println("Snake");
			playerPosition -= roll;
			break;
		case IS_LADDER :
			System.out.println("Ladder");
			playerPosition += roll;
			break;
		default:
			System.out.println("No play");

		}
		
		System.out.println("Player position : " + playerPosition);
		
	}
	
}
