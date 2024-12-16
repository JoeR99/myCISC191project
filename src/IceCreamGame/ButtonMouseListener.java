package IceCreamGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.*;

import javax.swing.Timer;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/java/awt/event/MouseListener.html
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class:
 * 
 * Mouse Listener for the Scooping Button. Currently increase cash and exp when mouse hovers over the button with this listener added to it.
 * 
 */

public class ButtonMouseListener implements MouseListener // ButtonMouseListener IS-A MouseListener
{

	private GameModel gameModel; // ButtonMouseListener HAS-A GameModel
	
	private InnerPanel innerPanel; // ButtonMouseListener HAS-AN InnerPanel
	
	private OuterPanel outerPanel; // ButtonMouseListener HAS-AN OuterPanel
	
	Timer timer = new Timer(10, new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("----- SCOOP -----");
			
			gameModel.getCashModel().increaseCurrentCash();
			System.out.println("Cash: " + gameModel.getCashModel().getCurrentCash());
			
			gameModel.getExperienceModel().increaseCurrentExperience();
			System.out.println("Experience: " + gameModel.getExperienceModel().getCurrentExperience());
			
			if ( gameModel.getExperienceModel().experienceLevelUpChecker() ==  true )
			{
				gameModel.getExperienceModel().increaseExperienceLevel();
			}
				
			outerPanel.updateOuterPanelUI(innerPanel); // Update
		}
	});
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		timer.start();
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		timer.stop();
	}
	
	public ButtonMouseListener(GameModel model, InnerPanel innerView, OuterPanel outerView)
	{
		this.gameModel = model;
		this.innerPanel = innerView;
		this.outerPanel = outerView;
	}

}
