package com.bridgelabz;

public class SnakeNLadder {

	static final int START_POSITION = 0;
	static final int FINAL_POSITION = 100;

	static final int NO_PLAY = 0;
	static final int IS_SNAKE = 1;
	static final int IS_LADDER = 2;

	static int diceCount =0;

	static int diceRoll() {
		int x = (int) (1 + Math.random() * 6);
		return x;
	}

	static int getOption() {
		int x = (int) (Math.random() * 3);
		return x;
	}

	static int getToss() {
		int x = (int) (Math.random() * 2);
		return x;
	}

	static int playGame(int playerPosition) {
		int roll = diceRoll();
		diceCount++;
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
			break;
		case IS_LADDER :
			System.out.println("Ladder");
			playerPosition += roll;
			if(playerPosition > FINAL_POSITION) {
				playerPosition -= roll;
				System.out.println("!!!!Player position getting more than " + FINAL_POSITION + " !!!!");
			}
			break;
		default:
			System.out.println("No play");

		}

		System.out.print("Total Dice count : " + diceCount);
		System.out.println("  , Player position : " + playerPosition);

		if(option == IS_LADDER && playerPosition != FINAL_POSITION) {
			playGame(playerPosition);
		}
		System.out.println();
		return playerPosition;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Snake ladder program");
		
		int player1Position = START_POSITION;
		int player2Position = START_POSITION;

		int toss = getToss(); 

		while (player1Position < FINAL_POSITION && player2Position < FINAL_POSITION ) {

			if(toss == 0){
				System.out.println();
				System.out.println("PLAYER 1 IS ROLLING");
				player1Position = playGame(player1Position);

				if(player1Position == FINAL_POSITION) {
					System.out.println("Player1 is winner");
					System.exit(0);
				} 
				toss = 1;
			}else {
				System.out.println();
				System.out.println("PLAYER 2 IS ROLLING");
				player2Position = playGame(player2Position);
				if(player2Position == FINAL_POSITION) {
					System.out.println("Player2 is winner");
					System.exit(0);;
				}
				toss = 0;
			}
		}

	}
}



