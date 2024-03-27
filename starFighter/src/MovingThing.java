
import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing
{
	private int xPos;
	private int yPos;

	public MovingThing()
	{
            xPos = 0;
            yPos = 0;
	}

	public MovingThing(int x, int y)
	{
		//add more code
            setPos(x, y);
	}

	public void setPos( int x, int y)
	{
		//add more code
            xPos = x;
            yPos = y;
	}

	public void setX(int x)
	{
		//add more code
             xPos = x;
	}

	public void setY(int y)
	{
		//add more code
            yPos = y;
	}

	public int getX()
	{
            return xPos;
	}

	public int getY()
	{
            return yPos;
	}

	public abstract void setSpeed( int s );

	public abstract int getSpeed();

	public abstract void draw(Graphics window);

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

	public String toString()
	{
		return "Pos " + getX() + " " + getY();
	}
}
