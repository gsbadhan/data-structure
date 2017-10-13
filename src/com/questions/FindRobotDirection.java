package com.questions;

/**
 * 
 * L : Left turn; R : Right turn; G : 1 unit move;
 */
public class FindRobotDirection {
	private enum DIRECTION {
		NORTH, SOUTH, EAST, WEST
	};

	public boolean isMovingInCircle(String givenCommands) {
		// assuming current direction is North
		DIRECTION currentDirection = DIRECTION.NORTH;
		/*
		 * set any initial X,Y if available; otherwise assuming current X and Y
		 * axis movement is 0
		 */
		int initialX = 0;
		int initialY = 0;
		int movingX = initialX;
		int movingY = initialY;

		char[] commands = givenCommands.toCharArray();
		for (int i = 0; i < commands.length; i++) {
			// new direction based on L/R
			currentDirection = newDirection(currentDirection, commands[i]);
			if (commands[i] == 'G')
				switch (currentDirection) {
				case NORTH:
					++movingY;
					break;
				case SOUTH:
					--movingY;
					break;
				case EAST:
					++movingX;
					break;
				case WEST:
					--movingX;
					break;
				}
		}
		if (initialX == movingX && initialY == movingY) {
			System.out.println("robot is moving in circle [" + givenCommands + "] !!");
			return true;
		}

		System.out.println("robot is not moving in circle [" + givenCommands + "]");
		return false;
	}

	private DIRECTION newDirection(DIRECTION currentDirection, char command) {
		switch (currentDirection) {
		case NORTH:
			if (command == 'L')
				currentDirection = DIRECTION.WEST;
			else if (command == 'R')
				currentDirection = DIRECTION.EAST;
			break;
		case SOUTH:
			if (command == 'L')
				currentDirection = DIRECTION.EAST;
			else if (command == 'R')
				currentDirection = DIRECTION.WEST;
			break;
		case EAST:
			if (command == 'L')
				currentDirection = DIRECTION.NORTH;
			else if (command == 'R')
				currentDirection = DIRECTION.SOUTH;
			break;
		case WEST:
			if (command == 'L')
				currentDirection = DIRECTION.SOUTH;
			else if (command == 'R')
				currentDirection = DIRECTION.NORTH;
			break;
		}
		return currentDirection;
	}

	public static void main(String args[]) {
		// input must be combination of L,R,G
		String commands = "GLLG";
		FindRobotDirection robotDirection = new FindRobotDirection();
		robotDirection.isMovingInCircle(commands);
		//
		commands = "GLGLGLG";
		robotDirection.isMovingInCircle(commands);

		commands = "GLGRG";
		robotDirection.isMovingInCircle(commands);

	}
}
