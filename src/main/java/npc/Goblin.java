package npc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import adventure.Game;
import components.NPC;
import items.Potion;

public class Goblin extends NPC {

	public Game game;
	public int health;
	public int totalHealth;
	
	public Goblin(Game game, String name) {
		super(name);
		this.game = game;
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler(this));
		this.health = 50; this.totalHealth = 50;
	}
	
	public Goblin(Game game, String name, int damage) {
		super(name, damage);
		this.game = game;
		this.inventory.addItem(new Potion(game, "goblin potion", "health", 5));
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler(this));
		this.health = 50; this.totalHealth = 50;
	}
	
	public Goblin(Game game, String name, int damage, int health) {
		super(name, damage);
		this.game = game;
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler(this));
		this.health = health; this.totalHealth = health;
	}
	
	public void kill() {
		game.player.getLocation().addItems(this.inventory.getInventory());
		game.player.getLocation().removeNPC(this);
		game.createInitialChoices();
	}
	
	public class AttackHandler implements ActionListener {
		
		NPC npc;
		
		public AttackHandler(NPC npc) {
			this.npc = npc;
		}
		
		public void actionPerformed(ActionEvent action) {
			if(health <= 5) {
				kill();
			}
			health -= 5;
			game.mainTextArea.setText("goblin: " + health + "/" + totalHealth + "\n");
			int randomDamage = new Random().nextInt(damage);
			game.mainTextArea.setText(game.mainTextArea.getText() + "The goblin hits you for " + randomDamage 
					+ " damage\n");
			game.updateHealth(-randomDamage);
		}
	}
}
