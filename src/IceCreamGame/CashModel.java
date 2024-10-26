package IceCreamGame;

public class CashModel
{
	// Cash
	private int currentCash = 0;
	
	private int cashMultiplier = 1;
	
	// Scooper
	
	private int scooperLevel = 1;
	
	private int scooperUpgradeCost = 5;
	
	private int iceCreamValueLevel = 1;
	
	private int iceCreamValueUpgradeCost = 20;
	
	// Modifiers
	
	private int shopCashModifier = 1;
	
	private int statCashModifier = 1;
	
	private int iceCreamValueModifier = 1;
	
	private int experienceShopCashmodifier = 1;
	
	// ===================================

	// Getter Methods
	
	// ===================================

	public int getCurrentCash()
	{
		return currentCash;
	}
	
	public int getCashMultiplier()
	{
		return cashMultiplier;
	}
	
	public int getScooperLevel()
	{
		return scooperLevel;
	}
	
	public int getScooperUpgradeCost()
	{
		return scooperUpgradeCost;
	}
	
	public int getIceCreamValueLevel()
	{
		return iceCreamValueLevel;
	}
	
	public int getIceCreamValueUpgradeCost()
	{
		return iceCreamValueUpgradeCost;
	}
	
	public int getEXPShopCashModifier()
	{
		return experienceShopCashmodifier;
	}
	
	// ===================================

	// Setter Methods
	
	// ===================================
	
	public void increaseCurrentCash()
	{
		currentCash += cashMultiplier;
	}
	
	public void increaseScooperLevel()
	{
		scooperLevel++;

	}
	
	public void increaseScooperUpgradeCost()
	{
		scooperUpgradeCost *= 1.2;
	}
	
	public void increaseIceCreamValueCost()
	{
		iceCreamValueUpgradeCost *= 1.5;
	}
	
	public void increaseShopCashModifier()
	{
		shopCashModifier++;
	}
	
	public void increaseStatCashModifier()
	{
		statCashModifier++;
	}
	
	public void buyScooperUpgrade()
	{
		currentCash -= scooperUpgradeCost;
		increaseScooperUpgradeCost();
		increaseScooperLevel();
		increaseShopCashModifier();
		updateCashMultiplier();
	}
	
	public void increaseIceCreamValueLevel()
	{
		iceCreamValueLevel++;
	}
	
	public void buyIceCreamValueUpgrade()
	{
		currentCash -= iceCreamValueUpgradeCost;
		increaseIceCreamValueCost();
		increaseIceCreamValueLevel();
		updateCashMultiplier();
	}
	
	public void increaseExperienceShopCashModifier()
	{
		experienceShopCashmodifier++;
	}
	
	// ===================================
	
	// Upgrade Checker
	
	// ===================================

	public boolean scooperUpgradeChecker()
	{
		return currentCash >= scooperUpgradeCost;
	}
	
	public boolean iceCreamValueUpgradeChecker()
	{
		return currentCash >= iceCreamValueUpgradeCost;
	}
	// ===================================
	
	// Constructor
	
	// ===================================
	
	public CashModel()
	{
		
	}
	
	// ===================================
	
	// Updates
	
	// ===================================
	
	public void updateCashMultiplier()
	{
		iceCreamValueModifier = iceCreamValueLevel;
		cashMultiplier = shopCashModifier * iceCreamValueModifier * statCashModifier * experienceShopCashmodifier;
	}
	
	public void updateCashModel()
	{
		
	}
	
}
