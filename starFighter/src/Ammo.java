

import java.awt.Color;
import java.awt.Graphics;


public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x, y, 0); //add code
	}

	public Ammo(int x, int y, int s)
	{
		setPos(x, y); //add code
                setSpeed(s);
	}

	public void setSpeed(int s)
	{
	   speed = s; //add code
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
            window.setColor(Color.yellow);
            window.fillRect(getX(), getY(), 5, 5); //add code to draw the ammo
	}

	public String toString()
	{
		return "Ammo " + getSpeed();
	}
}
