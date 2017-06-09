package game_1;

import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class Character {
	Toolkit kit = Toolkit.getDefaultToolkit(); //Used to gather images 
	/*
	 * Store the left most point of feet(x and y) of the first sprite
	 * Store left and right distance
	 * Store up and down distance
	 * Store x distance to left most point of feet of next sprite
	 */
	static Painter charPainter;

	
	//Distance to middle in X, distance in y, left side width, right side width, distance to new sprite, number of sprites, lapses per change, height
	double xLocation, yLocation, xLocation2,yLocation2, time;
	public Character(double x,double y,double xS, double yS, double t)
	{
		xLocation=x;	
		yLocation=y;
		xLocation2=xS;
		yLocation2=yS;
		
	}
	public static void setPainter( ImageObserver IO)
	{
		charPainter=new Painter(IO);
	}
	
	
}