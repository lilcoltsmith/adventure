package util;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import game.Game;

public class MapBuilder {

    public static JFrame window;
    public static JPanel mainLayout;
    public static Container container;
    public static JPanel namePanel, nameLabelPanel, nameFieldPanel;
    public static JPanel descriptionPanel, descriptionLabelPanel, descriptionFieldPanel;
    public static JPanel npcPanel, npcLabelPanel, npcFieldPanel;
    public static JPanel inventoryPanel, inventoryLabelPanel, inventoryFieldPanel;
    public static JPanel exitPanel, exitLabelPanel, exitFieldPanel;
    public static JLabel nameLabel, descriptionLabel, npcLabel, inventoryLabel, exitLabel;
    public static JTextField nameField;
    public static JTextArea descriptionText;

    public MapBuilder() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        createFormFields();
    }

    public static void createFormFields() {
        container = window.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        // Name
        namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.setBackground(Color.black);
        nameLabelPanel = new JPanel();
        nameLabelPanel.setBackground(Color.black);
        nameFieldPanel = new JPanel();
        nameFieldPanel.setBackground(Color.black);
        nameLabel = Game.createLabel("Name", Color.white, Game.smallFont);
        nameLabelPanel.add(nameLabel);
        nameField = new JTextField(30);
        nameField.setBackground(Color.black);
        nameField.setForeground(Color.white);
        nameFieldPanel.add(nameField);
        namePanel.add(nameLabelPanel);
        namePanel.add(nameFieldPanel);

        // Description
        descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.setBackground(Color.black);
        descriptionLabelPanel = new JPanel();
        descriptionLabelPanel.setBackground(Color.black);
        descriptionFieldPanel = new JPanel();
        descriptionFieldPanel.setBackground(Color.black);
        descriptionFieldPanel.setForeground(Color.white);
        descriptionLabel = Game.createLabel("Description", Color.white, Game.smallFont);
        descriptionLabelPanel.add(descriptionLabel);
        descriptionText = new JTextArea(3, 50);
        descriptionText.setBackground(Color.black);
        descriptionText.setForeground(Color.white);
        descriptionText.setBorder(BorderFactory.createLineBorder(Color.white));
        descriptionFieldPanel.add(descriptionText);
        descriptionPanel.add(descriptionLabelPanel);
        descriptionPanel.add(descriptionFieldPanel);

        // NPC
        npcPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        npcPanel.setBackground(Color.black);
        npcLabelPanel = new JPanel();
        npcLabelPanel.setBackground(Color.black);
        npcLabel = Game.createLabel("NPC", Color.white, Game.smallFont);
        npcLabelPanel.add(npcLabel);
        npcPanel.add(npcLabelPanel);

        // Inventory
        inventoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inventoryPanel.setBackground(Color.black);
        inventoryLabelPanel = new JPanel();
        inventoryLabelPanel.setBackground(Color.black);
        inventoryLabel = Game.createLabel("Inventory", Color.white, Game.smallFont);
        inventoryLabelPanel.add(inventoryLabel);
        inventoryPanel.add(inventoryLabelPanel);

        // Exit
        exitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        exitPanel.setBackground(Color.black);
        exitLabelPanel = new JPanel();
        exitLabelPanel.setBackground(Color.black);
        exitLabel = Game.createLabel("Exit", Color.white, Game.smallFont);
        exitLabelPanel.add(exitLabel);
        exitPanel.add(exitLabelPanel);
        
        container.add(namePanel);
        container.add(descriptionPanel);
        container.add(npcPanel);
        container.add(inventoryPanel);
        container.add(exitPanel);
    }
    
}
