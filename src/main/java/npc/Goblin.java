package npc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import components.Inventory;
import components.NPC;
import game.Game;
import items.Potion;

public class Goblin extends NPC {
	
	public Goblin(String name, int damage, int defence, int health) {
		this.name = name; this.damage = damage; this.defence = defence;
		this.inventory = new Inventory();
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.inventory.addItem(new Potion("goblin potion", "health", 5));
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler(this));
		this.health = health; this.totalHealth = health;
	}
	
	public class AttackHandler implements ActionListener {
		
		NPC npc;
		
		public AttackHandler(NPC npc) {
			this.npc = npc;
		}
		
		public void actionPerformed(ActionEvent action) {
			Game.attackEnemy(npc);
		}
	}
}
