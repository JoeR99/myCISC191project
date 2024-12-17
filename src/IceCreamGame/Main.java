package IceCreamGame;

import javax.swing.JOptionPane;

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
 * Starts the Ice Cream Game. But after you answer the question!
 * 
 */

public class Main
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
//		new GameView(new GameModel());
		
		boolean isValidName = false;
		String storeName = null;
		
        while (!isValidName) 
        {
            try 
            {
                // Prompt the user for their name
            	storeName = JOptionPane.showInputDialog(
                        null,
                        "Please enter the name of your Ice Cream Parlor:",
                        "Welcome to Ice Cream Game",
                        JOptionPane.PLAIN_MESSAGE
                );
		
            validateName(storeName); // Call validation method
            isValidName = true; // If no exception is thrown, the name is valid

        } catch (InvalidNameException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (NullPointerException e) { // Handle "Cancel" or null input
            JOptionPane.showMessageDialog(
                    null,
                    "No name entered. Exiting game.",
                    "Exit",
                    JOptionPane.WARNING_MESSAGE
            );
            System.exit(0);
        	}
        }
        // Start the game with the validated name
        startGameWindow(storeName);
	}
	
    // Validation method that throws a custom exception
    private static void validateName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be empty. Please try again.");
        }
        if (name.length() < 3) {
            throw new InvalidNameException("Name must be at least 3 characters long.");
        }
        // Add more rules if needed (e.g., no special characters)
    }
    
    private static void startGameWindow(String storeName) {

    	new GameView(new GameModel(), storeName);

        System.out.println("Store Name: " + storeName);
    }
	
}

