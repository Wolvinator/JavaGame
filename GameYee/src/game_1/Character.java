package game_1;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;


public class Character {
	Toolkit kit = Toolkit.getDefaultToolkit(); //Used to gather images 
	/*
	 * Store the left most point of feet(x and y) of the first sprite
	 * Store left and right distance
	 * Store up and down distance
	 * Store x distance to left most point of feet of next sprite
	 */
	public Direction direction=new Direction();
	static Painter charPainter;
	Image sprite=kit.getImage("res/Joe.png");
	double zoomFactor=2.0;
	int clWidth=0;
	int clHeight=0;
	//Distance to middle in X, distance in y, left side width, right side width, distance to new sprite, number of sprites, lapses per change, height
	double xLocation, yLocation, xLocation2,yLocation2, time,xLocation3, yLocation3;
	public Character(double x,double y,double xS, double yS, double t)
	{
		xLocation=x;	
		yLocation=y;
		xLocation2=xS;//Size of the character
		yLocation2=yS;
		xLocation3=0.5;
		yLocation3=0.5;
		
	}
	public static void setPainter( ImageObserver IO)
	{
		charPainter=new Painter(IO);
	}
	public void paintChar(Graphics2D g2d)
	{
		charPainter.paint(sprite, xLocation3, yLocation3, xLocation2*zoomFactor, yLocation2*zoomFactor, g2d);
	}
	public void changeX()
	{
		if(direction.right && xLocation+xLocation2<1)
		{
			xLocation+=0.01;
		}
		if(direction.left && xLocation>0)
		{
			xLocation-=0.01;
		}
	}
	public void changeY()
	{
		if(direction.up && yLocation+yLocation2<1)
		{
			yLocation+=0.01;
		}
		if(direction.down&& yLocation>0)
		{
			yLocation-=0.01;
		}
	}
	public BufferedImage zoom(BufferedImage clouds)
	{

		double x= xLocation-(1/(2*zoomFactor));
		double y= yLocation-(1/(2*zoomFactor));
		double size=(1/zoomFactor);
		double playerWidth=xLocation2/zoomFactor;
		double playerHeight=yLocation2/zoomFactor;
		clWidth=clouds.getWidth();
		clHeight=clouds.getHeight();
		
		//return clouds;
		System.out.println(x);
		System.out.println();
		if(x<0)
		{
			x=0;
			xLocation3=xLocation*zoomFactor;
		}
		else if((x+size)>1)
		{
			x=1.0-size;
			//xLocation3=(1.0-xLocation)*zoomFactor;
			xLocation3=(zoomFactor*(xLocation%(1/zoomFactor)));
		}
		System.out.println(y);
		if(y<0)
		{
			System.out.println("In here");
			y=0;
			yLocation3=yLocation*zoomFactor;
		}
		else if((y+size)>1)
		{
			y=1.0-size;
			//yLocation3=(1.0-yLocation)*zoomFactor;
			yLocation3=(zoomFactor*(yLocation%(1/zoomFactor)));
		}
		return clouds.getSubimage((int)(x*clWidth),(int)((1-y-size)*clHeight),(int)(size*clWidth),(int)(size*clHeight));

	}
	
	class Direction
	{
		boolean right;
		boolean left;
		boolean up;
		boolean down;
		public Direction()
		{
			right=false;
			left=false;
			up=false;
			down=false;
		}
		
		public void reset()
		{
			right=false;
			left=false;
			up=false;
			down=false;
		}
			
	}
	
}