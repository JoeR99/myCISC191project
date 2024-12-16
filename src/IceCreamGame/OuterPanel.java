package IceCreamGame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
 * The panel for the center of my outer panel. Contains outer section of the GUI's panels for better organization
 * 
 */

public class OuterPanel extends JPanel // OuterPanel IS-A JPanel
{
	
	private GameModel gameModel;
	
	private final int NORTH_SIDE = 40;
	private final int WEST_AND_EAST_SIDE = 150;
	private final int SOUTH_SIDE = 30;
	
	// Cash
	private CustomLabel cashLabel = new CustomLabel("Cash: " + 0, new Font("Serif", Font.BOLD, 20), Color.BLACK);
	
	private Font defaultSerif = new Font("Serif", Font.BOLD, 16);
	private Font italicSerif_12 = new Font("Serif", Font.ITALIC, 12); // For Shop Text
	private Font boldSerif_12 = new Font("Serif", Font.BOLD, 12); // For Flavor Buttons

	// Icons
	private ImageIcon tempVanillaIcon = new ImageIcon("images/yellow-icecream-cone-32.png");
	
	// Custom Cursor 
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Image scooperCursorIcon = toolkit.getImage("images/scooper-32.png");
	private Cursor scooperCursor = toolkit.createCustomCursor(scooperCursorIcon, new Point(0, 0), "Custom Cursor");
	
	private CustomPanel eastPanel = new CustomPanel(WEST_AND_EAST_SIDE, 0, Color.ORANGE);
		
	// Western Labels
	private CustomLabel scooperLevelLabel = new CustomLabel("Scooper Level: 1", italicSerif_12, Color.BLACK);
	private CustomLabel iceCreamValueLabel = new CustomLabel("Ice Cream Value: 1", italicSerif_12, Color.BLACK);
	private CustomLabel expMultiLabel = new CustomLabel("Experience Multiplier: 1x", italicSerif_12, Color.BLACK);
	private CustomLabel sciMultiLabel = new CustomLabel("Science Multiplier: 1x", italicSerif_12, Color.BLACK);
	
//	private HashMap<String, IceCream> flavorMap = new HashMap<>();
	
	// West - Flavor Buttons
	private CustomButton vanillaButton = new CustomButton(130, 45, Color.WHITE, "Vanilla", Color.BLACK, boldSerif_12, tempVanillaIcon, scooperCursor);
	private CustomButton chocolateButton = new CustomButton(130, 45, Color.DARK_GRAY, "Chocolate", Color.BLACK, boldSerif_12, tempVanillaIcon, scooperCursor);
	private CustomButton strawberryButton = new CustomButton(130, 45, Color.PINK, "Strawberry", Color.BLACK, boldSerif_12, tempVanillaIcon, scooperCursor);
	private CustomButton neoButton = new CustomButton(130, 45, Color.MAGENTA, "Neopolitan", Color.BLACK, boldSerif_12, tempVanillaIcon, scooperCursor);
	private CustomButton mintButton = new CustomButton(130, 45, Color.GREEN, "Mint", Color.BLACK, boldSerif_12, tempVanillaIcon, scooperCursor);
	
	// Flavor Modifier Labels
	private CustomLabel flavorCashModifierLabel = new CustomLabel("Cash 1x", italicSerif_12, Color.BLACK);
	private CustomLabel flavorExpModifierLabel = new CustomLabel("Experience 1x", italicSerif_12, Color.BLACK);
	private CustomLabel flavorSciModifierLabel = new CustomLabel("Science 1x", italicSerif_12, Color.BLACK);
	private CustomLabel flavorResModifierLabel = new CustomLabel("Research 1x", italicSerif_12, Color.BLACK);

	
	// Cash Shop Labels and Buttons
	private CustomButton scooperShopUpgradeButton = new CustomButton(140, 50, Color.YELLOW, "$" + 5, Color.BLACK, italicSerif_12);
	private CustomButton iceCreamValueShopUpgradeButton = new CustomButton(140, 50, Color.YELLOW, "$" + 20, Color.BLACK, italicSerif_12);

	// Experience Shop Labels and Buttons
	private CustomLabel expShopCashUpgradeLabel = new CustomLabel("Cash  x1", italicSerif_12, Color.WHITE);
	private CustomButton expShopCashUpgradeButton = new CustomButton(140, 50, Color.WHITE, "EXP 400", Color.BLACK, italicSerif_12);
	private CustomLabel expGainShopLabel = new CustomLabel("EXP  x1", italicSerif_12, Color.WHITE );
	private CustomButton expShopExperienceGainShopButton = new CustomButton(140, 50, Color.WHITE, "EXP 400", Color.BLACK, italicSerif_12);
	
	private CardLayout cardLayout = new CardLayout();
	
	public OuterPanel(GameModel model)
	{
		this.gameModel = model;
		
		this.setLayout(new BorderLayout());
		
		InnerPanel innerPanel = new InnerPanel(gameModel, this); // Center Panel is the Inner Panel
		
		CustomPanel northPanel = new CustomPanel(0, NORTH_SIDE, Color.ORANGE);
		CustomPanel westPanel = new CustomPanel(WEST_AND_EAST_SIDE, 0, Color.ORANGE);
		CustomPanel southPanel = new CustomPanel(0, SOUTH_SIDE, Color.ORANGE);
	
		// NORTHERN PANEL ********************************************************************************************************************************* //
		
		this.add(northPanel, BorderLayout.NORTH);	
	
		northPanel.add(cashLabel);
		
		// WESTERN PANEL ********************************************************************************************************************************* //
		
		westPanel.add(scooperLevelLabel);
		westPanel.add(iceCreamValueLabel);
		westPanel.add(expMultiLabel);
		westPanel.add(sciMultiLabel);
	
		this.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new FlowLayout());
		
		CustomPanel westMiddlePanel = new CustomPanel(140, 260, Color.BLUE);
		
		// Flavors
		IceCream vanilla = new Flavor();
		IceCream chocholate = new Flavor("Chocolate", 3, 1, 1, 2);
		IceCream strawberry = new Flavor("Strawberry", 1, 2, 2, 1);
		IceCream neopalitan = new Flavor("Neopolitan", 6, 2, 2, 2);
		IceCream mint = new Flavor("Mint", 2, 1, 3, 1);

//		flavorMap.put("Vanilla", vanilla); 
//		flavorMap.put("Chocolate", chocholate); 
//		flavorMap.put("Strawberry", strawberry); 
//		flavorMap.put("Neopolitan", neopalitan);
//		flavorMap.put("Mint", mint);
		
		westMiddlePanel.add(vanillaButton); // Add Flavor Buttons
		westMiddlePanel.add(chocolateButton);
		westMiddlePanel.add(strawberryButton);
		westMiddlePanel.add(neoButton);
		westMiddlePanel.add(mintButton);
		
		vanillaButton.setToolTipText("Cash 1x | Exp 1x | Sci 1x | Res 1x");
		
		CustomPanel westLowerPanel = new CustomPanel(140, 260, Color.RED);
		
		CustomLabel flavorModiferLabel = new CustomLabel("Flavor Modifiers", new Font("Serif", Font.BOLD, 17), Color.BLACK);
		
		westLowerPanel.add(flavorModiferLabel);
		westLowerPanel.add(flavorCashModifierLabel); // Add Modifier Labels
		westLowerPanel.add(flavorExpModifierLabel);
		westLowerPanel.add(flavorSciModifierLabel);
		westLowerPanel.add(flavorResModifierLabel);
		
		westPanel.add(westMiddlePanel);
		westPanel.add(westLowerPanel);

		// CENTER / INNER PANEL ************************************************************************************************************************* //

		this.add(innerPanel, BorderLayout.CENTER);

		// EASTERN PANEL *********************************************************************************************************************************//
		
		eastPanel.setLayout(cardLayout);
		eastPanel.setBackground(Color.CYAN); // Set Color of East Panel to RGB Value
		eastPanel.setPreferredSize(new Dimension(WEST_AND_EAST_SIDE,0)); // Set width of East Panel
		
		// ===================================
	
		// ICE CREAM SHOP PANEL ============== 
		
		// ===================================

		CustomPanel shopIceCreamPanel = new CustomPanel(0,0,Color.CYAN);
		
		// Shop Label
		CustomLabel shopLabel = new CustomLabel("Shop Upgrades", new Font("Serif", Font.BOLD, 16), Color.BLUE);
		shopIceCreamPanel.add(shopLabel);
		
		// Scooper Upgrade Label
		CustomLabel upgradeScooperLabel = new CustomLabel("Scooper!", defaultSerif, Color.BLACK); 
		shopIceCreamPanel.add(upgradeScooperLabel);
		
		// Scooper Upgrade Button
		scooperShopUpgradeButton.addActionListener(new ShopCashScooperUpgradeHandler(gameModel, this, innerPanel));
		shopIceCreamPanel.add(scooperShopUpgradeButton);
		
		// Ice Cream Value Upgrade Label
		CustomLabel upgradeIceCreamValueLabel = new CustomLabel("Ice Cream Value!", new Font("Serif", Font.BOLD, 12), Color.BLACK);
		shopIceCreamPanel.add(upgradeIceCreamValueLabel);
		
		// Ice Cream Value Upgrade Button
		iceCreamValueShopUpgradeButton.addActionListener(new ShopCashIceCreamValueUpgradeHandler(model, this, innerPanel));
		shopIceCreamPanel.add(iceCreamValueShopUpgradeButton);
	
		// ===================================
		
		// EXP SHOP PANEL ====================
		
		// ===================================

		CustomPanel expShopPanel = new CustomPanel(0,0, Color.BLUE);	
		
		// EXP Shop Label
		CustomLabel expShopLabel = new CustomLabel("EXPERIENCE SHOP", new Font("Serif", Font.BOLD, 12), Color.WHITE);
		expShopPanel.add(expShopLabel);
		
		// EXP Shop Gain CASH
		expShopPanel.add(expShopCashUpgradeLabel);
		expShopCashUpgradeButton.addActionListener(new ExperienceShopCashUpgradeButtonHandler(gameModel, this, innerPanel));
		expShopPanel.add(expShopCashUpgradeButton);

		
		// EXP Shop Gain EXP
		expShopPanel.add(expGainShopLabel);
		expShopExperienceGainShopButton.addActionListener(new ExperienceShopEXPUpgradeButtonHandler(gameModel, this, innerPanel));
		expShopPanel.add(expShopExperienceGainShopButton);
		
		// ===================================
		
		// SCIENCE SHOP PANEL ************************ //
		
		// ===================================

		CustomPanel scienceShopPanel = new CustomPanel(0,0, Color.GREEN);
		
		// ===================================

		// RESEARCH SHOP PANEL ************************ //
		
		// ===================================

		CustomPanel researchShopPanel = new CustomPanel(0,0, Color.MAGENTA);
//		
//		// Research Shop Label
//		JLabel researchShopLabel = new JLabel("RESEARCH SHOP");
//		researchShopLabel.setFont(new Font("Serif", Font.ITALIC, 12)); researchShopLabel.setForeground(Color.BLACK);
//		researchShopPanel.add(researchShopLabel);
		
		// Add Panels to CardLayout
		eastPanel.add(shopIceCreamPanel, "CASH_SHOP_PAGE"); // Add Shop Page to East Panel's CardLayout
		eastPanel.add(expShopPanel, "EXP_SHOP_PAGE"); // Add EXP Page to East Panel's CardLayout
		eastPanel.add(scienceShopPanel, "SCIENCE_SHOP_PAGE"); // Add Research Page to East Panel's CardLayout
		eastPanel.add(researchShopPanel, "RESEARCH_SHOP_PAGE"); // Add Research Page to East Panel's CardLayout	
		
		cardLayout.show(eastPanel,"SHOP_PAGE"); // Set Starting Page to SHOP

		this.add(eastPanel, BorderLayout.EAST);

		// SOUTHERN PANEL ********************************************************************************************************************************* //

		CustomLabel creatorLabel = new CustomLabel("Programmed By: Joseph Rathbun", defaultSerif, Color.BLACK);
		southPanel.add(creatorLabel);
		southPanel.setToolTipText("Programmed By: Joseph Rathbun");		
		this.add(southPanel, BorderLayout.SOUTH);	
	}
	
	public void switchPanel(String panelName)
	{
		cardLayout.show(eastPanel, panelName);
	}
	
	public void updateOuterPanelUI(InnerPanel innerView)
	{
		CashModel cashModel = gameModel.getCashModel();
		
		// Northen Panel 
		// Cash Label
		cashLabel.setText("Cash: $" + cashModel.getCurrentCash());
			
		// West Labels
		scooperLevelLabel.setText("Scooper Level: " + gameModel.getCashModel().getScooperLevel());
		iceCreamValueLabel.setText("Ice Cream Value: " + gameModel.getCashModel().getIceCreamValueLevel());
		expMultiLabel.setText("Experience Multiplier: " + gameModel.getExperienceModel().getExperienceMultiplier() + "x");
		sciMultiLabel.setText("Science Multiplier: " + gameModel.getScienceModel().getScienceGainMultiplier() + "x");
		
		// West Flavor Modifier Labels
		flavorCashModifierLabel.setText("Cash " + gameModel.getCashModel().getFlavorCashModifier() + "x");
		flavorExpModifierLabel.setText("Experience " + gameModel.getExperienceModel().getFlavorExpModifier() + "x");
		flavorSciModifierLabel.setText("Science " + gameModel.getScienceModel().getFlavorSciModifier() + "x");
		flavorResModifierLabel.setText("Research " + gameModel.getResearchModel().getFlavorResModifier() + "x");
		
		// Cash Shop Button Text 
		scooperShopUpgradeButton.setText("$" + gameModel.getCashModel().getScooperUpgradeCost());
		iceCreamValueShopUpgradeButton.setText("$" + gameModel.getCashModel().getIceCreamValueUpgradeCost());
		
		// Experience Shop Button Text
		expShopCashUpgradeLabel.setText("Cash  x" + gameModel.getCashModel().getEXPShopCashModifier());
		expShopCashUpgradeButton.setText("EXP " + gameModel.getExperienceModel().getExperienceShopCashUpgradeCost());
		expGainShopLabel.setText("EXP  x" + gameModel.getExperienceModel().getExperienceShopEXPModifier());
		expShopExperienceGainShopButton.setText("EXP " + gameModel.getExperienceModel().getExperienceShopEXPUpgradeCost());
		
		innerView.updateInnerUI(); // Update Inner UI
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
}
