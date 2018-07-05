package npc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import adventure.Game;
import components.NPC;

public class Goblin extends NPC {

	public Game game;
	public int health;
	public int totalHealth;
	
	public Goblin(Game game, String name) {
		super(name);
		this.game = game;
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler());
		this.health = 50; this.totalHealth = 50;
	}
	
	public Goblin(Game game, String name, int damage) {
		super(name, damage);
		this.game = game;
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler());
		this.health = 50; this.totalHealth = 50;
	}
	
	public Goblin(Game game, String name, int damage, int health) {
		super(name, damage);
		this.game = game;
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler());
		this.health = health; this.totalHealth = health;
	}
	
	public class AttackHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			health -= 5;
			game.mainTextArea.setText("goblin: " + health + "/" + totalHealth + "\n");
			int randomDamage = new Random().nextInt(damage);
			game.updateHealth(-randomDamage);
		}
	}
	
}
