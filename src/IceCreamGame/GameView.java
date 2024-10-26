package IceCreamGame;

import java.awt.Dimension;
import javax.swing.JFrame;

public class GameView extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private GameModel gameModel;

	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	
	public GameView(GameModel model)
	{

		this.gameModel = model;
	
		OuterPanel outerPanel = new OuterPanel(gameModel);

		this.add(outerPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ice Cream Entrepreneur");
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void updateGameViewUI()
	{
		
	}
	
}
