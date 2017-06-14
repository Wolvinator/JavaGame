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
	int zoomFactor=1;
	int yzoomFactor=1;
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
		charPainter.paint(sprite, xLocation3, yLocation3, xLocation2*zoomFactor, yLocation2*yzoomFactor, g2d);
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
	public BufferedImage zoom(BufferedImage clouds)
	{

		clWidth=clouds.getWidth();
		


		clHeight=clouds.getHeight();
		int x = (int)(clWidth*(xLocation-((zoomFactor-1)/2)*xLocation2));
		int y=(int)(clHeight*(yLocation-((yzoomFactor-1)/2)*yLocation2));
		int xS=(int)(clWidth*(xLocation2*zoomFactor));
		int yS=(int)(clHeight*(yLocation2*yzoomFactor));
		double xSize=((double)xS/(double)clWidth);
		if(x<0)
		{
			x=0;
			xLocation3=xLocation/xSize;
		}
		else if(x+xS>clWidth)
		{
			x=clWidth-xS;
			xLocation3=1.0-((1.0-xLocation)/xSize);
		}
		if(y<0)y=0;
		else if(y+yS>clHeight)y=clHeight-yS;
		return clouds.getSubimage(x,y,xS,yS);
		
		//return clouds;
	}
	
	class Direction
	{
		boolean right;
		boolean left;
		boolean up;
		public Direction()
		{
			right=false;
			left=false;
			up=false;
		}
		
		public void reset()
		{
			right=false;
			left=false;
			up=false;
		}
			
	}
	
}