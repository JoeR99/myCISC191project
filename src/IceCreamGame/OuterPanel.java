package IceCreamGame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 * 
 * References: https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/javax/swing/JPanel.html
 *  
 * Version/date: 10/29/2024
 * 
 * Responsibilities of class:
 * 
 * The panel for the center of my outer panel. Contains outer section of the GUI's panels for better organization
 * 
 */

public class OuterPanel extends JPanel // OuterPanel IS-A JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private GameModel gameModel;
	
	private final int NORTH_SIDE = 50;
	private final int WEST_AND_EAST_SIDE = 150;
	private final int SOUTH_SIDE = 30;
	
	private CardLayout cardLayout = new CardLayout();
	
	private Font defaultSerif = new Font("Serif", Font.BOLD, 16);
	private Font italicSerif_12 = new Font("Serif", Font.ITALIC, 12); // For Shop Text
	
	private CustomPanel eastPanel = new CustomPanel(WEST_AND_EAST_SIDE, 0, Color.ORANGE);
		
	// Cash Shop Labels and Buttons
	private CustomLabel scooperLevelLabel = new CustomLabel("Scooper Level: 1", italicSerif_12, Color.BLACK);
	private CustomButton scooperShopUpgradeButton = new CustomButton(140, 50, Color.YELLOW, "ShopCashScooperUpgrade", "$" + 5, Color.BLACK, italicSerif_12);
	private CustomLabel iceCreamValueLabel = new CustomLabel("Ice Cream Value: 1", italicSerif_12, Color.BLACK);
	private CustomButton iceCreamValueShopUpgradeButton = new CustomButton(140, 50, Color.YELLOW, "ShopCashIceCreamValueUpgrade", "$" + 20, Color.BLACK, italicSerif_12);

	// Experience Shop Labels and Buttons
	private CustomLabel expShopCashUpgradeLabel = new CustomLabel("Cash  x1", italicSerif_12, Color.WHITE);
	private CustomButton expShopCashUpgradeButton = new CustomButton(140, 50, Color.WHITE, "EXPShopCashUpgrade", "EXP 400", Color.BLACK, italicSerif_12);
	private CustomLabel expGainShopLabel = new CustomLabel("EXP  x1", italicSerif_12, Color.WHITE );
	private CustomButton expShopExperienceGainShopButton = new CustomButton(140, 50, Color.WHITE, "EXPShopExperienceUpgrade", "EXP 400", Color.BLACK, italicSerif_12);
	
	public OuterPanel(GameModel model)
	{
		this.gameModel = model;
		
		this.setLayout(new BorderLayout());
		
		InnerPanel innerPanel = new InnerPanel(gameModel, this); // Center Panel is the Inner Panel
		
		CustomPanel northPanel = new CustomPanel(0, NORTH_SIDE, Color.BLACK);
		CustomPanel westPanel = new CustomPanel(WEST_AND_EAST_SIDE, 0, Color.ORANGE);
		CustomPanel southPanel = new CustomPanel(0, SOUTH_SIDE, Color.BLACK);
		
		
		// NORTHERN PANEL ********************************************************************************************************************************* //
		
		this.add(northPanel, BorderLayout.NORTH);
		
		// WESTERN PANEL ********************************************************************************************************************************* //
		
		westPanel.add(scooperLevelLabel);
		westPanel.add(iceCreamValueLabel);
		
		this.add(westPanel, BorderLayout.WEST);

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
		scooperShopUpgradeButton.addActionListener(new ButtonListener("ShopCashScooperUpgrade", new ShopCashScooperUpgradeHandler(gameModel, this, innerPanel)));
		shopIceCreamPanel.add(scooperShopUpgradeButton);
		
		// Ice Cream Value Upgrade Label
		CustomLabel upgradeIceCreamValueLabel = new CustomLabel("Ice Cream Value!", new Font("Serif", Font.BOLD, 12), Color.BLACK);
		shopIceCreamPanel.add(upgradeIceCreamValueLabel);
		
		// Ice Cream Value Upgrade Button
		iceCreamValueShopUpgradeButton.addActionListener(new ButtonListener("ShopCashIceCreamValueUpgrade", new ShopCashIceCreamValueUpgradeHandler(model, this, innerPanel)));
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
		expShopCashUpgradeButton.addActionListener(new ButtonListener("EXPShopCashUpgrade", new ExperienceShopCashUpgradeButtonHandler(gameModel, this, innerPanel)));
		expShopPanel.add(expShopCashUpgradeButton);

		
		// EXP Shop Gain EXP
		expShopPanel.add(expGainShopLabel);
		expShopExperienceGainShopButton.addActionListener(new ButtonListener("EXPShopExperienceUpgrade", new ExperienceShopEXPUpgradeButtonHandler(gameModel, this, innerPanel)));
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

		CustomLabel creatorLabel = new CustomLabel("Programmed By: Joseph Rathbun", defaultSerif, Color.WHITE);
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
		// West Labels
		scooperLevelLabel.setText("Scooper Level: " + gameModel.getCashModel().getScooperLevel());
		iceCreamValueLabel.setText("Ice Cream Value: " + gameModel.getCashModel().getIceCreamValueLevel());
		
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
	
}
