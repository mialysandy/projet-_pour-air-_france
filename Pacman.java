package pacman;

import java.awt.*;


public class Pacman extends Personnage {
	private StatePacman statepacman;
	boolean jauneP, orange;
	private int life,cptjauneP,cptOrange;
	private final int block_size = 50;
	int score = 0,scorelife = 0;
	 private int pacgommes = 122;

	public boolean isJauneP() {
		return jauneP;
	}

	
	public void checkScore() {
		
		if(scorelife -score > 0) {
			life++;
			scorelife = 0;
		}
	}
	public void setJauneP(boolean jauneP) {
		this.jauneP = jauneP;
	}

	public Pacman(Coordinate coordinate, Direction direction, StatePacman statepacman, int life, Color color) {
		super(coordinate, direction, color);
		this.life = life;
		statepacman = new StateNormalP();
		
		// TODO Auto-generated constructor stub
	}
	
	public Pacman() {
		super(new Coordinate(100, 100), Direction.Right, Color.YELLOW);
		this.life = 3;
		statepacman = new StateNormalP();
	}

	public StatePacman getStatepacman() {
		return statepacman;
	}

	public void setStatepacman(StatePacman statepacman) {
		this.statepacman = statepacman;
	}

	public void action() {
		statepacman.action(this);
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public boolean checkPacgommes(int map[][]) {
		if (map[(this.getCoordinate().getX() / block_size) - 1][(this.getCoordinate().getY() / block_size) - 1] == 2) {
			score+=100;
			pacgommes--;
			map[(this.getCoordinate().getX() / block_size) - 1][(this.getCoordinate().getY() / block_size) - 1] = 0;
			return true;

		}
		return false;

	}

	public int getPacgommes() {
		return pacgommes;
	}


	public void setPacgommes(int pacgommes) {
		this.pacgommes = pacgommes;
	}


	public boolean checkPacViolet(int map[][]) {

		if (map[(getCoordinate().getX() / block_size) - 1][(getCoordinate().getY() / block_size) - 1] == 3) {
			statepacman = new StateViolet();
			jauneP = true;
			map[(getCoordinate().getX() / block_size) - 1][(getCoordinate().getY() / block_size) - 1] = 0;
			score += 300;
			action();
			return true;
		} else if (jauneP) {
			cptjauneP++;
			System.out.println("Jaune " +cptjauneP);
			
			if (cptjauneP >= 25) {
				
				statepacman = new StateNormalP();
				jauneP = false;
				action();
				
			}
		}
		
		return false;
	}
	
	

	public int getCptOrange() {
		return cptOrange;
	}

	public void setCptOrange(int cptOrange) {
		this.cptOrange = cptOrange;
	}

	public boolean isOrange() {
		return orange;
	}

	public void setOrange(boolean orange) {
		this.orange = orange;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
