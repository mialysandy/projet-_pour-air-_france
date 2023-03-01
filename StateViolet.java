package pacman;
import java.awt.*;
public class StateViolet extends StatePacman{

	@Override
	public void action(Pacman pacman) {
		pacman.setColor(new Color(255,255,204));
		System.out.println("jaune pale");
	}

}
