package IceCreamGame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 * 
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/javax/swing/JButton.html
 *  
 * Version/date: 11/06/2024
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
	
	public CustomButton(int width, int height, Color backgroundColor, String buttonText, Color textColor, Font textFont)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);
		this.setText(buttonText);
		this.setForeground(textColor);
		this.setFont(textFont);
	}
	
	public CustomButton(int width, int height, Color backgroundColor, String buttonText, Color textColor, Font textFont, ImageIcon image)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);;
		this.setText(buttonText);
		this.setForeground(textColor);
		this.setFont(textFont);
		this.setIcon(image);
	}
	
	public CustomButton(int width, int height, Color backgroundColor, String buttonText, Color textColor, Font textFont, ImageIcon image, Cursor cursor)
	{
		this();
		this.setPreferredSize(new Dimension (width, height));
		this.setBackground(backgroundColor);;
		this.setText(buttonText);
		this.setForeground(textColor);
		this.setFont(textFont);
		this.setIcon(image);
		this.setCursor(cursor);
	}
}
