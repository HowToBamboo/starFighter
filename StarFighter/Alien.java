package StarFighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Extends MovingThing to create a moving Alien object to oppose the Ship object
 * @author Alice
 */
public class Alien extends MovingThing
{
	private int speed;
	private Image image;

        /**
         * Default constructor that sets initial position to (0,0) and speed to 0
         */
	public Alien()
	{
		this(0,0,0);
	}

        /**
         * Constructor that sets initial position to (x,y) and speed to 0
         * @param x Inputted x coordinate
         * @param y Inputted y coordinate
         */
	public Alien(int x, int y)
	{
		this(x,y,0);
	}

        /**
         * Constructor that sets initial position to (x,y) and speed to s
         * @param x Inputted x coordinate
         * @param y Inputted y coordinate
         * @param s Inputted speed value
         */
	public Alien(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/StarFighter/alien.jpg"));
		}
		catch(Exception e)
		{

		}
	}

        /**
         * Sets speed of Alien to s
         * @param s Inputted speed value 
         */
	public void setSpeed(int s)
	{
	   speed = s; //add code
	}

        /**
         * Gets speed of Alien
         * @return Speed value
         */
	public int getSpeed()
	{
	   return speed;
	}

        /**
         * Draws Alien in a given window
         * @param window Window where Alien will be displayed
         */
	public void draw( Graphics window )
	{
            window.drawImage(image,getX(),getY(),80,80,null);
	}

        /**
         * Returns a String with the Alien's statistics
         * @return String with Alien's vital statistics
         */
	public String toString()
	{
		return "Alien " + super.toString() + " Speed " + getSpeed();
	}
}
