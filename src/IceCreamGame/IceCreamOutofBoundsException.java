package IceCreamGame;

public class IceCreamOutofBoundsException extends Exception
{

	public String message;

	public IceCreamOutofBoundsException(String message)
	{
		super();
		this.message = message;
	}

	public String getMessage()
	{
		return "Error: " + message;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8130691230266475698L;

}
