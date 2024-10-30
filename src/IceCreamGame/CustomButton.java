package IceCreamGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 * 
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/javax/swing/JButton.html
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class:
 * 
 * Creates a Custom JButton with specific parameters that define its dimensional size, text and background color, the text of the button, and the icon of the button
 * 
 */

public class CustomButton extends JButton // CustomButton IS-A JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	public CustomButton()
	{
		this.setFocusable(false);
	}
	
	public CustomButton(int width, int height, Color backgroundColor)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);
	}
	
	public CustomButton(int width, int height, Color backgroundColor, String actionCommand)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);
		this.setActionCommand(actionCommand);
	}
	
	public CustomButton(int width, int height, Color backgroundColor, String actionCommand, String buttonText, Color textColor)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);
		this.setActionCommand(actionCommand);
		this.setText(buttonText);
		this.setForeground(textColor);
	}
	
	public CustomButton(int width, int height, Color backgroundColor, String actionCommand, String buttonText, Color textColor, Font textFont)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);;
		this.setActionCommand(actionCommand);
		this.setText(buttonText);
		this.setForeground(textColor);
		this.setFont(textFont);
	}
	
	public CustomButton(int width, int height, Color backgroundColor, String actionCommand, String buttonText, Color textColor, Font textFont, ImageIcon image)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);;
		this.setActionCommand(actionCommand);
		this.setText(buttonText);
		this.setForeground(textColor);
		this.setFont(textFont);
		this.setIcon(image);
	}
}
