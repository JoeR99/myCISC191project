package IceCreamGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * Version/date: 10/23/2024
 * 
 * Responsibilities of class:
 * 
 * The panel for the center of my outer panel. Contains inner section of the GUI's panels for better organization
 * 
 */

public class InnerPanel extends JPanel
{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3L;

	private GameModel gameModel;
	
	private final int UPPER_SIDE = 50;
	private final int LEFT_AND_RIGHT_SIDE = 120;
	private final int LOWER_SIDE = 30;
	
	private Font boldSerif_12 = new Font("Serif", Font.BOLD, 12);
	
	// Cash
	private CustomLabel cashLabel = new CustomLabel("Cash: " + 0, new Font("Serif", Font.BOLD, 20), Color.BLACK);
	
	// Icons
	private ImageIcon scooperIcon = new ImageIcon("images/yellow-icecream-cone-32.png");
	
	// Custom Cursor 
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Image scooperCursorIcon = toolkit.getImage("images/scooper-32.png");
	private Cursor scooperCursor = toolkit.createCustomCursor(scooperCursorIcon, new Point(0, 0), "Custom Cursor");
	
	// Main Button
	private CustomButton scoopingButton = new CustomButton(120, 50, Color.PINK,"ScoopingButton", "1x", Color.BLACK, boldSerif_12, scooperIcon);
	
	// EXP Slider
	private JSlider experienceSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0); // Horizontal slider with min value 0, max value 10, and initial value 0
	
	private CustomLabel experienceSliderLabel = new CustomLabel("Level: 1", boldSerif_12, Color.BLACK);
	private CustomLabel statPointsLabel = new CustomLabel("Stat Points: 1", boldSerif_12, Color.BLACK);
	
	// Science Slider
	private JSlider scienceSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0); // Horizontal slider with min value 0, max value 10, and initial value 0
	private Timer scienceTimer = new Timer(100, new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Gain Science!");
				}
			});
	
	
	private CustomLabel currentScienceLabel = new CustomLabel("0", boldSerif_12, Color.BLACK);
	private CustomLabel maximumScienceLabel = new CustomLabel("/ 100", boldSerif_12, Color.BLACK);

	
	// Stat Upgrade Buttons
	private CustomButton statCashUpgradeButton = new CustomButton(100, 50, Color.GREEN, "StatCashUpgrade", "CASH x1", Color.BLACK, boldSerif_12);
	private CustomButton statExperienceUpgradeButton = new CustomButton(100, 50, Color.GREEN, "StatExperienceUpgrade", "EXP x1", Color.BLACK, boldSerif_12);


		
	public InnerPanel(GameModel model, OuterPanel outerPanel)
	{
		this.gameModel = model;
		
		this.setLayout(new BorderLayout());
		
		CustomPanel upperPanel = new CustomPanel(0, UPPER_SIDE, Color.YELLOW);
		CustomPanel leftPanel = new CustomPanel(LEFT_AND_RIGHT_SIDE, 0, Color.YELLOW);
		JPanel middlePanel = new JPanel(); middlePanel.setBackground(Color.WHITE);
		CustomPanel rightPanel = new CustomPanel(LEFT_AND_RIGHT_SIDE, 0, Color.YELLOW);
		CustomPanel lowerPanel = new CustomPanel(0, LOWER_SIDE, Color.YELLOW);
		
		// UPPER PANEL ********************************************************************************************************************************* //
		
		upperPanel.add(cashLabel);
		
		this.add(upperPanel, BorderLayout.NORTH); // Add Sub Panel to Inner Panel
		
		// LEFT PANEL ********************************************************************************************************************************** //
		leftPanel.add(experienceSliderLabel); // EXP SLIDER
		
		
		// Experience Slider
		experienceSlider.setPreferredSize(new Dimension(140,4));
		experienceSlider.setEnabled(false);
		leftPanel.add(experienceSlider);
		
		leftPanel.add(statPointsLabel); // STAT POINTS
		
		// Experience Buttons
		statCashUpgradeButton.addActionListener(new ButtonListener("StatCashUpgrade", new StatCashUpgradeHandler(gameModel, this)));
		leftPanel.add(statCashUpgradeButton);
		
		statExperienceUpgradeButton.addActionListener(new ButtonListener("StatExperienceUpgrade", new StatExperienceUpgradeHandler(gameModel, this)));
		leftPanel.add(statExperienceUpgradeButton);
		
		// Science Slider
		CustomLabel scienceLabel = new CustomLabel("SCIENCE", boldSerif_12 , Color.BLACK); // SCIENCE 
		leftPanel.add(scienceLabel);
		
		scienceSlider.setPreferredSize(new Dimension(140,4));
		scienceSlider.setEnabled(false);
		leftPanel.add(scienceSlider);
		leftPanel.add(currentScienceLabel);
		leftPanel.add(maximumScienceLabel);
				
		this.add(leftPanel, BorderLayout.WEST); // Add Sub Panel to Inner Panel

		// MIDDLE PANEL ********************************************************************************************************************************* //

		scoopingButton.setCursor(scooperCursor);
		scoopingButton.addActionListener(new ButtonListener("ScoopingButton", new CashButtonHandler(gameModel, this)));
		scoopingButton.addMouseListener(new ButtonMouseListener(model, this));
		middlePanel.add(scoopingButton);
		
		this.add(middlePanel, BorderLayout.CENTER); // Add Sub Panel to Inner Panel

		// RIGHT PANEL ********************************************************************************************************************************* //

		// SHOP BUTTONS / LISTENERS
		CustomButton switchToCashShopButton = new CustomButton(70, 30, Color.CYAN,"SHOP_PAGE", "SHOP", Color.BLACK, boldSerif_12);
		CustomButton switchToExperienceShopButton = new CustomButton(70, 30, Color.BLUE,"SHOP_PAGE", "EXP", Color.WHITE, boldSerif_12);
		CustomButton switchToScienceShopButton = new CustomButton(70, 30, Color.GREEN,"SHOP_PAGE", "SCI", Color.YELLOW, boldSerif_12);
		CustomButton switchToResearchShopButton = new CustomButton(70, 30, Color.MAGENTA,"SHOP_PAGE", "RES", Color.BLACK, new Font("Serif", Font.BOLD, 12));

		switchToCashShopButton.addActionListener(e -> outerPanel.switchPanel("CASH_SHOP_PAGE")); // Add Action Listener to Swap Panels in Outer Panel
		switchToExperienceShopButton.addActionListener(e -> outerPanel.switchPanel("EXP_SHOP_PAGE"));
		switchToScienceShopButton.addActionListener(e -> outerPanel.switchPanel("SCIENCE_SHOP_PAGE"));
		switchToResearchShopButton.addActionListener(e -> outerPanel.switchPanel("RESEARCH_SHOP_PAGE"));
		
		rightPanel.add(switchToCashShopButton); // Add Shop Buttons to Right Panel
		rightPanel.add(switchToExperienceShopButton);
		rightPanel.add(switchToScienceShopButton);
		rightPanel.add(switchToResearchShopButton);
		
		this.add(rightPanel, BorderLayout.EAST); // Add Sub Panel to Inner Panel

		// LOWER PANEL ********************************************************************************************************************************* //

		this.add(lowerPanel, BorderLayout.SOUTH); // Add Sub Panel to Inner Panel
		
	}
	
	public void updateInnerUI()
	{
		// Cash
		cashLabel.setText("Cash: $" + gameModel.getCashModel().getCurrentCash());
		
		// Main Button
		scoopingButton.setText(gameModel.getCashModel().getCashMultiplier() + "x");
		
		// Experience Level Slider
		experienceSliderLabel.setText("Level:  " + gameModel.getExperienceModel().getExperienceLevel());
		experienceSlider.setValue(gameModel.getExperienceModel().getCurrentExperience());
		experienceSlider.setMaximum(gameModel.getExperienceModel().getExperienceLevelUpCost());
		
		// Stat Points Label and Buttons
		statPointsLabel.setText("Stat Points: " + gameModel.getExperienceModel().getExperienceStatPoints());
		statCashUpgradeButton.setText("CASH x" + gameModel.getExperienceModel().getStatCashModifier());
		statExperienceUpgradeButton.setText("EXP x" + gameModel.getExperienceModel().getStatExperienceModifier());
		
		// Science Labels and Slider
		
		
		
	}
	
}
