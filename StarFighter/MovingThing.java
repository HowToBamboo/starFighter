package StarFighter;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Implements Locatable to create a class which sets initial position and direction of movement of a MovingThing
 * @author Alice
 */
public abstract class MovingThing implements Locatable
{
	private int xPos;
	private int yPos;

        /**
         * Default constructor that sets initial position to (0,0)
         */
	public MovingThing()
	{
            xPos = 0;
            yPos = 0;
	}

        /**
         * Constructor that sets initial position to (x,y)
         * @param x Inputted x position
         * @param y Inputted y position
         */
	public MovingThing(int x, int y)
	{
		//add more code
            setPos(x, y);
	}

        /**
         * Sets initial position to (x,y)
         * @param x Inputted x position
         * @param y Inputted y position
         */
	public void setPos( int x, int y)
	{
		//add more code
            xPos = x;
            yPos = y;
	}
        
        /**
         * Sets the initial x position to x
         * @param x Inputted x position
         */
	public void setX(int x)
	{
		//add more code
             xPos = x;
	}
        
        /**
         * Sets the initial y position to y
         * @param y Inputted y position
         */
	public void setY(int y)
	{
		//add more code
            yPos = y;
	}
        
        /**
         * Gets the x coordinate
         * @return X coordinate
         */
	public int getX()
	{
            return xPos;
	}
        
        /**
         * Gets the y coordinate
         * @return Y coordinate
         */
	public int getY()
	{
            return yPos;
	}

        /**
         * Sets speed to inputted variable
         * @param s Inputted speed value
         */
	public abstract void setSpeed( int s );
        
        /**
         * Gets speed of a MovingThing
         * @return Speed
         */
	public abstract int getSpeed();
        
        /**
         * Draws a MovingThing in a particular window
         * @param window Window display where the MovingThing should be displayed
         */
	public abstract void draw(Graphics window);

        /**
         * Sets the direction of a MovingThing's movement and moves it in that direction at its set speed
         * @param direction Inputted direction of movement
         */
	public void move(String direction)
	{
		if(direction.equals("LEFT")){
                    setX(getX()-getSpeed());
                }
                else if(direction.equals("RIGHT")){
                    setX(getX()+getSpeed());
                }
                else if(direction.equals("UP")){
                    setY(getY()+getSpeed());
                }
                else if(direction.equals("DOWN")){
                    setY(getY()-getSpeed());
                }

	}

        /**
         * Summarizes a MovingThing's statistics in a String
         * @return String summary of a MovingThing's vital statistics
         */
	public String toString()
	{
		return "Pos " + getX() + " " + getY();
	}
}
