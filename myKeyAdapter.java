package pacman;

import java.awt.event.*;

public class myKeyAdapter extends KeyAdapter {
	private Vue game;

	public myKeyAdapter(Vue game) {
		super();
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'z':
			game.getMaze().getPacman().move('z');
			game.movePacman();
			
			break;
		case 's':
			game.getMaze().getPacman().move('s');
			game.movePacman();
			
			break;
		case 'q':
			game.getMaze().getPacman().move('q');
			game.movePacman();
			
			break;
		case 'd':
			game.getMaze().getPacman().move('d');
			game.movePacman();
			
			break;	
		}

	}

}
