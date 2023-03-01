package pacman;

import java.awt.*;


public class Ghost extends Personnage {

	private int random=0;
	private StateGhost stateGhost;
	
	
	public StateGhost getStateGhost() {
		return stateGhost;
	}
	public void setStateGhost(StateGhost stateGhost) {
		this.stateGhost = stateGhost;
	}
	
	public void action() {
		stateGhost.action(this);
	}


	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}



	public Ghost(Coordinate coordinate, Direction direction, Color color) {
		super(coordinate, direction, color);
		// TODO Auto-generated constructor stub
		
	}

	public Ghost(Color ghostcolor) {
		super(new Coordinate(300, 300), Direction.Right, ghostcolor);

	}

	public Ghost(Coordinate coordinate, Color ghostcolor) {
		super(coordinate, Direction.Right, ghostcolor);

	}

	public void randomGhost() {
		int r = (int) (Math.random() * 4);
		switch (r) {
		case 0:
			move('z');
			this.setDirection(Direction.Up);
			break;
		case 1:
			move('s');
			this.setDirection(Direction.Down);
			break;
		case 2:
			move('q');
			this.setDirection(Direction.Left);
			break;
			
		case 3:
			move('d');
			this.setDirection(Direction.Right);
			break;
		}

	}
	
	
	
}
