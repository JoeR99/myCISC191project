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
 * The Main Model of the Ice Cream Game that will be used as a parameter in the GameView
 * Has access to data related to Cash, Experience, and Science fields.
 * Getters to Cash, Experience, and Science models can be found here.
 * 
 */

public class GameModel
{
	// Models
	private CashModel cashModel; // GameModel HAS-A CashModel
	private ExperienceModel experienceModel; // GameModel HAS-AN ExperienceModel
	private ScienceModel scienceModel; // GameModel HAS-A ScienceModel

	public GameModel()
	{
		this.cashModel = new CashModel();
		this.experienceModel = new ExperienceModel();
		this.scienceModel = new ScienceModel();
	}
	
	// ===================================

	// Getter Methods
	
	// ===================================
	
	public CashModel getCashModel()
	{
		return cashModel;
	}
	
	public ExperienceModel getExperienceModel()
	{
		return experienceModel;
	}
	
	public ScienceModel getScienceModel()
	{
		return scienceModel;
	}
	
	// ===================================
	
	// Updates
	
	// ===================================
	
	public void updateGameState()
	{
		cashModel.updateCashModel();
		experienceModel.updateExperienceModel();
		scienceModel.updateScienceModel();
	}
	
}
