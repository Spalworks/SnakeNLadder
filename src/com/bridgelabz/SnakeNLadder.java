package com.bridgelabz;

public class SnakeNLadder {

	static final int START_POSITION = 0;
	static final int FINAL_POSITION = 100;
	
	static final int NO_PLAY = 0;
	static final int IS_SNAKE = 1;
	static final int IS_LADDER = 2;
	
	static int diceCount =0;
	
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
	
		while (playerPosition < FINAL_POSITION) {
			System.out.println();
			diceCount++;
			
			int roll = diceRoll();
			System.out.println(roll);
			
			int option = getOption();
			switch (option) {
			case IS_SNAKE :
				System.out.println("Snake");
				playerPosition -= roll;
				if(playerPosition < START_POSITION) {
					playerPosition = START_POSITION;
					System.out.println("!!!! Player position getting less than " + START_POSITION + " !!!!");
					}
				System.out.println("Player position : " + playerPosition);
				break;
			case IS_LADDER :
				System.out.println("Ladder");
				playerPosition += roll;
				if(playerPosition > FINAL_POSITION) {
					playerPosition -= roll;
				System.out.println("!!!!Player position getting more than " + FINAL_POSITION + " !!!!");
				}
				System.out.println("Player position : " + playerPosition);
				break;
			default:
				System.out.println("No play");
				System.out.println("Player position : " + playerPosition);
			}		
		}
		
		System.out.println("Total Dice count : " + diceCount);
		System.out.println("Finally Player position : " + playerPosition);
		
	}
}



