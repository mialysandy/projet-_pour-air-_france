package pacman;

import java.awt.*;

public class Maze {
	private Pacman pacman;
	private Ghost ghost1, ghost2, ghost3, ghost4;
	private int[][] map;
	private boolean gameOver = false;
	

public boolean victoire() {
	return pacman.getPacgommes() == 0;
}
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean checkPacVert() {

		if (map[(pacman.getCoordinate().getX() / pacman.getBlock_size())
				- 1][(pacman.getCoordinate().getY() / pacman.getBlock_size()) - 1] == 5) {
			
			map[(pacman.getCoordinate().getX() / pacman.getBlock_size())
				- 1][(pacman.getCoordinate().getY() / pacman.getBlock_size()) - 1] =0;
			
			
			
			pacman.setScore(pacman.getScore() + 1000);
			
			map[7][2] = 0;
			map[7][4] = 0;
			map[7][12] = 0;
			map[10][10] = 0;
			map[2][4] = 0;
			map[4][4] = 0;
			map[10][4] = 0;
			map[12][4] = 0;
			
			return true;
		}
		return false;
	}

	public Maze() {

		this.pacman = new Pacman();
		this.ghost1 = new Ghost(new Coordinate(350, 350), Color.cyan);
		this.ghost2 = new Ghost(new Coordinate(400, 350), Color.RED);
		this.ghost3 = new Ghost(new Coordinate(450, 350), Color.GRAY);
		this.ghost4 = new Ghost(new Coordinate(400, 400), Color.GREEN);
		// this.pacgommes = pacgommes;
		this.map = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1 },
								 { 1, 0, 2, 2, 2, 2, 1, 0, 1, 2, 2, 2, 2, 4, 1 }, 
								 { 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 1 }, 
								 { 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1 },
								 { 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1 },
								 { 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 1 }, 
								 { 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 3, 2, 2, 2, 2, 1, 0, 1, 2, 2, 2, 2, 5, 1 },
								 { 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1 } };
								 
								
	}

	
	public Pacman getPacman() {
		return pacman;
	}

	public Ghost getGhost1() {
		return ghost1;
	}

	public void setGhost1(Ghost ghost1) {
		this.ghost1 = ghost1;
	}

	public Ghost getGhost2() {
		return ghost2;
	}

	public void setGhost2(Ghost ghost2) {
		this.ghost2 = ghost2;
	}

	public Ghost getGhost3() {
		return ghost3;
	}

	public void setGhost3(Ghost ghost3) {
		this.ghost3 = ghost3;
	}

	public Ghost getGhost4() {
		return ghost4;
	}

	public void setGhost4(Ghost ghost4) {
		this.ghost4 = ghost4;
	}

	public int[][] getMap() {
		return this.map;
	}

	public void repaintPacman() {
		if (!this.pacman.checkCollisions(this.map)) {
			if (this.pacman.getDirection() == Direction.Right) {
				this.pacman
						.setCoordinate(new Coordinate(this.pacman.getCoordinate().getX() + this.pacman.getBlock_size(),
								this.pacman.getCoordinate().getY()));

			}
			if (this.pacman.getDirection() == Direction.Left) {
				this.pacman
						.setCoordinate(new Coordinate(this.pacman.getCoordinate().getX() - this.pacman.getBlock_size(),
								this.pacman.getCoordinate().getY()));

			}
			if (this.pacman.getDirection() == Direction.Up) {
				this.pacman.setCoordinate(new Coordinate(this.pacman.getCoordinate().getX(),
						this.pacman.getCoordinate().getY() - this.pacman.getBlock_size()));

			}
			if (this.pacman.getDirection() == Direction.Down) {
				this.pacman.setCoordinate(new Coordinate(this.pacman.getCoordinate().getX(),
						this.pacman.getCoordinate().getY() + this.pacman.getBlock_size()));

			}

		} else {
			this.pacman.setCoordinate(
					new Coordinate(this.pacman.getCoordinate().getX(), this.pacman.getCoordinate().getY()));

		}

	}

	public void repaintGhost(Ghost ghost) {

		if (!ghost.checkCollisions(this.map)) {
			if (ghost.getDirection() == Direction.Right) {
				ghost.setCoordinate(new Coordinate(ghost.getCoordinate().getX() + ghost.getBlock_size(),
						ghost.getCoordinate().getY()));

			}
			if (ghost.getDirection() == Direction.Left) {
				ghost.setCoordinate(new Coordinate(ghost.getCoordinate().getX() - ghost.getBlock_size(),
						ghost.getCoordinate().getY()));

			}
			if (ghost.getDirection() == Direction.Up) {
				ghost.setCoordinate(new Coordinate(ghost.getCoordinate().getX(),
						ghost.getCoordinate().getY() - ghost.getBlock_size()));

			}
			if (ghost.getDirection() == Direction.Down) {
				ghost.setCoordinate(new Coordinate(ghost.getCoordinate().getX(),
						ghost.getCoordinate().getY() + ghost.getBlock_size()));

			}
			if (ghost.getRandom() == 10) {

				ghost.randomGhost();
				ghost.setRandom(0);
			}
			ghost.setRandom(ghost.getRandom() + 1);

		} else {
			ghost.randomGhost();
			repaintGhost(ghost);

		}

	}

	public void checkGameOver() {
		System.out.println("checkGameOver");

		if (!pacman.isOrange()) {

			if (((ghost1.getCoordinate().getX() == pacman.getCoordinate().getX())
					&& (ghost1.getCoordinate().getY() == pacman.getCoordinate().getY()))
					|| ((ghost2.getCoordinate().getX() == pacman.getCoordinate().getX())
							&& (ghost2.getCoordinate().getY() == pacman.getCoordinate().getY()))
					|| ((ghost3.getCoordinate().getX() == pacman.getCoordinate().getX())
							&& (ghost3.getCoordinate().getY() == pacman.getCoordinate().getY()))
					|| ((ghost4.getCoordinate().getX() == pacman.getCoordinate().getX())
							&& (ghost4.getCoordinate().getY() == pacman.getCoordinate().getY()))) {

				System.out.println("tu t'es fait bouffé connard");
				pacman.setLife(pacman.getLife() - 1);
				ghost1.setCoordinate(new Coordinate(350, 350));
				ghost2.setCoordinate(new Coordinate(400, 350));
				ghost3.setCoordinate(new Coordinate(450, 350));
				ghost4.setCoordinate(new Coordinate(400, 400));
				pacman.setCoordinate(new Coordinate(100, 100));
				if (pacman.getLife() == 0) {
					System.out.println("t'as perdu!");
					gameOver = true;
				}
			}
		} else {
			
			ghostDie(ghost1);
			ghostDie(ghost2);
			ghostDie(ghost3);
			ghostDie(ghost4);

		}
	}

	public void ghostDie(Ghost ghost) {
		if ((ghost.getCoordinate().getX() == pacman.getCoordinate().getX())
				&& (ghost.getCoordinate().getY() == pacman.getCoordinate().getY())) {
			ghost.setCoordinate(new Coordinate(400, 350));
			pacman.setScore(pacman.getScore()+300);
		}
	}
	public void avoidGhost() {
		if (!pacman.isJauneP()) {
			checkGameOver();
		}
	}
	public void mazeRestart() {
		gameOver = false;
		pacman.setLife(3);
		pacman.setScore(0);
		
		this.map = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1 },
								 { 1, 0, 2, 2, 2, 2, 1, 0, 1, 2, 2, 2, 2, 4, 1 }, 
								 { 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 1 }, 
								 { 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1 },
								 { 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1 },
								 { 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1 },
								 { 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 1 }, 
								 { 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
								 { 1, 3, 2, 2, 2, 2, 1, 0, 1, 2, 2, 2, 2, 5, 1 },
								 { 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1 } };
		ghost1.setCoordinate(new Coordinate(350, 350));
		ghost2.setCoordinate(new Coordinate(400, 350));
		ghost3.setCoordinate(new Coordinate(450, 350));
		ghost4.setCoordinate(new Coordinate(400, 400));
		pacman.setCoordinate(new Coordinate(100, 100));
	}
	public void checkGame() {
		pacman.checkPacViolet(map);
		pacman.checkPacgommes(map);
		checkPacVert();
		pacman.checkScore();
		pacman.checkPortail();
		avoidGhost();
		repaintPacman();
	}
	public void checkGameGhost() {
		avoidGhost();
		ghost1.checkPortail();
		ghost2.checkPortail();
		ghost3.checkPortail();
		ghost4.checkPortail();
        repaintGhost(ghost1);
		repaintGhost(ghost2);
		repaintGhost(ghost3);
		repaintGhost(ghost4);
	}
	

}
