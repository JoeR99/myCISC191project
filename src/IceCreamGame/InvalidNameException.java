package IceCreamGame;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/javax/swing/JPanel.html
 *  
 * Version/date: 12/16/2024
 * 
 * Responsibilities of class:
 * 
 * Exception handler for the store name popup in the beginning of the game.
 * Occurs when store name is below 3 letters
 * 
 */

public class InvalidNameException extends Exception
{
	public String message;

	public InvalidNameException(String message)
	{
		super(message);
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
