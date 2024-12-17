package IceCreamGame;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: https://junit.org/junit5/docs/current/user-guide/
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class: 
 * 
 * Test All Classes for the Ice Cream Game : CustomLabel, CustomButton, CustomPanel, OuterPanel, InnerPanel, GameModel, GameView
 * 											 ButtonListener, ButtonMouseListener, ...
 * 
 */

class TestIceCreamGame
{
	@Test
	void testCustomLabel()
	{
		// CustomLabel Parameters : String labelText, Font labelTextFont, Color labelTextColor 
		CustomLabel testLabel = new CustomLabel("Super Cool Label", new Font("Serif", Font.PLAIN, 10), Color.BLACK);
		
		// Test CustomLabel Set Text Parameters
		assertEquals("Super Cool Label", testLabel.getText());
		
		// Test CustomLabel Font Parameters
		assertNotEquals(new Font("Serif", Font.PLAIN, 20), testLabel.getFont());
		
		// Test CustomLabel Text Color Parameters
		assertEquals(Color.BLACK, testLabel.getForeground());
		
		// Test that CustomLabel IS-A JLabel
		assertTrue(testLabel instanceof JLabel);
	}

	@Test
	void testCustomButton()
	{
		ImageIcon testIcon = new ImageIcon("images/scooper-32");
		// CustomButton Parameters : int width, int height, Color backgroundColor, String buttonText, Color textColor, Font textFont, ImageIcon image
		CustomButton testButton = new CustomButton(99, 11, Color.BLACK, "!", Color.WHITE, new Font("SansSerif", Font.ITALIC, 12), testIcon);

		// Test CustomButton Dimension Parameters
		assertEquals(new Dimension(99, 11), testButton.getPreferredSize());
		
		// Test CustomButton Background Color Parameters
		assertEquals(Color.BLACK, testButton.getBackground());
		
		// Test CustomButton Set Text Parameters
		assertEquals("!", testButton.getText());

		// Test CustomButton Text/Foreground Color Parameters
		assertEquals(Color.WHITE, testButton.getForeground());
		
		// Test CustomButton Font Parameters
		assertNotEquals(new Font("SansSerif", Font.BOLD, 12), testButton.getFont());

		// Test CustomButton ImageIcon Parameters
		ImageIcon joeIcon = new ImageIcon("images/yellow-icecream-cone-32.png");
		assertNotEquals(joeIcon, testButton.getIcon());
		
		// Test that CustomButton IS-A JButton
		assertTrue(testButton instanceof JButton); 
	}
	
	@Test
	void testCustomPanel()
	{
		CustomPanel testPanel = new CustomPanel(50, 100, Color.BLUE);
		
		// Test CustomPanels Dimension Parameters
		assertEquals(new Dimension(50, 100), testPanel.getPreferredSize());

		// Test CustomPanels Background Color Parameter
		assertEquals(Color.BLUE, testPanel.getBackground());
		
		// Test that CustomPanel IS-A JPanel
		assertTrue(testPanel instanceof JPanel);
	}
	
	@Test
	void testOuterPanel()
	{		
		String storeName = "Store";
		// OuterPanel Parameters : GameModel
		OuterPanel testOuterPanel = new OuterPanel(new GameModel(), storeName);
		
		// Test that OuterPanel IS-A JPanel
		assertTrue(testOuterPanel instanceof JPanel);
	}
	
	@Test
	void testInnerPanel()
	{
		String storeName = "Store";
		// InnerPanel Parameters : GameModel
		GameModel testModel = new GameModel();
		OuterPanel testOuterPanel = new OuterPanel(testModel, storeName);
		InnerPanel testInnerPanel = new InnerPanel(testModel, testOuterPanel);
		
		// Test that InnerPanel IS-A JPanel
		assertTrue(testInnerPanel instanceof JPanel);
	}
	
	@Test
	void testGameModel()
	{
		// Testing that different instances of a GameModel and its submodels are not equal 
		GameModel testModel = new GameModel();
		GameModel joesModel = new GameModel();	
		
		// Test if these are a class object of GameModel
		assertTrue(testModel instanceof GameModel);
		assertTrue(joesModel instanceof GameModel);
		assertNotEquals(testModel, joesModel);
		
		// Test the CashModel for each GameModel object
		assertTrue(testModel.getCashModel() instanceof CashModel);
		assertTrue(joesModel.getCashModel() instanceof CashModel);
		assertNotEquals(testModel.getCashModel(), joesModel.getCashModel()); 
		
		// Test the ExperienceModel for each GameModel object
		assertTrue(testModel.getExperienceModel() instanceof ExperienceModel);
		assertTrue(joesModel.getExperienceModel() instanceof ExperienceModel);
		assertNotEquals(testModel.getExperienceModel(), joesModel.getExperienceModel());

		// Test the ScienceModel for each GameModel object
		assertTrue(testModel.getScienceModel() instanceof ScienceModel);
		assertTrue(joesModel.getScienceModel() instanceof ScienceModel);
		assertNotEquals(testModel.getScienceModel(), joesModel.getScienceModel());	
	}
	
	@Test
	void testCashModel()
	{
		//TODO
	}
	
	@Test
	void testExperienceModel()
	{
		//TODO
	}
	
	@Test
	void testScienceModel()
	{
		//TODO
	}
	
	@Test
	void testGameView()
	{
		String storeName = "Store";

		GameModel testModel = new GameModel();
		GameView testView = new GameView(testModel, storeName);
		
		// Test that CustomPanel IS-A JPanel
		assertTrue(testView instanceof JFrame);

	}
	
	@Test
	void testCashButtonListener()
	{
		
	}
	
	@Test
	void testExperienceButtonListener()
	{
		
	}
	
	@Test
	void testButtonMouseListener()
	{
		
	}
	
}
