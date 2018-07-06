package npc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import adventure.Game;
import components.Inventory;
import components.NPC;
import items.Potion;

public class Goblin extends NPC {

	public Game game;
	
	public Goblin(Game game, String name, int damage, int health) {
		this.game = game; this.name = name; this.damage = damage;
		this.inventory = new Inventory();
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.inventory.addItem(new Potion(game, "goblin potion", "health", 5));
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler(this));
		this.health = health; this.totalHealth = health;
	}
	
	public class AttackHandler implements ActionListener {
		
		NPC npc;
		
		public AttackHandler(NPC npc) {
			this.npc = npc;
		}
		
		public void actionPerformed(ActionEvent action) {
			game.attackEnemy(npc);
		}
	}
}
