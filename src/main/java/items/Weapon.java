package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import adventure.Game;
import components.Item;

public class Weapon extends Item {
	public int damage;
	
	public Weapon(String name, String type, int damage) {
		this.name = name; this.type = type; this.damage = damage;
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.actionDescriptions.add("equip"); this.actions.add(new EquipHandler(this));
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public class EquipHandler implements ActionListener {
		Weapon sword;
		
		public EquipHandler(Weapon sword) {
			this.sword = sword;
		}
		
		public void actionPerformed(ActionEvent action) {
			Game.player.getEquipment().equip(sword);
			Game.createInitialChoices();
		}
	}
}
