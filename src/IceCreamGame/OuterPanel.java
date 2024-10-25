package IceCreamGame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * Version/date: 10/20/2024
 * 
 * Responsibilities of class:
 * 
 * The panel for the center of my outer panel. Contains outer section of the GUI's panels for better organization
 * 
 */

public class OuterPanel extends JPanel
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
		
	// Cash Shop Labels
	private CustomLabel scooperLevelLabel = new CustomLabel("Scooper Level: 1", italicSerif_12, Color.BLACK);
	private CustomLabel iceCreamValueLabel = new CustomLabel("Ice Cream Value: 1", italicSerif_12, Color.BLACK);
	
	// Cash Shop Buttons
	private CustomButton scooperShopUpgradeButton = new CustomButton(140, 50, Color.YELLOW, "ShopCashScooperUpgrade", "$" + 5, Color.BLACK, italicSerif_12);
	private CustomButton iceCreamValueShopUpgradeButton = new CustomButton(140, 50, Color.YELLOW, "ShopCashIceCreamValueUpgrade", "$" + 20, Color.BLACK, italicSerif_12);

	// Experience Shop Labels
	private CustomLabel expGainShopLabel = new CustomLabel("EXP Gain " + 2 + "x", italicSerif_12, Color.WHITE );
	private CustomLabel upgradeExpGainButtonLabel = new CustomLabel("EXP Gain " + 2 + "x", italicSerif_12, Color.WHITE);
	
	private CustomButton i = new CustomButton(140, 50, Color.PINK, "", "", Color.BLACK, italicSerif_12);


	
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
		
		CustomLabel expShopLabel = new CustomLabel("EXPERIENCE SHOP", new Font("Serif", Font.BOLD, 12), Color.WHITE);
		expShopPanel.add(expShopLabel);
		
		// EXP Gain Shop Label
		expShopPanel.add(expGainShopLabel);
//		
//		// EXP Gain Shop Button
//		CustomButton upgradeExpGainShopButton = new CustomButton(140, 50, Color.BLACK, Color.GREEN, "");
//		upgradeExpGainShopButton.addActionListener(new CashButtonListener(model, this, upgradeExpGainShopButton));
//		upgradeExpGainShopButton.add(upgradeExpGainButtonLabel);
//		expShopPanel.add(upgradeExpGainShopButton);
//		
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
		
		// Shop Button Text 
		scooperShopUpgradeButton.setText("$" + gameModel.getCashModel().getScooperUpgradeCost());
		iceCreamValueShopUpgradeButton.setText("$" + gameModel.getCashModel().getIceCreamValueUpgradeCost());
		
		innerView.updateInnerUI(); // Update Inner UI
	}
	
}
