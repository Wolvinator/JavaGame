package game_1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
/**
 * Game now extends JPanel, takes properties of its superclass
 * Create the JFrame code in the main method
 * Receive key inputs and send the to the action class
 * Create a Painter and print a background
 **/
@SuppressWarnings("serial")
public class Game extends JPanel{
static Game game;
static Painter gamePainter;
static double time =0.030;//Time in seconds between reprints
private static JPanel mainPanel;


Toolkit kit = Toolkit.getDefaultToolkit(); //Temporary, proof of concept
Image clouds=kit.getImage("res/gif.gif");
	
	
	
	public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Game Frame");
        frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH ); //Maximize the frame
        game=new Game();
        frame.add(KeyInputPanel());//Add Key Reception
        frame.add(game);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            game.repaint();//Repaint the game every time*1000 milliseconds
            Thread.sleep((int)(time*1000));
        }
    }
	
	
	
	
	public void paint(Graphics g)
	 {
	    super.paint(g);
	    int x=getWidth();
	    int y=getHeight();
	    Painter.setWH(x, y);
	    Graphics2D g2d = (Graphics2D) g;
	    if(gamePainter==null)gamePainter=new Painter(this);
	    if(Character.charPainter==null)Character.charPainter=new Painter(this);
	    gamePainter.paint(clouds, 0.0, 0.0, 1.0, 1.0, g2d);
	}
	
	
	
	
	
	
	
	static JPanel KeyInputPanel(){
		mainPanel=new JPanel();
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "upR");
		mainPanel.getActionMap().put("up", new Action("up"));
		mainPanel.getActionMap().put("upR", new Action("upR"));

		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "rightR");
		mainPanel.getActionMap().put("right", new Action("right"));
		mainPanel.getActionMap().put("rightR", new Action("rightR"));
		
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "leftR");
		mainPanel.getActionMap().put("left", new Action("left"));
		mainPanel.getActionMap().put("leftR", new Action("leftR"));
		
		return mainPanel;
		
	}
	
	static class Action extends AbstractAction
    {
		String action;
		public Action(String command){
			action=command;
		}
        public void actionPerformed( ActionEvent tf )
        {
            //Do something with each action
        	System.out.println("Performed an action");
        } 

    }
}
