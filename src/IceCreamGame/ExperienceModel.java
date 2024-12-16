package IceCreamGame;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 * 
 * References: 
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class:
 * 
 * The Experience Model of the Ice Cream Game that will be used in the GameModel. 
 * Contains most data related to experience fields.
 * Getters and Setters related to experience can be found here.
 * 
 */

public class ExperienceModel
{
	// Experience
	
	private int currentExperience = 0;
	
	private int experienceLevel = 1;
	
	private int experienceMultiplier = 1;

	
	private int experienceLevelUpCost = 100;
	
	// Stat Points
	
	private int experienceStatPoints = 1;
	
	private int statCashModifier = 1;
	
	private int statExperienceModifier = 1;
	
	// Experience Shop
		
	private int experienceShopEXPModifier = 1;
	
	private int experienceShopCashUpgradeCost = 400;
	
	private int experienceShopEXPUpgradeCost = 400;
	
	// Flavor
	private int flavorExpModifier = 1;

	// ===================================

	// Getter Methods
	
	// ===================================
	
	public int getCurrentExperience()
	{
		return currentExperience;
	}
	
	public int getExperienceLevel()
	{
		return experienceLevel;
	}
	
	public int getExperienceLevelUpCost()
	{
		return experienceLevelUpCost;
	}
	
	public int getExperienceStatPoints()
	{
		return experienceStatPoints;
	}
	
	public int getStatCashModifier()
	{
		return statCashModifier;
	}
	
	public int getExperienceMultiplier()
	{
		return experienceMultiplier;
	}
	
	public int getStatExperienceModifier()
	{
		return statExperienceModifier;
	}
	
	public int getExperienceShopEXPModifier()
	{
		return experienceShopEXPModifier;
	}
	
	public int getExperienceShopCashUpgradeCost()
	{
		return experienceShopCashUpgradeCost;
	}
	
	public int getExperienceShopEXPUpgradeCost()
	{
		return experienceShopEXPUpgradeCost;
	}
	
	public int getFlavorExpModifier()
	{
		return flavorExpModifier;
	}
	
	// ===================================

	// Setter Methods
	
	// ===================================
	
	public void increaseCurrentExperience()
	{
		currentExperience += experienceMultiplier;
	}
	
	public void increaseStatCashModifierLevel()
	{
		statCashModifier++;
	}
	
	public void increaseStatExperienceModifier()
	{
		statExperienceModifier++;
	}
	
	public void increaseExperienceLevel()
	{
		currentExperience -= experienceLevelUpCost;
		increaseExperienceLevelUpCost();
		experienceLevel++;
		experienceStatPoints++;
	}
	
	public void increaseExperienceLevelUpCost()
	{
		experienceLevelUpCost *= 1.05;
	}
	
	public void pickModifier()
	{
		experienceStatPoints--;
	}
	
	public void increaseExperienceShopModifier()
	{
		experienceShopEXPModifier++;
	}
	
	public void increaseExperienceShopCashUpgradeCost()
	{
		experienceShopCashUpgradeCost *= 5;
	}
	
	public void increaseExperienceShopEXPUpgradeCost()
	{
		experienceShopEXPUpgradeCost *= 3;
	}
	
	public void buyEXPShopCashUpgrade()
	{
		currentExperience -= experienceShopCashUpgradeCost;
		increaseExperienceShopCashUpgradeCost();
	}
	
	public void buyEXPShopExperienceUpgrade() 
	{
		currentExperience -= experienceShopEXPUpgradeCost;
		increaseExperienceShopModifier();
		increaseExperienceShopEXPUpgradeCost();
	}
	
	public void setFlavorExpModifier(int newModifier)
	{
		flavorExpModifier = newModifier;
	}
	
	// ===================================
	
	// Upgrade Checker
	
	// ===================================
	
	public boolean experienceLevelUpChecker()
	{
		return currentExperience >= experienceLevelUpCost;
	}
	
	public boolean experienceStatPointsChecker()
	{
		return experienceStatPoints > 0;
	}
	
	public boolean experienceShopCashUpgradeCostChecker()
	{
		return currentExperience >= experienceShopCashUpgradeCost;
	}
	
	public boolean experienceShopEXPUpgradeCostChecker()
	{
		return currentExperience >= experienceShopEXPUpgradeCost;
	}
	
	// ===================================
	
	// Constructor
	
	// ===================================
	
	public ExperienceModel()
	{
		
	}
	
	// ===================================
	
	// Updates
	
	// ===================================
	
	public void updateExperienceMultiplier()
	{
		experienceMultiplier = statExperienceModifier * experienceShopEXPModifier * flavorExpModifier;
	}
	
	public void updateExperienceModel()
	{
		
	}
	
}
