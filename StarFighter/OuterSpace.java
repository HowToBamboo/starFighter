package StarFighter;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * Extends Canvas to paint the display with a black background and paint moving aliens, ammo, and the ship onto it
 * @author Alice
 */
public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;

	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	
	private boolean[] keys;
	private BufferedImage back;
        private final int ALIEN_ATTACK = 2000;//2 seconds
        private Timer addAlienTimer;

        /**
         * Default constructor that instantiates all instance variables and sets the background color to black, then calls methods to start the game
         */
	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
                ship = new Ship(400, 450, 5);
                aliens= new ArrayList<Alien>();
                    aliens.add(new Alien(250,50,2));
                    aliens.add(new Alien(450,50,2));
                    aliens.add(new Alien(650,50,2));
                    aliens.add(new Alien(950,50,2));
                
                shots = new ArrayList<Ammo>();

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);

                startAttack();
                moreAliens();

	}
        
        /**
         * Updates the window by painting it
         * @param window The window display that should be updated
         */
        public void update(Graphics window)
        {
                paint(window);
        }

        /**
         * Paints the window with appropriate objects and images, painting over them when they disappear
         * @param window The window display that should be painted
         */
	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
 
		if(keys[0] == true){
                    if(ship.getX() > 10){
                        ship.move("LEFT");
                    }
		}
                if(keys[1] == true){
                    if(ship.getX() < 700){
                        ship.move("RIGHT");
                    }
                }
                if(keys[2] == true){
                    if(ship.getY() > 10){
                        ship.move("DOWN");
                    }
                }
                if(keys[3] == true){
                    if(ship.getY() < 500){
                        ship.move("UP");
                    } 
                }
                if(keys[4] == true){
                   Ammo shot = new Ammo(ship.getX()+28, ship.getY(), 5);
                   shots.add(shot);
                   keys[4]=false;
                }
                                
                for(Alien a : aliens)

                {
                    a.draw(graphToBack);
                    if(a.getX() <= 1000)
                    {
                        if(a.getX()>900)
                            a.setX(-20);
                    }
                    a.move("RIGHT");

                    for(Ammo s: shots)
                    {

                        if(a.getX()>=s.getX() && a.getX()<=s.getX()+100 && a.getY()>=s.getY() && a.getY() <= s.getY()+80)
                        {
                            aliens.remove(a);
                            shots.remove(s);
                        }

                    }
                }

                for(Ammo s : shots){
                    s.draw(graphToBack);
                    s.move("DOWN");
                }

                for(Ammo s : shots)
                {
                    if(s.getY()<=0)
                    {
                        shots.remove(s);
                    }
                }
            
            ship.draw(graphToBack);
            twoDGraph.drawImage(back, null, 0, 0);

	}
        
        /**
         * Checks to see which key has been pressed if one is pressed and sets that key's boolean value to true, then repaints based on the action triggered by that key
         * @param e Key that is pressed
         */
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

        /**
         * Checks to see which key has been released if one is released and sets that key's boolean value to false, then repaints by negating the action triggered by that key
         * @param e Key that is pressed
         */
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

        /**
         * Checks to see if a character key is typed (in the event of multiple players/ships)
         * @param e Key that is pressed
         */
	public void keyTyped(KeyEvent e)
	{

	}
        
        /**
         * Adds more Aliens in random locations based on weather the game has stopped
         */
        public void moreAliens(){

            int x = (int)(Math.random()*getWidth());
            int y = (int)(Math.random()*(getHeight()-200));

            if(addAlienTimer.isRunning()){
                aliens.add(new Alien(x,y,2));
                System.out.println("new Alien!" + " "+ x + " " +y);
            }
        }

        /**
         * Begins the game by setting up the AlienTimer and sets up conditions for when and how to run it
         */
        public void startAttack(){
            if(addAlienTimer == null){

                addAlienTimer = new Timer(ALIEN_ATTACK, new OuterSpace.TimerHandler());
                addAlienTimer.start();

            }
            else{
                if(! addAlienTimer.isRunning()){
                    addAlienTimer.restart();

                }
            }
        }
    
        /**
         * Creates more Aliens
         */
        private class TimerHandler implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent){
            moreAliens();
            }
        }

        /**
         * Runs repainting, timing and Alien adding actions for OuterSpace
         */
        public void run()
        {
            try
            {
                while(true)
                {
                    Thread.currentThread().sleep(5);
                    repaint();
                }
            }
            catch(Exception e)
            {

            }
        }

}


