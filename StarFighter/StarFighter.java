package StarFighter;

import javax.swing.JFrame;
import java.awt.Component;

/**
 * Runs StarFighter through a new method called StarFighter that instantiates a new OuterSpace. Contains main method.
 * @author Alice
 */
public class StarFighter extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

        /**
         * Creates a new StarFighter game by instantiating a new OuterSpace.
         */
	public StarFighter()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}
        
        /**
         * Main method to run StarFighter by instantiating a new StarFighter object
         * @param args The standard default array for main methods
         */
	public static void main( String args[] )
	{
		StarFighter run = new StarFighter();
	}
}
