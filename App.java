package pacman;

import javax.swing.JFrame;

public class App {
	public static void main(String[] args) {
		
		
		JFrame myFrame = new JFrame("PACMAN");
		myFrame.setSize(1125,1125);
        myFrame.setVisible(true);
        Vue game=new Vue();
        myKeyAdapter listener=new  myKeyAdapter(game);
        myFrame.addKeyListener(listener);
        myFrame.add(game);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
	}
}
