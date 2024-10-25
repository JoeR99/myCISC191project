package IceCreamGame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * Version/date: 10/20/2024
 * 
 * Responsibilities of class:
 * 
 * Creates a Custom JPanel with specific parameters that define its dimensional size and background color
 * 
 */

public class CustomPanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	public CustomPanel(int width, int height, Color backgroundColor)
	{
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(backgroundColor);
		
	}
	
}
