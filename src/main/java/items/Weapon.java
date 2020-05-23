package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Item;
import game.Game;

public class Weapon extends Item {
	public int damage;
	
	public Weapon(String name, String type, int damage) {
		super(name, type);
		this.damage = damage;
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
