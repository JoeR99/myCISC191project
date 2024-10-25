package IceCreamGame;


//===================================

// Cash Button Handler Class

//===================================

public class CashButtonHandler implements ActionHandler
{		
	private GameModel gameModel;
	private InnerPanel innerView;
	
	public CashButtonHandler(GameModel model, InnerPanel innerView)
	{
		this.gameModel = model;
		this.innerView = innerView;
	}
	
	@Override
	public void handleAction()
	{
		System.out.println("----- HAPPY SCOOP -----");
		gameModel.getCashModel().increaseCurrentCash();
		System.out.println("Cash: " + gameModel.getCashModel().getCurrentCash());

        innerView.updateInnerUI(); // Update UI 
	}
}

	//===================================

	// Shop Upgrade Scooper with Cash Handler Class

	//===================================

	class ShopCashScooperUpgradeHandler implements ActionHandler
	{
		
		private GameModel gameModel;
		private OuterPanel outerView;
		private InnerPanel innerView;

		public ShopCashScooperUpgradeHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
			this.gameModel = model;
			this.outerView = outerView;
			this.innerView = innerView;
		}
		
		@Override
		public void handleAction()
		{
			if ( gameModel.getCashModel().scooperUpgradeChecker() == true )
			
			gameModel.getCashModel().buyScooperUpgrade();;
			System.out.println("--- UPGRADE SCOOPER to Level: " + gameModel.getCashModel().getScooperLevel() + " ---");
			
			outerView.updateOuterPanelUI(innerView); // Update UI
		}
	}
	
	// ===================================
	
	// Shop Upgrade Ice Cream Value Handler Class
	
	// ===================================
	
	class ShopCashIceCreamValueUpgradeHandler implements ActionHandler
	{
		private GameModel gameModel;
		private OuterPanel outerView;
		private InnerPanel innerView;
		
		public ShopCashIceCreamValueUpgradeHandler(GameModel model, OuterPanel outerView, InnerPanel innerView)
		{
						this.gameModel = model;
			this.outerView = outerView;
			this.innerView = innerView;
		}
		
		@Override
		public void handleAction()
		{
			if ( gameModel.getCashModel().iceCreamValueUpgradeChecker() == true )
			{
				gameModel.getCashModel().buyIceCreamValueUpgrade();;
			}
			System.out.println("UPGRADE ICE CREAM VALUE");
			
			outerView.updateOuterPanelUI(innerView);	
		}
		

	}
	
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
				gameModel.getCashModel().increaseExperienceCashModifier(); // Cash Modifier +
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
				gameModel.getExperienceModel();
				
				
				gameModel.getExperienceModel().updateExperienceMultiplier();
			}
		
		    innerView.updateInnerUI(); // Update UI 	

		}
	}
	
	