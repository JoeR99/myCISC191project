package IceCreamGame;

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

public class ExperienceButtonHandler implements ActionHandler // ExperienceButtonHandler IS-AN ActionHandler
{

	public ExperienceButtonHandler()
	{
		
	}
	
	@Override
	public void handleAction()
	{
		// TODO Auto-generated method stub
		
	}

}

	// ===================================

	// Stat Upgrade Cash Value Handler Class
	
	// ===================================

	class StatCashUpgradeHandler implements ActionHandler
	{
		private GameModel gameModel; // StatCashUpgradeHandler HAS-A GameModel
		private InnerPanel innerView; // StatCashUpgradeHandler HAS-AN InnerPanel
		
		public StatCashUpgradeHandler(GameModel model, InnerPanel innerView)
		{
			this.gameModel = model;
			this.innerView = innerView;
		}

		@Override
		public void handleAction()
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

	class StatExperienceUpgradeHandler implements ActionHandler
	{
		private GameModel gameModel; // StatExperienceUpgradeHandler HAS-A GameModel
		private InnerPanel innerView; // StatExperienceUpgradeHandler HAS-AN InnerPanel
	
		public StatExperienceUpgradeHandler(GameModel model, InnerPanel innerView)
		{
			this.gameModel = model;
			this.innerView = innerView;
		}

		@Override
		public void handleAction()
		{
			if ( gameModel.getExperienceModel().experienceStatPointsChecker() == true ) 
			{
				gameModel.getExperienceModel().pickModifier(); // Stat Points -1
				gameModel.getExperienceModel().increaseStatExperienceModifier(); // EXP Modifier +1	
				
				gameModel.getExperienceModel().updateExperienceMultiplier();
			}
			innerView.updateInnerUI(); // Update UI 	
		}
	}

	class statScienceUpgradeButtonHandler implements ActionHandler
	{
		private GameModel gameModel; // statScienceUpgradeButtonHandler HAS-A GameModel
		private InnerPanel innerView; // statScienceUpgradeButtonHandler HAS-AN InnerPanel
		
		public statScienceUpgradeButtonHandler(GameModel model, InnerPanel innerView)
		{
			this.gameModel = model;
			this.innerView = innerView;
		}

		@Override
		public void handleAction()
		{
			if ( gameModel.getExperienceModel().experienceStatPointsChecker() == true ) 
			{
				gameModel.getExperienceModel().pickModifier(); // Stat Points -1
				gameModel.getScienceModel().increaseStatScienceModifier();
				
				gameModel.getScienceModel().updateScienceGainMultilier();
			}
			innerView.updateInnerUI(); // Update UI 	
		}
	}
	
	class ExperienceShopCashUpgradeButtonHandler implements ActionHandler
	{
		private GameModel gameModel; // ExperienceShopCashUpgradeButtonHandler HAS-A GameModel
		private OuterPanel outerView; // ExperienceShopCashUpgradeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerView; // ExperienceShopCashUpgradeButtonHandler HAS-AN InnerPanel

		
		public ExperienceShopCashUpgradeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerView = outerView;
			this.innerView = innerView;
		}

		@Override
		public void handleAction()
		{
			if ( gameModel.getExperienceModel().experienceShopCashUpgradeCostChecker() == true )
			{
				gameModel.getExperienceModel().buyEXPShopCashUpgrade(); // Increase Cost to Upgrade and subtract EXP
				gameModel.getCashModel().increaseExperienceShopCashModifier(); // Increase Cash Modifier
				gameModel.getCashModel().updateCashMultiplier();
			}	
			outerView.updateOuterPanelUI(innerView);
		}
	}
	
	class ExperienceShopEXPUpgradeButtonHandler implements ActionHandler
	{
		private GameModel gameModel; // ExperienceShopEXPUpgradeButtonHandler HAS-A GameModel
		private OuterPanel outerView; // ExperienceShopEXPUpgradeButtonHandler HAS-AN OuterPanel
		private InnerPanel innerView; // ExperienceShopEXPUpgradeButtonHandler HAS-AN InnerPanel

		
		public ExperienceShopEXPUpgradeButtonHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerView = outerView;
			this.innerView = innerView;
		}

		@Override
		public void handleAction()
		{
			if ( gameModel.getExperienceModel().experienceShopEXPUpgradeCostChecker() == true )
			{
				gameModel.getExperienceModel().buyEXPShopExperienceUpgrade(); // Increase Cost to Upgrade and subtract EXP. Increase EXP Modifier
				gameModel.getExperienceModel().updateExperienceMultiplier();
			}	
			outerView.updateOuterPanelUI(innerView);
		}
	}