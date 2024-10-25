package IceCreamGame;

public class ScienceModel
{
	
	// Science
	private int currentScience = 0;
	
	private int maximumScience = 100;
	
	private int scienceGainMultiplier = 1;
	
	private int scienceGainModifier = 1;
	
	private int scienceCashUpgradeCost = 10;
	
	private int scienceExperienceUpgradeCost = 50;
	
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
	
	// ===================================
	
	// Upgrade Checker
	
	// ===================================
	
	public boolean scienceCashUpgradeChecker()
	{
		return currentScience >= scienceCashUpgradeCost;
	}
	
	public boolean scienceExperienceUpgradeChecker()
	{
		return currentScience >= scienceExperienceUpgradeCost;

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
	
	public void updateScienceModel()
	{
		
	}
	
	public void updateScienceGainMultilier()
	{
		scienceGainMultiplier = scienceGainModifier;
	}
}
