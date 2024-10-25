package IceCreamGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.*;

import javax.swing.Timer;

public class ButtonMouseListener implements MouseListener
{

	private GameModel gameModel;
	
	private InnerPanel innerPanel;
	
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
				
			innerPanel.updateInnerUI(); // Update
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
	
	public ButtonMouseListener(GameModel model, InnerPanel innerView)
	{
		this.gameModel = model;
		this.innerPanel = innerView;
	}

}
