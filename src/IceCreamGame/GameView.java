package IceCreamGame;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/javax/swing/JFrame.html
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class: 
 * 
 * Main JFrame that aggregates the GameModel as a parameter and creates an OuterPanel upon creation.
 * Has the usual suspects such as an existing operation and setting visibility to true. 
 * Setting the title, size, and image of the window.
 * Sets the location of the window to be in the middle of the monitor for QOL.
 * 
 */

public class GameView extends JFrame // GameView IS-A JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameModel gameModel; // GameView HAS-A GameModel

	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	private ImageIcon iceCreamGameIcon = new ImageIcon("images/IceCreamGameIcon.png");
	
	public GameView(GameModel model)
	{

		this.gameModel = model;
	
		OuterPanel outerPanel = new OuterPanel(gameModel);
		Image iconImage = iceCreamGameIcon.getImage();

		this.add(outerPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ice Cream Entrepreneur");
		this.setIconImage(iconImage);
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void updateGameViewUI()
	{
		
	}
	
}
