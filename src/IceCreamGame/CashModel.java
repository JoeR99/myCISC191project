package IceCreamGame;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 * 
 * References: 
 *  
 * Version/date: 12/16/2024
 * 
 * Responsibilities of class:
 * 
 * The Cash Model of the Ice Cream Game that will be used in the GameModel. 
 * Contains most data related to Cash fields.
 * Getters and Setters related to Cash can be found here.
 * 
 */

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
	
	private int flavorCashModifier = 1;
	
	private int coneCashModifier = 1;
	
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
	
	public int getFlavorCashModifier()
	{
		return flavorCashModifier;
	}
	
	public int getConeCashModifier()
	{
		return coneCashModifier;
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
	
	public void setFlavorCashModifier(int newModifier)
	{
		flavorCashModifier = newModifier;
	}
	
	public void decreaseConeCashModifier()
	{
		coneCashModifier = 1;
	}
	
	public void setConeCashModifier(int newModifier)
	{
		coneCashModifier = newModifier;
	}
	
	public void addConeCashModifier(int addModifier)
	{
		coneCashModifier += addModifier;
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
		cashMultiplier = shopCashModifier * iceCreamValueModifier * statCashModifier * experienceShopCashmodifier * flavorCashModifier * coneCashModifier;
	}
	
	public void updateCashModel()
	{
		updateCashMultiplier();
	}
	
}
