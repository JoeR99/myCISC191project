package IceCreamGame;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/java/awt/event/ActionListener.html
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class:
 * 
 * Simple interface that acts as a middle man for my ButtonListener. Performs similar to an ActionListener.
 * The class ButtonListener will take in any ActionHandler class made to function with this type of ActionHandler object
 * 
 */

public interface ActionHandler
{
	void handleAction();	
}
