package util;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import game.Game;

public class MapBuilder {

    public static JFrame window;
    public static Container container;
    public static JScrollPane formScrollPanel, mapScrollPanel, descriptionScrollPane;
    public static JPanel formPanel, mapPanel, formScrollPanelViewport, mapScrollPanelViewport;
    public static JPanel namePanel, nameLabelPanel, nameFieldPanel;
    public static JPanel descriptionPanel, descriptionLabelPanel, descriptionFieldPanel;
    public static JPanel npcPanel, npcLabelPanel, npcFieldPanel;
    public static JPanel inventoryPanel, inventoryLabelPanel, inventoryFieldPanel;
    public static JPanel exitPanel, exitLabelPanel, exitFieldPanel;
    public static JLabel nameLabel, descriptionLabel, npcLabel, inventoryLabel, exitLabel;
    public static JTextField nameField, npcField, inventoryField, exitField;
    public static JTextArea descriptionText;

    public MapBuilder() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        container = window.getContentPane();
        createFormPane();
        createMapPane();
    }

    public static void createFormPane() {
        formPanel = Game.createPanel(0, 0, 420, 700, Color.black);
        formPanel.setLayout(null);
        formScrollPanelViewport = Game.createPanel(0, 0, 420, 700, Color.black);
        formScrollPanelViewport.setLayout(null);
        formScrollPanel = createScrollPane(0, 0, 419, 699, 
            formScrollPanelViewport, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED,
            BorderFactory.createEmptyBorder());
        formPanel.add(formScrollPanel);

        createNamePanel();
        createDescriptionPanel();
        createNpcPanel();
        createExitPanel();

        formScrollPanelViewport.add(namePanel);
        formScrollPanelViewport.add(descriptionPanel);
        formScrollPanelViewport.add(npcPanel);
        formScrollPanelViewport.add(exitPanel);

        container.add(formPanel);
    }

    public static void createNamePanel() {
        namePanel = Game.createPanel(0, 0, 420, 50, Color.black);
        namePanel.setLayout(null);
        nameLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        nameFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
        nameFieldPanel.setLayout(null);
        nameLabel = Game.createLabel("Name", Color.white, Game.smallFont);
        nameLabelPanel.add(nameLabel);
        nameField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white, new Color(100,0,0), Game.xSmallFont,
            BorderFactory.createLineBorder(Color.DARK_GRAY));
        nameFieldPanel.add(nameField);
        namePanel.add(nameLabelPanel);
        namePanel.add(nameFieldPanel);
    }

    public static void createDescriptionPanel() {
        descriptionPanel = Game.createPanel(0, 50, 420, 100, Color.black);
        descriptionPanel.setLayout(null);
        descriptionLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        descriptionFieldPanel = Game.createPanel(10, 30, 410, 70, Color.black);
        descriptionFieldPanel.setLayout(null);
        descriptionLabel = Game.createLabel("Description", Color.white, Game.smallFont);
        descriptionLabelPanel.add(descriptionLabel);
        descriptionText = Game.createTextArea(0, 0, 400, 70, "", Color.black, Color.white, Game.xSmallFont, true);
        descriptionText.setCaretColor(Color.white);
        descriptionText.setSelectedTextColor(Color.white);
        descriptionText.setSelectionColor(new Color(100,0,0));
        descriptionScrollPane = createScrollPane(0, 0, 400, 70, descriptionText,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, 
            BorderFactory.createLineBorder(Color.DARK_GRAY));
        descriptionFieldPanel.add(descriptionScrollPane);
        descriptionPanel.add(descriptionLabelPanel);
        descriptionPanel.add(descriptionFieldPanel);
    }

    public static void createNpcPanel() {
        npcPanel = Game.createPanel(0, 150, 420, 100, Color.black);
        npcPanel.setLayout(null);
        npcLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        npcFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
        npcFieldPanel.setLayout(null);
        npcLabel = Game.createLabel("NPC", Color.white, Game.smallFont);
        npcLabelPanel.add(npcLabel);
        npcField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white, new Color(100,0,0), Game.xSmallFont,
            BorderFactory.createLineBorder(Color.DARK_GRAY));
        npcFieldPanel.add(npcField);
        npcPanel.add(npcLabelPanel);
        npcPanel.add(npcFieldPanel);
        
        createInventoryPanels();
    }

    public static void createInventoryPanels() {
        inventoryLabelPanel = Game.createPanel(10, 50, 410, 25, Color.black);
        inventoryFieldPanel = Game.createPanel(10, 80, 410, 20, Color.black);
        inventoryFieldPanel.setLayout(null);
        inventoryLabel = Game.createLabel("Inventory", Color.white, Game.smallFont);
        inventoryLabelPanel.add(inventoryLabel);
        inventoryField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white, new Color(100,0,0), Game.xSmallFont,
            BorderFactory.createLineBorder(Color.DARK_GRAY));
        inventoryFieldPanel.add(inventoryField);
        npcPanel.add(inventoryLabelPanel);
        npcPanel.add(inventoryFieldPanel);
    }

    public static void createExitPanel() {
        exitPanel = Game.createPanel(0, 250, 420, 50, Color.black);
        exitPanel.setLayout(null);
        exitLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        exitFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
        exitFieldPanel.setLayout(null);
        exitLabel = Game.createLabel("Exit", Color.white, Game.smallFont);
        exitLabelPanel.add(exitLabel);
        exitField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white, new Color(100,0,0), Game.xSmallFont,
            BorderFactory.createLineBorder(Color.DARK_GRAY));
        exitFieldPanel.add(exitField);
        exitPanel.add(exitLabelPanel);
        exitPanel.add(exitFieldPanel);
    }

    public static void createMapPane() {
        // Scroll Pane
        mapPanel = Game.createPanel(420, 0, 860, 700, Color.black);
        mapPanel.setLayout(null);
        mapScrollPanelViewport = Game.createPanel(0, 0, 420, 700, Color.black);
        mapScrollPanel = createScrollPane(0, 0, 860, 699, mapScrollPanelViewport,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED,
            BorderFactory.createLineBorder(Color.DARK_GRAY));
        mapPanel.add(mapScrollPanel);
        container.add(mapPanel);
    }

    public static JTextField createTextField(int x, int y, int width, int height, String text, Color background, Color foreground, Color selectedTextColor, Color highlight, Font font, Border border) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
		textField.setBounds(x, y, width, height);
		textField.setBackground(background);
        textField.setForeground(foreground);
        textField.setCaretColor(foreground);
        textField.setSelectedTextColor(selectedTextColor);
        textField.setSelectionColor(highlight);
        textField.setFont(font);
        textField.setBorder(border);
		return textField;
    }
    
    public static JScrollPane createScrollPane(int x, int y, int width, int height, JComponent component, int vsb, int hsb, Border border) {
        JScrollPane scroller = new JScrollPane(component, vsb, hsb);
        scroller.setBounds(x, y, width, height);
        scroller.setBorder(border);
        return scroller;
    }
    
}
