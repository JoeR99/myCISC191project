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
 * The Research Model of the Ice Cream Game that will be used in the GameModel. 
 * Contains most data related to research fields.
 * Getters and Setters related to research can be found here.
 * 
 */

public class ResearchModel
{
	// Research
	private int researchRate = 1;
	
	private int researchCount = 1;
	
	private int researchResModifier = 1;
	
	private int researchFlavorModifier = 1;
	
	private int coneResModifier = 1;
	
	private int researchUpgradeTimeCost = 100;
	
	// Cash
	private int researchUpgradeCashModifier = 1;
	
	private int researchCashUpgradeTimeCost = 100;
	
	// Experience
	private int researchUpgradeExpModifier = 1;
	
	private int researchExpUpgradeTimeCost = 100;
	
	// Science
	private int researchUpgradeSciModifier = 1;
	
	private int researchSciUpgradeTimeCost = 100;
	
	// ===================================

	// Getter Methods
	
	// ===================================
	public int getResearchRate()
	{
		return researchRate;
	}
	
	public int getResearchCount()
	{
		return researchCount;
	}
	
	public int getResearchResModifier()
	{
		return researchResModifier;
	}
	
	public int getFlavorResModifier()
	{
		return researchFlavorModifier;
	}
	
	public int getResearchUpgradeTimeCost()
	{
		return researchUpgradeTimeCost;
	}
	
	public int getResearchCashUpgradeTimeCost()
	{
		return researchCashUpgradeTimeCost;
	}
	
	public int getResearchExpUpgradeTimeCost()
	{
		return researchExpUpgradeTimeCost;
	}
	
	public int getResearchSciUpgradeTimeCost()
	{
		return researchSciUpgradeTimeCost;
	}
	
	public int getConeResModifier()
	{
		return coneResModifier;
	}
	
	// ===================================

	// Setter Methods
	
	// ===================================
	
	public void setFlavorResModifier(int newModifier)
	{
		researchFlavorModifier = newModifier;
	}
	
	public void increaseResearchCount() 
	{
		researchCount++;
	}
	
	public void decreaseResearchCount()
	{
		researchCount--;
	}
	
	public void increaseResearchResModifier()
	{
		researchResModifier++;
	}
	
	public void increaseResearchUpgradeCashModifier()
	{
		researchUpgradeCashModifier++;
	}
	
	public void increaseResearchUpgradeExpModifier()
	{
		researchUpgradeExpModifier++;
	}
	
	public void increaseResearchUpgradeSciModifier() 
	{
		researchUpgradeSciModifier++;
	}
	
	public void increaseResearchUpgradeTimeCost()
	{
		researchUpgradeTimeCost *= 1.1;
	}
	
	public void increaseCashResearchUpgradeTimeCost()
	{
		researchCashUpgradeTimeCost *= 1.1;
	}
	
	public void increaseExpResearchUpgradeTimeCost()
	{
		researchExpUpgradeTimeCost *= 1.1;
	}
	
	public void increaseSciResearchUpgradeTimeCost()
	{
		researchSciUpgradeTimeCost *= 1.1;
	}
	
	public void setConeResModifier(int newModifier)
	{
		coneResModifier = newModifier;
	}
	
	public void addConeResModifier(int addModifier)
	{
		coneResModifier += addModifier;
	}
	
	public void decreaseConeResModifier()
	{
		coneResModifier = 1;
	}
	
	// ===================================
	
	// Upgrade Checker
	
	// ===================================
	
	public boolean checkResearchAvailable() // Only research "one" thing at a time
	{
		if ( researchCount > 0 )
		{
			return true;
		} else {
			return false;
		}
	}
	
	// ===================================
	
	// Constructor
	
	// ===================================
	
	public ResearchModel() 
	{
		
	}
	
	// ===================================
	
	// Updates
	
	// ===================================
	
	public void updateResearchRate()
	{
		researchRate = researchResModifier * researchFlavorModifier * coneResModifier;
	}
	
	public void updateResearchModel()
	{
		updateResearchRate();
	}
}
