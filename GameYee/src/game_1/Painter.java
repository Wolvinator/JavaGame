package game_1;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
public class Painter {
	static int width;
	static int height;
	ImageObserver imageOb;
	public Painter(ImageObserver IO)
	{
		imageOb=IO;
	}
	public void paint(BufferedImage toPrint,double x, double y, double wid, double hei,Graphics2D g2d)
	{
		g2d.drawImage(toPrint, (int)(x*width), (int)(height-height*(y+hei)), (int)(wid*width),(int)( hei*height), imageOb);
	}
	public void paint(Image toPrint, double x, double y, double wid, double hei,Graphics2D g2d)
	{
		g2d.drawImage(toPrint, (int)(x*width), (int)(height-height*(y+hei)), (int)(wid*width), (int)(hei*height), imageOb);
	}
	public static void setWH(int w, int h)
	{
		width=w;
		height=h;
		
	}
	
	
}
