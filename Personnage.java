package pacman;

import java.awt.*;

public class Personnage {
	private Coordinate coordinate;
	private Direction direction;
	private Color color;
	private final int block_size = 50;

	// private State state;
	public Personnage(Coordinate coordinate, Direction direction, Color color) {
		
		this.coordinate = coordinate;
		this.direction = direction;
		this.color = color;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;

	}
	public int getBlock_size() {
		return block_size;
	}

	public void move(char direction) {
		switch (direction) {
		case 'z':
			this.setDirection(Direction.Up);
			break;
		case 's':
			this.setDirection(Direction.Down);
			break;
		case 'q':
			this.setDirection(Direction.Left);
			break;
		case 'd':
			this.setDirection(Direction.Right);
			break;

		}

	}

	public boolean checkCollisions(int map[][]) {
		switch (this.getDirection()) {
		case Up:
			if (map[(this.getCoordinate().getX() / block_size) - 1][(this.getCoordinate().getY() / block_size)
					- 2] == 1) {
				return true;
			}
			break;
		case Left:
			if (map[(this.getCoordinate().getX() / block_size) - 2][(this.getCoordinate().getY() / block_size)
					- 1] == 1) {
				return true;
			}

			break;
		case Down:
			if (map[(this.getCoordinate().getX() / block_size) - 1][(this.getCoordinate().getY() / block_size) - 1
					+ 1] == 1) {
				return true;
			}

			break;

		case Right:
			if (map[(this.getCoordinate().getX() / block_size) - 1 + 1][(this.getCoordinate().getY() / block_size)
					- 1] == 1) {
				return true;
			}

			break;
		default:
			break;
		}
		return false;

	}
	public void checkPortail() {
		if( coordinate.getX()>=750) {
			coordinate.setX(100);
			
		}
		else if( coordinate.getX()<=50) {
			coordinate.setX(700);
			
			
		}
		
	}
}
