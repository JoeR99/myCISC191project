package IceCreamGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/javax/swing/JLabel.html
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class:
 * 
 * Creates a Custom JLabel with specific parameters that define its text, font, and color of the text
 * 
 */

public class CustomLabel extends JLabel // CustomLabel IS-A JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	public CustomLabel(String labelText, Font labelTextFont, Color labelTextColor) // Text, Font, Color
	{
		this.setText(labelText);
		this.setFont(labelTextFont);
		this.setForeground(labelTextColor);	
	}
}
