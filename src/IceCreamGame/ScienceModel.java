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
 * The Science Model of the Ice Cream Game that will be used in the GameModel. 
 * Contains most data related to science fields.
 * Getters and Setters related to science can be found here.
 * 
 */

public class ScienceModel
{
	// Science
	private int currentScience = 0;
	
	private int maximumScience = 100;
	
	private int scienceGainMultiplier = 1;
	
	private int scienceGainModifier = 1;
	
	private int statScienceModifier = 1;
	
	private int scienceCashUpgradeCost = 10;
	
	private int scienceExperienceUpgradeCost = 50;
	
	// Flavor
	private int flavorSciModifier = 1;
	
	private int coneSciModifier = 1;
	
	// ===================================

	// Getter Methods
	
	// ===================================
	
	public int getCurrentScience()
	{
		return currentScience;
	}
	
	public int getMaximumScience()
	{
		return maximumScience;
	}
	
	public int getScienceGainMultiplier()
	{
		return scienceGainMultiplier;
	}
	
	public int getScienceCashUpgradeCost()
	{
		return scienceCashUpgradeCost;
	}
	
	public int getScienceExperienceUpgradeCost()
	{
		return scienceExperienceUpgradeCost;
	}
	
	public int getStatScienceModifier()
	{
		return statScienceModifier;
	}
	
	public int getFlavorSciModifier()
	{
		return flavorSciModifier;
	}
	
	public int getConeSciModifier()
	{
		return coneSciModifier;
	}
	
	// ===================================

	// Setter Methods
	
	// ===================================
	
	public void increaseCurrentScience()
	{
		currentScience += scienceGainMultiplier;
	}
	
	public void increaseScienceGainModifier()
	{
		scienceGainModifier++;
	}
	
	public void increaseStatScienceModifier()
	{
		statScienceModifier++;
	}
	
	public void increaseMaximumScience()
	{
		maximumScience *= 1.2;
	}
	
	public void increaseScienceCashUpgradeCost()
	{
		scienceCashUpgradeCost *= 1.12;
	}
	
	public void increaseScienceExperienceUpgradeCost()
	{
		scienceExperienceUpgradeCost *= 1.15;
	}
	
	public void setScienceToMaximum()
	{
		currentScience = maximumScience;
	}
	
	public void setFlavorSciModifier(int newModifier)
	{
		flavorSciModifier = newModifier;
	}
	
	public void setConeSciModifier(int newModifier)
	{
		coneSciModifier = newModifier;
	}
	
	public void addConeSciModifier(int addModifier)
	{
		coneSciModifier += addModifier;
	}
	
	public void decreaseConeSciModifier()
	{
		coneSciModifier = 1;
	}
	
	// ===================================
	
	// Upgrade Checker | Maximum Science Checker
	
	// ===================================
	
	public boolean scienceCashUpgradeChecker()
	{
		return currentScience >= scienceCashUpgradeCost;
	}
	
	public boolean scienceExperienceUpgradeChecker()
	{
		return currentScience >= scienceExperienceUpgradeCost;

	}
	
	public boolean isScienceMaxed()
	{
		return currentScience >= maximumScience;
	}
	
	// ===================================
	
	// Constructor
	
	// ===================================
	
	public ScienceModel()
	{

	}
	
	// ===================================
	
	// Updates
	
	// ===================================
	
	public void updateScienceGainMultilier()
	{
		scienceGainMultiplier = scienceGainModifier * statScienceModifier * flavorSciModifier * coneSciModifier;
	}
	
	public void updateScienceModel()
	{
		updateScienceGainMultilier();
	}
}
