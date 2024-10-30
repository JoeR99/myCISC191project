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
 * Action Handler for buttons related to Cash (Cost and Gain)
 * Acts as an ActionListener but is an ActionHandler
 * 
 */

//===================================

// Cash Button Handler Class

//===================================

public class CashButtonHandler implements ActionHandler // CashButtonHandler IS-AN ActionHandler
{		
	private GameModel gameModel; // CashButtonHandler HAS-A GameModel
	private InnerPanel innerView; // CashButtonHandler HAS-AN InnerPanel
	
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
		private GameModel gameModel; // ShopCashScooperUpgradeHandler HAS-A GameModel
		private OuterPanel outerView; // ShopCashIceCreamValueUpgradeHandler HAS-AN OuterPanel
		private InnerPanel innerView; // ShopCashIceCreamValueUpgradeHandler HAS-AN InnerPanel

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
		private GameModel gameModel; // ShopCashIceCreamValueUpgradeHandler HAS-A GameModel
		private OuterPanel outerView; // ShopCashIceCreamValueUpgradeHandler HAS-AN OuterPanel
		private InnerPanel innerView; // ShopCashIceCreamValueUpgradeHandler HAS-AN InnerPanel
		
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


	
	