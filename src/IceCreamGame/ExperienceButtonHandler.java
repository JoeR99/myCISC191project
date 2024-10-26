package IceCreamGame;

public class ExperienceButtonHandler implements ActionHandler
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

// Stat Upgrade Experience Value Handler Class
	
// ===================================


	// ===================================

	// Stat Upgrade Cash Value Handler Class
	
	// ===================================

	class StatCashUpgradeHandler implements ActionHandler
	{
		private GameModel gameModel;
		private InnerPanel innerView;
		
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

	class StatExperienceUpgradeHandler implements ActionHandler
	{
		private GameModel gameModel;
		private InnerPanel innerView;
	
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
		private GameModel gameModel;
		private InnerPanel innerView;
		
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
		private GameModel gameModel;
		private OuterPanel outerView;
		private InnerPanel innerView;

		
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
		private GameModel gameModel;
		private OuterPanel outerView;
		private InnerPanel innerView;

		
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