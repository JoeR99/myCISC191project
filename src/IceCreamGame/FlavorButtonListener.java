package IceCreamGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/javax/swing/JPanel.html
 *  
 * Version/date: 12/16/2024
 * 
 * Responsibilities of class:
 * 
 * Action Listener for flavor buttons. Changes flavor modifiers and cone size modifiers
 * 
 */

public class FlavorButtonListener implements ActionListener
{
	private GameModel gameModel; // FlavorButtonListener HAS-A GameModel
	private OuterPanel outerPanel; // FlavorButtonListener HAS-AN OuterPanel
	private InnerPanel innerPanel; // FlavorButtonListener HAS-AN InnerPanel
	
	private HashMap<String, Flavor> flavorMap;

	public FlavorButtonListener(GameModel model, OuterPanel outerView, InnerPanel innerView ,HashMap<String, Flavor> map)
	{
		this.gameModel = model;
		this.outerPanel = outerView;
		this.innerPanel = innerView;
		this.flavorMap = map;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();
		Flavor selectedFlavor = flavorMap.get(actionCommand);
		
		// TODO Auto-generated method stub
		switch(selectedFlavor.getFlavor())
		{
			case "Vanilla" :
				gameModel.getCashModel().setFlavorCashModifier(selectedFlavor.getCashModifier());
				gameModel.getExperienceModel().setFlavorExpModifier(selectedFlavor.getExpModifier());
				gameModel.getScienceModel().setFlavorSciModifier(selectedFlavor.getSciModifier());
				gameModel.getResearchModel().setFlavorResModifier(selectedFlavor.getResModifier());
				
				gameModel.setCurrentFlavor(selectedFlavor);
				
				gameModel.updateGameState(); // Update Models, First
				outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second

			break;
			
			case "Chocolate" :
				gameModel.getCashModel().setFlavorCashModifier(selectedFlavor.getCashModifier());
				gameModel.getExperienceModel().setFlavorExpModifier(selectedFlavor.getExpModifier());
				gameModel.getScienceModel().setFlavorSciModifier(selectedFlavor.getSciModifier());
				gameModel.getResearchModel().setFlavorResModifier(selectedFlavor.getResModifier());	
				
				gameModel.setCurrentFlavor(selectedFlavor);

				
				gameModel.updateGameState(); // Update Models, First
				outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second

			break;
			
			case "Strawberry" :
				gameModel.getCashModel().setFlavorCashModifier(selectedFlavor.getCashModifier());
				gameModel.getExperienceModel().setFlavorExpModifier(selectedFlavor.getExpModifier());
				gameModel.getScienceModel().setFlavorSciModifier(selectedFlavor.getSciModifier());
				gameModel.getResearchModel().setFlavorResModifier(selectedFlavor.getResModifier());
				
				gameModel.setCurrentFlavor(selectedFlavor);

				
				gameModel.updateGameState(); // Update Models, First
				outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
			break;
			
			case "Neopolitan" :
				gameModel.getCashModel().setFlavorCashModifier(selectedFlavor.getCashModifier());
				gameModel.getExperienceModel().setFlavorExpModifier(selectedFlavor.getExpModifier());
				gameModel.getScienceModel().setFlavorSciModifier(selectedFlavor.getSciModifier());
				gameModel.getResearchModel().setFlavorResModifier(selectedFlavor.getResModifier());
				
				gameModel.setCurrentFlavor(selectedFlavor);

				
				gameModel.updateGameState(); // Update Models
				outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
			break;
			
			case "Mint" :
				gameModel.getCashModel().setFlavorCashModifier(selectedFlavor.getCashModifier());
				gameModel.getExperienceModel().setFlavorExpModifier(selectedFlavor.getExpModifier());
				gameModel.getScienceModel().setFlavorSciModifier(selectedFlavor.getSciModifier());
				gameModel.getResearchModel().setFlavorResModifier(selectedFlavor.getResModifier());
				
				gameModel.setCurrentFlavor(selectedFlavor);

				
				gameModel.updateGameState(); // Update Models, First
				outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
			break;
			
			default:
				gameModel.getCashModel().setFlavorCashModifier(1);
				gameModel.getExperienceModel().setFlavorExpModifier(1);
				gameModel.getScienceModel().setFlavorSciModifier(1);
				gameModel.getResearchModel().setFlavorResModifier(1);
				
				gameModel.setCurrentFlavor(selectedFlavor);

				
				gameModel.updateGameState(); // Update Models, First
				outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
		}
	}
}
	// Handles action for cone radio button, sets state to true
	class ConeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // ConeButtonHandler HAS-A GameModel
		private OuterPanel outerPanel; // ConeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerPanel; // ConeButtonHandler HAS-AN InnerPanel
		
		public ConeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerPanel = outerView;
			this.innerPanel = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			gameModel.getIceCreamFlavor().setCone("Coned");
			gameModel.getIceCreamFlavor().setConed(true);
			gameModel.getCashModel().setConeCashModifier(5);
			gameModel.getExperienceModel().setConeExpModifier(4);
			gameModel.getScienceModel().setConeSciModifier(3);
			gameModel.getResearchModel().setConeResModifier(2);
			
			gameModel.updateGameState(); // Update Models, First
			outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
		}
	}
	
	// Handles action for cone radio button, sets state to false
	class NoConeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // NoConeButtonHandler HAS-A GameModel
		private OuterPanel outerPanel; // NoConeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerPanel; // NoConeButtonHandler HAS-AN InnerPanel
		
		public NoConeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerPanel = outerView;
			this.innerPanel = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			gameModel.getIceCreamFlavor().setCone("Not Coned");
			gameModel.getIceCreamFlavor().setConed(false);
			gameModel.getCashModel().decreaseConeCashModifier();
			gameModel.getExperienceModel().decreaseConeExpModifier();
			gameModel.getScienceModel().decreaseConeSciModifier();
			gameModel.getResearchModel().decreaseConeResModifier();

			gameModel.updateGameState(); // Update Models, First
			outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
		}
	}
	
	// Handles action for small cone size radio button, sets state to small
	class SmallConeSizeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // ConeSizeButtonHandler HAS-A GameModel
		private OuterPanel outerPanel; // ConeSizeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerPanel; // ConeSizeButtonHandler HAS-AN InnerPanel
		
		public SmallConeSizeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerPanel = outerView;
			this.innerPanel = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if ( gameModel.getIceCreamFlavor().isConed() == true )
			{
				gameModel.getIceCreamFlavor().setConeSize("small");
				gameModel.getCashModel().addConeCashModifier(1);
				gameModel.getExperienceModel().addConeExpModifier(1);
				gameModel.getScienceModel().addConeSciModifier(1);
				gameModel.getResearchModel().addConeResModifier(1);
			} else {
				gameModel.getCashModel().decreaseConeCashModifier();
				gameModel.getExperienceModel().decreaseConeExpModifier();
				gameModel.getScienceModel().decreaseConeSciModifier();
				gameModel.getResearchModel().decreaseConeResModifier();
			}
			
			gameModel.updateGameState(); // Update Models, First
			outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
		}
	}
	
	// Handles action for small cone size radio button, sets state to small
	class MediumConeSizeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // ConeSizeButtonHandler HAS-A GameModel
		private OuterPanel outerPanel; // ConeSizeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerPanel; // ConeSizeButtonHandler HAS-AN InnerPanel
		
		public MediumConeSizeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerPanel = outerView;
			this.innerPanel = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if ( gameModel.getIceCreamFlavor().isConed() == true )
			{
				gameModel.getIceCreamFlavor().setConeSize("small");
				gameModel.getCashModel().addConeCashModifier(5);
				gameModel.getExperienceModel().addConeExpModifier(5);
				gameModel.getScienceModel().addConeSciModifier(5);
				gameModel.getResearchModel().addConeResModifier(5);
			} else {
				gameModel.getCashModel().decreaseConeCashModifier();
				gameModel.getExperienceModel().decreaseConeExpModifier();
				gameModel.getScienceModel().decreaseConeSciModifier();
				gameModel.getResearchModel().decreaseConeResModifier();
			}
			
			gameModel.updateGameState(); // Update Models, First
			outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
		}
	}
	
	// Handles action for small cone size radio button, sets state to small
	class LargeConeSizeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // ConeSizeButtonHandler HAS-A GameModel
		private OuterPanel outerPanel; // ConeSizeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerPanel; // ConeSizeButtonHandler HAS-AN InnerPanel
		
		public LargeConeSizeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerPanel = outerView;
			this.innerPanel = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if ( gameModel.getIceCreamFlavor().isConed() == true )
			{
				gameModel.getIceCreamFlavor().setConeSize("small");
				gameModel.getCashModel().addConeCashModifier(10);
				gameModel.getExperienceModel().addConeExpModifier(10);
				gameModel.getScienceModel().addConeSciModifier(10);
				gameModel.getResearchModel().addConeResModifier(10);
			} else {
				gameModel.getCashModel().decreaseConeCashModifier();
				gameModel.getExperienceModel().decreaseConeExpModifier();
				gameModel.getScienceModel().decreaseConeSciModifier();
				gameModel.getResearchModel().decreaseConeResModifier();
			}
			
			gameModel.updateGameState(); // Update Models, First
			outerPanel.updateOuterPanelUI(innerPanel); // Update GUI, Second
		}
	}
