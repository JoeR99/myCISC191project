package IceCreamGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/java/awt/event/ActionListener.html
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class:
 * 
 * Action Handler for buttons related to Experience and Stat Points (Cost and Gain)
 * Acts as an ActionListener but is an ActionHandler
 * 
 */

public class ExperienceButtonListener implements ActionListener// ExperienceButtonHandler IS-AN ActionHandler
{

	public ExperienceButtonListener()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}

	// ===================================

	// Stat Upgrade Cash Value Handler Class
	
	// ===================================

	class StatCashUpgradeHandler implements ActionListener
	{
		private GameModel gameModel; // StatCashUpgradeHandler HAS-A GameModel
		private InnerPanel innerView; // StatCashUpgradeHandler HAS-AN InnerPanel
		
		public StatCashUpgradeHandler(GameModel model, InnerPanel innerView)
		{
			this.gameModel = model;
			this.innerView = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if ( gameModel.getExperienceModel().experienceStatPointsChecker() == true )
			{
				gameModel.getExperienceModel().pickModifier(); // Stat Points -1
				gameModel.getCashModel().increaseStatCashModifier(); // Cash Modifier +
				gameModel.getExperienceModel().increaseStatCashModifierLevel();
			
				gameModel.getCashModel().updateCashMultiplier();
			}
			innerView.updateInnerUI(); // Update UI 	
		}
	}
	
	// ===================================

	// Stat Upgrade Experience Value Handler Class
		
	// ===================================

	class StatExperienceUpgradeHandler implements ActionListener
	{
		private GameModel gameModel; // StatExperienceUpgradeHandler HAS-A GameModel
		private InnerPanel innerPanel; // StatExperienceUpgradeHandler HAS-AN InnerPanel
		private OuterPanel outerPanel; // StatExperienceUpgradeHandler HAS-AN OuterPanel
	
		public StatExperienceUpgradeHandler(GameModel model, InnerPanel innerView, OuterPanel outerView)
		{
			this.gameModel = model;
			this.innerPanel = innerView;
			this.outerPanel = outerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if ( gameModel.getExperienceModel().experienceStatPointsChecker() == true ) 
			{
				gameModel.getExperienceModel().pickModifier(); // Stat Points -1
				gameModel.getExperienceModel().increaseStatExperienceModifier(); // EXP Modifier +1	
				
				gameModel.getExperienceModel().updateExperienceMultiplier();
			}
			innerPanel.updateInnerUI(); // Update UI
			outerPanel.updateOuterPanelUI(innerPanel);
		}
	}

	class statScienceUpgradeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // statScienceUpgradeButtonHandler HAS-A GameModel
		private InnerPanel innerPanel; // statScienceUpgradeButtonHandler HAS-AN InnerPanel
		private OuterPanel outerPanel; // statScienceUpgradeButtonHandler HAS-AN OuterPanel

		
		public statScienceUpgradeButtonHandler(GameModel model, InnerPanel innerView, OuterPanel outerView)
		{
			this.gameModel = model;
			this.innerPanel = innerView;
			this.outerPanel = outerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if ( gameModel.getExperienceModel().experienceStatPointsChecker() == true ) 
			{
				gameModel.getExperienceModel().pickModifier(); // Stat Points -1
				gameModel.getScienceModel().increaseStatScienceModifier();
				
				gameModel.getScienceModel().updateScienceGainMultilier();
			}
			innerPanel.updateInnerUI(); // Update UI 	
			outerPanel.updateOuterPanelUI(innerPanel);
		}
	}
	
	class ExperienceShopCashUpgradeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // ExperienceShopCashUpgradeButtonHandler HAS-A GameModel
		private OuterPanel outerPanel; // ExperienceShopCashUpgradeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerPanel; // ExperienceShopCashUpgradeButtonHandler HAS-AN InnerPanel

		
		public ExperienceShopCashUpgradeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerPanel = outerView;
			this.innerPanel = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if ( gameModel.getExperienceModel().experienceShopCashUpgradeCostChecker() == true )
			{
				gameModel.getExperienceModel().buyEXPShopCashUpgrade(); // Increase Cost to Upgrade and subtract EXP
				gameModel.getCashModel().increaseExperienceShopCashModifier(); // Increase Cash Modifier
				gameModel.getCashModel().updateCashMultiplier();
			}	
			outerPanel.updateOuterPanelUI(innerPanel);
		}
	}
	
	class ExperienceShopEXPUpgradeButtonHandler implements ActionListener
	{
		private GameModel gameModel; // ExperienceShopEXPUpgradeButtonHandler HAS-A GameModel
		private OuterPanel outerPanel; // ExperienceShopEXPUpgradeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerPanel; // ExperienceShopEXPUpgradeButtonHandler HAS-AN InnerPanel

		
		public ExperienceShopEXPUpgradeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerPanel = outerView;
			this.innerPanel = innerView;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if ( gameModel.getExperienceModel().experienceShopEXPUpgradeCostChecker() == true )
			{
				gameModel.getExperienceModel().buyEXPShopExperienceUpgrade(); // Increase Cost to Upgrade and subtract EXP. Increase EXP Modifier
				gameModel.getExperienceModel().updateExperienceMultiplier();
			}	
			outerPanel.updateOuterPanelUI(innerPanel);
		}
	}