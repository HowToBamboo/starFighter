
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(0,0,0);
	}

	public Ship(int x, int y)
	{
		this(x,y,0);
	}

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

        public void setX(int x){
            super.setX(x);
        }

        public void setY(int y){
            super.setY(y);
        }

        public void setSpeed(int s)
	{
	   speed = s; //add more code
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
            window.drawImage(image,getX(),getY(),80,80,null);
	}

	public String toString()
	{
            String output = "Pos " + super.getX() + " " + super.getY() + " Speed " + getSpeed();
		return output;
	}
}
