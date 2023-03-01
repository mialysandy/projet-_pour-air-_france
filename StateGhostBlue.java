package pacman;
import java.awt.*;
public class StateGhostBlue extends StateGhost{
	@Override
	public void action(Ghost ghost) {
		ghost.setColor(Color.blue);
		
	}

}
