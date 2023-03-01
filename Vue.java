package pacman;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vue extends JPanel {

	private static final long serialVersionUID = 1L;
	private Maze maze = new Maze();

	private int block_size = 50;
	private int pacgomme_size = 15;

	public void paint(Graphics g) {
		super.paint(g);
		drawScoreLife(g);
		drawMaze(g);
		drawPacman(g);
		drawGhosts(g);
	}

	ActionListener pacmanAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			repaintGame();
			repaint();

		}

	};
	public Timer pacmanSpeed = new Timer(250, pacmanAction);

	public void movePacman() {
		pacmanSpeed.start();
		tG.start();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Maze getMaze() {
		return maze;
	}

	public int getBlock_size() {
		return block_size;
	}

	ActionListener actionG = new ActionListener() {
		public void actionPerformed(ActionEvent event) {

			maze.checkGameGhost();
			repaint();
		}
	};
	
	

	Timer tG = new Timer(250, actionG);
	Timer tG1 = new Timer(500, actionG);

	public boolean checkPacOrange() {

		if (maze.getMap()[(maze.getPacman().getCoordinate().getX() / block_size)
				- 1][(maze.getPacman().getCoordinate().getY() / block_size) - 1] == 4) {
			maze.getPacman().setScore(maze.getPacman().getScore() + 300);
			maze.getPacman().setOrange(true);
			maze.getMap()[(maze.getPacman().getCoordinate().getX() / block_size)
					- 1][(maze.getPacman().getCoordinate().getY() / block_size) - 1] = 0;
			maze.getPacman().setScore(maze.getPacman().getScore() + 300);
			maze.getPacman().setStatepacman(new StateOrange());
			maze.getPacman().action();
			maze.getGhost1().setStateGhost(new StateGhostBlue());
			maze.getGhost2().setStateGhost(new StateGhostBlue());
			maze.getGhost3().setStateGhost(new StateGhostBlue());
			maze.getGhost4().setStateGhost(new StateGhostBlue());
			maze.getGhost1().action();
			maze.getGhost2().action();
			maze.getGhost3().action();
			maze.getGhost4().action();
			return true;
		} else if (maze.getPacman().isOrange()) {
			tG.stop();
			tG1.start();
			maze.getPacman().setCptOrange(maze.getPacman().getCptOrange() + 1);
			System.out.println(maze.getPacman().getCptOrange());
		}
		if ((maze.getPacman().getCptOrange() >= 15)) {

			tG1.stop();
			tG.start();

			maze.getPacman().setCptOrange(0);
			maze.getPacman().setStatepacman(new StateNormalP());
			maze.getPacman().action();
			maze.getPacman().setOrange(false);
			maze.getGhost1().setStateGhost(new StateGhost1());
			maze.getGhost2().setStateGhost(new StateGhost2());
			maze.getGhost3().setStateGhost(new StateGhost3());
			maze.getGhost4().setStateGhost(new StateGhost4());
			maze.getGhost1().action();
			maze.getGhost2().action();
			maze.getGhost3().action();
			maze.getGhost4().action();

		}
		return false;
	}

	public void checkRestart() {
		if (maze.isGameOver() || maze.victoire()) {
			pacmanSpeed.stop();
			tG.stop();
			int yes_no = JOptionPane.showConfirmDialog(null, "REJOUER", "Choisissez une réponse",
					JOptionPane.YES_NO_OPTION);

			if (yes_no == JOptionPane.YES_OPTION) {
				maze.mazeRestart();
				System.out.println("REBONJOUR");
				tG.start();
				pacmanSpeed.start();
			} else if (yes_no == JOptionPane.NO_OPTION) {
				System.out.println("AU REVOIR");
			}

		}

	}

	public void drawPacman(Graphics g) {

		g.setColor(maze.getPacman().getColor());

		if (maze.getPacman().getDirection() == Direction.Right) {
			g.fillArc(maze.getPacman().getCoordinate().getX(), maze.getPacman().getCoordinate().getY(), block_size,
					block_size, 30, 300);
			g.setColor(Color.BLACK);
			g.fillOval(maze.getPacman().getCoordinate().getX() + 25, maze.getPacman().getCoordinate().getY() + 10, 5,
					5);
		} else if (maze.getPacman().getDirection() == Direction.Down) {
			g.fillArc(maze.getPacman().getCoordinate().getX(), maze.getPacman().getCoordinate().getY(), block_size,
					block_size, -60, 300);
			g.setColor(Color.BLACK);
			g.fillOval(maze.getPacman().getCoordinate().getX() + 35, maze.getPacman().getCoordinate().getY() + 25, 5,
					5);
		} else if (maze.getPacman().getDirection() == Direction.Left) {
			g.fillArc(maze.getPacman().getCoordinate().getX(), maze.getPacman().getCoordinate().getY(), block_size,
					block_size, -150, 300);
			g.setColor(Color.BLACK);
			g.fillOval(maze.getPacman().getCoordinate().getX() + 20, maze.getPacman().getCoordinate().getY() + 10, 5,
					5);
		} else if (maze.getPacman().getDirection() == Direction.Up) {
			g.fillArc(maze.getPacman().getCoordinate().getX(), maze.getPacman().getCoordinate().getY(), block_size,
					block_size, 120, 300);
			g.setColor(Color.BLACK);
			g.fillOval(maze.getPacman().getCoordinate().getX() + 10, maze.getPacman().getCoordinate().getY() + 20, 5,
					5);
		}

	}

	public void drawGhost(Graphics g, Ghost ghost) {
		g.setColor(ghost.getColor());
		g.fillRect(ghost.getCoordinate().getX(), ghost.getCoordinate().getY(), block_size - 10, block_size - 10);
		g.fillOval(ghost.getCoordinate().getX() - 5, ghost.getCoordinate().getY() - 10, block_size, block_size);
		g.setColor(Color.BLACK);
		g.fillOval(ghost.getCoordinate().getX() + 10, ghost.getCoordinate().getY() + 10, 5, 5);
		g.fillOval(ghost.getCoordinate().getX() + 20, ghost.getCoordinate().getY() + 10, 5, 5);

	}

	public void drawMaze(Graphics g) {
		for (int i = 0; i < maze.getMap().length; i++) {
			for (int j = 0; j < maze.getMap().length; j++) {
				if (maze.getMap()[i][j] == 1) {
					g.setColor(Color.BLACK);
					g.fillRect((i + 1) * block_size, (j + 1) * block_size, block_size, block_size);
				}
				if (maze.getMap()[i][j] == 2) {
					g.setColor(Color.BLUE);
					g.fillOval((i + 1) * block_size + 20, (j + 1) * block_size + 20, pacgomme_size, pacgomme_size);
					g.setColor(Color.BLACK);
				}
				if (maze.getMap()[i][j] == 3) {
					g.setColor(new Color(102, 0, 153));
					g.fillOval((i + 1) * block_size + 20, (j + 1) * block_size + 20, pacgomme_size, pacgomme_size);
					g.setColor(Color.BLACK);
				}
				if (maze.getMap()[i][j] == 4) {
					g.setColor(Color.orange);
					g.fillOval((i + 1) * block_size + 20, (j + 1) * block_size + 20, pacgomme_size, pacgomme_size);
					g.setColor(Color.BLACK);
				}
				if (maze.getMap()[i][j] == 5) {
					g.setColor(Color.GREEN);
					g.fillOval((i + 1) * block_size + 20, (j + 1) * block_size + 20, pacgomme_size, pacgomme_size);
					g.setColor(Color.BLACK);
				}

			}
		}

	}

	public void drawScoreLife(Graphics g) {
		Font currentFont = g.getFont();
		Font newFont = (currentFont.deriveFont(currentFont.getSize() * 4.5F));
		g.setFont(newFont);
		g.setColor(Color.BLACK);
		g.drawString(" SCORE", 800, 200);
		g.drawString(Integer.toString(maze.getPacman().score), 900, 250);
		g.drawString("life", 875, 385);

		for (int i = 1; i <= maze.getPacman().getLife(); i++) {
			g.fillRect(800 + (i * 50), 400, 15, 15);

		}

	}

	public void drawGhosts(Graphics g) {
		drawGhost(g, maze.getGhost1());
		drawGhost(g, maze.getGhost2());
		drawGhost(g, maze.getGhost3());
		drawGhost(g, maze.getGhost4());

	}

	public void repaintGame() {
		checkRestart();
		checkPacOrange();
		maze.checkGame();

	}
}
