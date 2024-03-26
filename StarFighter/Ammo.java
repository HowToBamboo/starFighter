package StarFighter;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Extends MovingThing to create a bullet starting from the ship and moving upward into an Alien or off the screen
 * @author Alice
 */
public class Ammo extends MovingThing
{
	private int speed;

        /**
         * Default constructor that sets position to (0,0) and speed to 0
         */
	public Ammo()
	{
		this(0,0,0);
	}

        /**
         * Constructor that sets position to (x,y) and speed to 0
         * @param x Inputted x coordinate
         * @param y Inputted y coordinate
         */
	public Ammo(int x, int y)
	{
		this(x, y, 0); //add code
	}

        /**
         * Constructor that sets position to (x,y) and speed to s
         * @param x Inputted x coordinate
         * @param y Inputted y coordinate
         * @param s Inputted speed value
         */
	public Ammo(int x, int y, int s)
	{
		setPos(x, y); //add code
                setSpeed(s);
	}

        /**
         * Sets the speed of an object to s
         * @param s Inputted speed value 
         */
	public void setSpeed(int s)
	{
	   speed = s; //add code
	}

        /**
         * Gets the speed of an object
         * @return Speed value
         */
	public int getSpeed()
	{
	   return speed;
	}

        /**
         * Draws Ammo in the desired window
         * @param window Window where Ammo will be displayed
         */
	public void draw( Graphics window )
	{
            window.setColor(Color.yellow);
            window.fillRect(getX(), getY(), 5, 5); //add code to draw the ammo
	}

        /**
         * Returns String summary of Ammo's statistics
         * @return String summary of Ammos's statistics
         */
	public String toString()
	{
		return "Ammo " + getSpeed();
	}
}
