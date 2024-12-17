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
 * Interface for flavor class
 * 
 */

public interface Coneable
{

	boolean isConed();
	
	void setConed(boolean state);
	
	String getCone();
	
	void setCone(String cone) ;

	String getConeSize();
	
	void setConeSize(String newConeSize);
}
