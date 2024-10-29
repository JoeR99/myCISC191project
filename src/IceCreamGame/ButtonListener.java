package IceCreamGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class ButtonListener implements ActionListener
{
	private static Hashtable<String, ActionHandler> actionHandlers = new Hashtable<>();
	
	public ButtonListener(String actionCommand, ActionHandler customHandler) // Game View
	{
		this.addCustomActionHandler(actionCommand, customHandler);
	}

	private void addCustomActionHandler(String actionCommand, ActionHandler customHandler)
	{
		if ( !actionHandlers.containsKey(actionCommand) ) {
			actionHandlers.put(actionCommand, customHandler);
		} else {
			System.out.println("WARNING: Action Command " + actionHandlers.get(actionCommand) + " already exists");
		}
		
		System.out.println("HashMap Size: " + actionHandlers.size());

	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand(); // Assuming the button or action has a name or command string
		
		ActionHandler handler = actionHandlers.get(actionCommand); // Look up the handler in the map and execute it
		
        if (handler != null) {
            handler.handleAction();
        } else {
            System.out.println("Unknown action: " + actionCommand);
        }
	}
	
}
