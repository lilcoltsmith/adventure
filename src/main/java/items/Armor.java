package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import adventure.Game;
import components.Item;

public class Armor extends Item {
	public Game game;
	public int defence;
	
	public Armor(Game game, String name, String type, int defence) {
		this.game = game; this.name = name; this.type = type; this.defence = defence;
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.actionDescriptions.add("equip"); this.actions.add(new EquipHandler(this));
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	public class EquipHandler implements ActionListener {
		Armor armor;
		
		public EquipHandler(Armor armor) {
			this.armor = armor;
		}
		
		public void actionPerformed(ActionEvent action) {
			game.player.getEquipment().equip(armor);
			game.createInitialChoices();
		}
	}
}
