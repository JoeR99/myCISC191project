package IceCreamGame;


public class GameModel
{
	// Models
	private CashModel cashModel;
	private ExperienceModel experienceModel;
	private ScienceModel scienceModel;

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
