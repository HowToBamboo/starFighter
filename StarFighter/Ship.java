package StarFighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Extends MovingThing to create a Ship object to oppose the Alien object
 * @author Alice
 */
public class Ship extends MovingThing
{
	private int speed;
	private Image image;

        /**
         * Default constructor for Ship object. Sets location to (0,0) and speed to 0.
         */
	public Ship()
	{
		this(0,0,0);
	}

        /**
         * Constructor with spaces to fill in x and y coordinates. Sets position to (x,y) and speed to 0.
         * @param x Intended x position
         * @param y Intended y position
         */
	public Ship(int x, int y)
	{
		this(x,y,0);
	}

        /**
         * Constructor with spaces to fill in x and y coordinates and speed. Sets position to (x,y) and speed to s.
         * @param x Intended x position
         * @param y Intended y position
         * @param s Intended speed
         */
	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/StarFighter/ship.jpg"));
		}
		catch(Exception e)
		{

		}
	}
        
        /**
         * Sets the x coordinate of the Ship object.
         * @param x Intended x position 
         */
        public void setX(int x){
            super.setX(x);
        }
        
        /**
         * Sets the y coordinate of the Ship object.
         * @param y Intended y position 
         */
        public void setY(int y){
            super.setY(y);
        }

        /**
         * Sets the speed of the Ship object.
         * @param s Intended speed 
         */
        public void setSpeed(int s)
	{
	   speed = s; //add more code
	}

        /**
         * Gets the speed of the Ship object.
         * @return Speed value of Ship object
         */
	public int getSpeed()
	{
	   return speed;
	}

        /**
         * Draws the Ship image in the window.
         * @param window Window in which image is drawn
         */
	public void draw( Graphics window )
	{
            window.drawImage(image,getX(),getY(),80,80,null);
	}

        /**
         * Gives the Ship's numerical statistics in a String.
         * @return String with Ship's position (x and y coordinates) and speed
         */
	public String toString()
	{
            String output = "Pos " + super.getX() + " " + super.getY() + " Speed " + getSpeed();
		return output;
	}
}
