package IceCreamGame;

public class ExperienceModel
{

	// Experience
	
	private int currentExperience = 0;
	
	private int experienceLevel = 1;
	
	private int experienceLevelUpCost = 100;
	
	// Stat Points
	
	private int experienceStatPoints = 1;
	
	private int statCashModifier = 1;
	
	private int statExperienceModifier = 1;
	
	private int experienceShopModifier = 1;
	
	private int experienceMultiplier = 1;
	
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
	
	public int getStatExperienceModifier()
	{
		return statExperienceModifier;
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
		experienceMultiplier = statExperienceModifier * experienceShopModifier;
	}
	
	public void updateExperienceModel()
	{
		
	}
	
}
