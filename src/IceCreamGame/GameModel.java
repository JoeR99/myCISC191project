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
	private ResearchModel researchModel; // GameModel HAS-A ResearchModel
	
	private Flavor currentFlavor = new Flavor();

	public GameModel()
	{
		this.cashModel = new CashModel();
		this.experienceModel = new ExperienceModel();
		this.scienceModel = new ScienceModel();
		this.researchModel = new ResearchModel();
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
	
	public ResearchModel getResearchModel()
	{
		return researchModel;
	}
	
	public Flavor getIceCreamFlavor()
	{
		return currentFlavor;
	}
	
	public void setCurrentFlavor(Flavor newFlavor)
	{
		currentFlavor = newFlavor;
	}
	
	public String getCurrentFlavor()
	{
		return currentFlavor.getFlavor();
	}
	
	// ===================================
	
	// Updates
	
	// ===================================
	
	public void updateGameState()
	{
		cashModel.updateCashModel();
		experienceModel.updateExperienceModel();
		scienceModel.updateScienceModel();
		researchModel.updateResearchModel();
	}
	
}
