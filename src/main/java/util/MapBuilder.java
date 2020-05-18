package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

import game.Game;

public class MapBuilder {

    public static final int FORM_PANEL_WIDTH = 419;
    public static Integer npcCount;
    public static List<Integer> npcItemCount;

    public static JFrame window;
    public static Container container;
    public static int formPanelHeight;
    public static JScrollPane formScrollPanel, mapScrollPanel, descriptionScrollPane;
    public static JPanel formPanel, mapPanel, formScrollPanelViewport, mapScrollPanelViewport;
    public static JPanel namePanel, nameLabelPanel, nameFieldPanel;
    public static JPanel descriptionPanel, descriptionLabelPanel, descriptionFieldPanel;
    public static JPanel npcCountPanel, npcCountLabelPanel, npcCountFieldPanel;
    public static JPanel npcPanel, npcLabelPanel, npcFieldPanel;
    public static JPanel inventoryPanel, inventoryLabelPanel, inventoryFieldPanel;
    public static JPanel exitPanel, exitLabelPanel, exitFieldPanel;
    public static JLabel nameLabel, descriptionLabel, npcCountLabel, npcLabel, inventoryLabel, exitLabel;
    public static JTextField nameField, npcField, inventoryField, exitField;
    public static JTextArea descriptionText;
    public static JComboBox<Integer> npcCountField;
    public static JPanel actionPanel, createButtonPanel;
    public static JButton createButton;

    public static List<JPanel> formPanelList;
    public static List<JTextComponent> formFieldList;

    public MapBuilder() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        container = window.getContentPane();
        formPanelList = new ArrayList<JPanel>();
        formFieldList = new ArrayList<JTextComponent>();
        formPanelHeight = 0;
        npcCount = 1;
        npcItemCount = Arrays.asList(0, 0, 0, 0, 0);

        createFormPane();
        createMapPane();

        createDefaultFields();
    }

    public static void createFormPane() {
        formPanel = Game.createPanel(0, 0, FORM_PANEL_WIDTH, 700, Color.black);
        formPanel.setLayout(null);
        formScrollPanelViewport = Game.createPanel(0, 0, FORM_PANEL_WIDTH, 700, Color.black);
        formScrollPanelViewport.setLayout(null);
        formScrollPanel = createScrollPane(0, 0, 419, 699, formScrollPanelViewport,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED,
                BorderFactory.createEmptyBorder());

        formPanel.add(formScrollPanel);
        container.add(formPanel);
    }

    public static void createDefaultFields() {
        createNamePanel();
        createDescriptionPanel();
        createNpcCountPanel();
        createNpcPanel();
        createExitPanel();
        createCreateButtonPanel();
    }

    public static void clearForm() {
        if (formScrollPanelViewport.getComponentCount() > 0) {
            formScrollPanelViewport.removeAll();
            formScrollPanelViewport.revalidate();
            formScrollPanelViewport.repaint();
        }
        formPanelHeight = 0;
        formPanelList = new ArrayList<JPanel>();
        formFieldList = new ArrayList<JTextComponent>();
    }

    public static void addToFormPanelList(JPanel panel) {
        formPanelList.add(panel);
        updateFormScrollPanelViewport();
    }

    public static void updateFormScrollPanelViewport() {
        if (formScrollPanelViewport.getComponentCount() > 0) {
            formScrollPanelViewport.removeAll();
            formScrollPanelViewport.revalidate();
            formScrollPanelViewport.repaint();
        }

        formPanelHeight = 0;
        for (JPanel panel : formPanelList) {
            formScrollPanelViewport.add(panel);
            formPanelHeight += panel.getHeight();
        }
        formScrollPanelViewport.setPreferredSize(new Dimension(FORM_PANEL_WIDTH, formPanelHeight));
        formScrollPanelViewport.revalidate();
    }

    public static void createNamePanel() {
        namePanel = Game.createPanel(0, formPanelHeight, 420, 50, Color.black);
        namePanel.setLayout(null);
        namePanel.setName("Name");
        nameLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        nameFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
        nameFieldPanel.setLayout(null);
        nameLabel = Game.createLabel("Name", Color.white, Game.smallFont);
        nameLabelPanel.add(nameLabel);
        nameField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white, new Color(100, 0, 0),
                Game.xSmallFont, BorderFactory.createLineBorder(Color.DARK_GRAY));
        nameField.setName("Name");
        nameFieldPanel.add(nameField);
        namePanel.add(nameLabelPanel);
        namePanel.add(nameFieldPanel);
        addToFormPanelList(namePanel);
        formFieldList.add(nameField);
    }

    public static void createDescriptionPanel() {
        descriptionPanel = Game.createPanel(0, formPanelHeight, FORM_PANEL_WIDTH, 100, Color.black);
        descriptionPanel.setLayout(null);
        descriptionPanel.setName("Description");
        descriptionLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        descriptionFieldPanel = Game.createPanel(10, 30, 410, 70, Color.black);
        descriptionFieldPanel.setLayout(null);
        descriptionLabel = Game.createLabel("Description", Color.white, Game.smallFont);
        descriptionLabelPanel.add(descriptionLabel);
        descriptionText = Game.createTextArea(0, 0, 400, 70, "", Color.black, Color.white, Game.xSmallFont, true);
        descriptionText.setName("Description");
        descriptionText.setCaretColor(Color.white);
        descriptionText.setSelectedTextColor(Color.white);
        descriptionText.setSelectionColor(new Color(100, 0, 0));
        descriptionScrollPane = createScrollPane(0, 0, 400, 70, descriptionText,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER,
                BorderFactory.createLineBorder(Color.DARK_GRAY));
        descriptionFieldPanel.add(descriptionScrollPane);
        descriptionPanel.add(descriptionLabelPanel);
        descriptionPanel.add(descriptionFieldPanel);
        addToFormPanelList(descriptionPanel);
        formFieldList.add(descriptionText);
    }

    public static void createNpcCountPanel() {
        npcCountPanel = Game.createPanel(0, formPanelHeight, FORM_PANEL_WIDTH, 50, Color.black);
        npcCountPanel.setLayout(null);
        npcCountPanel.setName("NPC Count");
        npcCountLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        npcCountFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
        npcCountFieldPanel.setLayout(null);
        npcCountLabel = Game.createLabel("Number of NPCs", Color.white, Game.smallFont);
        npcCountLabelPanel.add(npcCountLabel);
        npcCountField = createIntDropdown(0, 0, 400, 20, 0, 5, Color.black, Color.white, Color.white,
                new Color(100, 0, 0), Game.xSmallFont, BorderFactory.createLineBorder(Color.DARK_GRAY));
        npcCountField.setName("NPC Count");
        npcCountField.setSelectedItem(npcCount);
        npcCountField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcCount = (Integer) npcCountField.getSelectedItem();
                clearForm();
                createDefaultFields();
            }
        });
        npcCountFieldPanel.add(npcCountField);
        npcCountPanel.add(npcCountLabelPanel);
        npcCountPanel.add(npcCountFieldPanel);
        addToFormPanelList(npcCountPanel);
    }

    public static void createItemCountPanel(int npcIndex) {
        if (npcCount - 1 < npcIndex) {
            npcItemCount.add(0);
        }

        JPanel itemCountPanel = Game.createPanel(0, formPanelHeight, FORM_PANEL_WIDTH, 50, Color.black);
        itemCountPanel.setLayout(null);
        itemCountPanel.setName("NPC-" + npcIndex + " Item Count");
        JPanel itemCountLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        JPanel itemCountFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
        itemCountFieldPanel.setLayout(null);
        JLabel itemCountLabel = Game.createLabel("Number of Items for NPC-" + npcIndex, Color.white, Game.smallFont);
        itemCountLabelPanel.add(itemCountLabel);
        JComboBox<Integer> itemCountField = createIntDropdown(0, 0, 400, 20, 0, 5, Color.black, Color.white,
                Color.white, new Color(100, 0, 0), Game.xSmallFont, BorderFactory.createLineBorder(Color.DARK_GRAY));
        itemCountField.setName("NPC-" + npcIndex + " Item Count");
        itemCountField.setSelectedItem(npcItemCount.get(npcIndex));
        itemCountField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcItemCount.set(npcIndex, (Integer) itemCountField.getSelectedItem());
                clearForm();
                createDefaultFields();
            }
        });
        itemCountFieldPanel.add(itemCountField);
        itemCountPanel.add(itemCountLabelPanel);
        itemCountPanel.add(itemCountFieldPanel);
        addToFormPanelList(itemCountPanel);
    }

    public static void createNpcPanel() {
        for (int i = 0; i < npcCount; i++) {
            npcPanel = Game.createPanel(0, formPanelHeight, FORM_PANEL_WIDTH, 50, Color.black);
            npcPanel.setLayout(null);
            npcPanel.setName("NPC-" + i);
            npcLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
            npcFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
            npcFieldPanel.setLayout(null);
            npcLabel = Game.createLabel("NPC-" + i, Color.white, Game.smallFont);
            npcLabelPanel.add(npcLabel);
            npcField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white, new Color(100, 0, 0),
                    Game.xSmallFont, BorderFactory.createLineBorder(Color.DARK_GRAY));
            npcField.setName("NPC-" + i);
            npcFieldPanel.add(npcField);
            npcPanel.add(npcLabelPanel);
            npcPanel.add(npcFieldPanel);
            addToFormPanelList(npcPanel);
            formFieldList.add(npcField);

            createInventoryPanel(i);
        }
    }

    public static void createInventoryPanel(int npcIndex) {
        createItemCountPanel(npcIndex);

        for (int i = 0; i < npcItemCount.get(npcIndex); i++) {
            inventoryPanel = Game.createPanel(0, formPanelHeight, FORM_PANEL_WIDTH, 50, Color.black);
            inventoryPanel.setLayout(null);
            inventoryPanel.setName("NPC-" + npcIndex + " Item-" + i);
            inventoryLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
            inventoryFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
            inventoryFieldPanel.setLayout(null);
            inventoryLabel = Game.createLabel("NPC-" + npcIndex + " Item-" + i, Color.white, Game.smallFont);
            inventoryLabelPanel.add(inventoryLabel);
            inventoryField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white,
                    new Color(100, 0, 0), Game.xSmallFont, BorderFactory.createLineBorder(Color.DARK_GRAY));
            inventoryField.setName("NPC-" + npcIndex + " Item-" + i);
            inventoryFieldPanel.add(inventoryField);
            inventoryPanel.add(inventoryLabelPanel);
            inventoryPanel.add(inventoryFieldPanel);
            addToFormPanelList(inventoryPanel);
            formFieldList.add(inventoryField);
        }
    }

    public static void createExitPanel() {
        exitPanel = Game.createPanel(0, formPanelHeight, FORM_PANEL_WIDTH, 50, Color.black);
        exitPanel.setLayout(null);
        exitPanel.setName("Exit");
        exitLabelPanel = Game.createPanel(10, 0, 410, 25, Color.black);
        exitFieldPanel = Game.createPanel(10, 30, 410, 20, Color.black);
        exitFieldPanel.setLayout(null);
        exitLabel = Game.createLabel("Exit", Color.white, Game.smallFont);
        exitLabelPanel.add(exitLabel);
        exitField = createTextField(0, 0, 400, 20, "", Color.black, Color.white, Color.white, new Color(100, 0, 0),
                Game.xSmallFont, BorderFactory.createLineBorder(Color.DARK_GRAY));
        exitField.setName("Exit");
        exitFieldPanel.add(exitField);
        exitPanel.add(exitLabelPanel);
        exitPanel.add(exitFieldPanel);
        addToFormPanelList(exitPanel);
        formFieldList.add(exitField);
    }

    public static void createCreateButtonPanel() {
        actionPanel = Game.createPanel(0, formPanelHeight, FORM_PANEL_WIDTH, 50, Color.black);
        actionPanel.setLayout(null);
        actionPanel.setName("Action");
        createButtonPanel = Game.createPanel(10, 0, 410, 50, Color.black);
        createButton = Game.createButton("Create", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                generateLocation();
                updateFormScrollPanelViewport();
            }
        });
        createButtonPanel.add(createButton);
        actionPanel.add(createButtonPanel);
        addToFormPanelList(actionPanel);
    }

    public static void createMapPane() {
        // Scroll Pane
        mapPanel = Game.createPanel(FORM_PANEL_WIDTH, 0, 860, 700, Color.black);
        mapPanel.setLayout(null);
        mapScrollPanelViewport = Game.createPanel(0, 0, 420, 700, Color.black); // 420, 700, 860, 699
        mapScrollPanel = createScrollPane(0, 0, 860, 699, mapScrollPanelViewport,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED,
                BorderFactory.createLineBorder(Color.DARK_GRAY));
        mapPanel.add(mapScrollPanel);

        JButton test = Game.createButton("TEST", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension viewLocation = new Dimension(mapScrollPanel.getHorizontalScrollBar().getValue(),
                        mapScrollPanel.getVerticalScrollBar().getValue());
                Dimension oldSize = mapScrollPanelViewport.getSize();
                Dimension newSize = new Dimension(1500, 820);
                viewLocation.width = (Math.abs(newSize.width - oldSize.width)) / 2 + viewLocation.width;
                mapScrollPanelViewport.setPreferredSize(newSize);
                mapScrollPanelViewport.revalidate();
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        mapScrollPanel.getHorizontalScrollBar().setValue(viewLocation.width);
                        mapScrollPanel.getVerticalScrollBar().setValue(0);
                        System.out.println(mapScrollPanel.getHorizontalScrollBar().getValue());
                    }
                });
            }
        });

        JButton test2 = Game.createButton("TEST2", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension viewLocation = new Dimension(mapScrollPanel.getHorizontalScrollBar().getValue(),
                        mapScrollPanel.getVerticalScrollBar().getValue());
                Dimension oldSize = mapScrollPanelViewport.getSize();
                Dimension newSize = new Dimension(1280, 720);
                if (oldSize.width != newSize.width && oldSize.height != newSize.height)
                    viewLocation.width = (Math.abs(newSize.width - oldSize.width)) / 2 + viewLocation.width;
                mapScrollPanelViewport.setPreferredSize(newSize);
                mapScrollPanelViewport.revalidate();
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        mapScrollPanel.getHorizontalScrollBar().setValue(viewLocation.width);
                        mapScrollPanel.getVerticalScrollBar().setValue(0);
                        System.out.println(mapScrollPanel.getHorizontalScrollBar().getValue());
                    }
                });
            }
        });

        mapScrollPanelViewport.add(test);
        mapScrollPanelViewport.add(test2);

        container.add(mapPanel);
    }

    public static JTextField createTextField(int x, int y, int width, int height, String text, Color background,
            Color foreground, Color selectedTextColor, Color highlight, Font font, Border border) {
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

    public static JComboBox<Integer> createIntDropdown(int x, int y, int width, int height, int minValue, int maxValue,
            Color background, Color foreground, Color selectedTextColor, Color highlight, Font font, Border border) {
        JComboBox<Integer> dropdown = new JComboBox<Integer>();
        dropdown.setPreferredSize(new Dimension(width, height));
        dropdown.setBounds(x, y, width, height);
        dropdown.setBackground(background);
        dropdown.setForeground(foreground);
        dropdown.setFont(font);
        dropdown.setBorder(border);

        dropdown.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel l = (JLabel) c;
                    if (isSelected) {
                        list.setSelectionForeground(selectedTextColor);
                        list.setSelectionBackground(highlight);
                    }
                    return l;
                }
                return c;
            }
        });

        for (int i = minValue; i <= maxValue; i++) {
            dropdown.addItem(i);
        }
        return dropdown;
    }

    public static JScrollPane createScrollPane(int x, int y, int width, int height, JComponent component, int vsb,
            int hsb, Border border) {
        JScrollPane scroller = new JScrollPane(component, vsb, hsb);
        scroller.setBounds(x, y, width, height);
        scroller.setBorder(border);
        return scroller;
    }

    public static void generateLocation() {
        System.out.println("+--------------------------------------+");
        for (JPanel panel : formPanelList) {
            // Iterate through list of fields
            //    if Name -> create file based on name and write name
            //    if Description -> write description
            //    ADD LOCATION INVENTORY SO THAT LOCATIONS CAN HAVE ITEMS UPON ENTERING AREA.
            //    if NPC -> write npcCount, write npc name, write npcItemCount, write item (we can get exact match for fields using values)
            //    if Exit -> write exitCount, write exitDirection (convert to integer), write exit location name
            List<JTextComponent> filteredList = formFieldList.stream()
                    .filter(field -> panel.getName().equals(field.getName())).collect(Collectors.toList());
            if (null != filteredList && filteredList.size() > 0) {
                System.out.println(filteredList.get(0).getName() + "\n" + filteredList.get(0).getText());
            }
        }
        System.out.println("+--------------------------------------+");
    }

    /* TODO: Load a locations-list.txt file for editing an existing map.
    *   - Loading in a map locations-list.txt can either overwrite or create a new locations-list.txt
    *   - Loading in a map locations-list.txt will populate exit dropdown ( If you select NORTH exit, the dropdown will include a list of locations with SOUTH exits available)
    *   - Subsequent exits will be dependent on first exit created. If you make an exit successfully, the location will be tethered to a "location on the map" and should only be able to 
    *       connect to geographically correct locations from then on.
    *       * For MYSTERIOUS locations where you can get lost, this functionality will be altered at a later date.
    *   - Implement HashMap with <key> = (x, y, z) and <value = BasicLocation
    *   - For finding "Available Exits", calculate all coordinates +-1 in x, y, z direction and find matches in HashMap
    */

}
