package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import adventure.Game;
import components.Item;

public class Sword extends Item{
	public Game game;
	public int damage;
	
	public Sword(Game game) {
		this.game = game;
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.actionDescriptions.add("cut self"); this.actions.add(new CutSelfHandler(this));
	};
	
	public Sword(Game game, String name, int damage) {
		this.game = game; this.name = name; this.damage = damage;
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.actionDescriptions.add("cut self"); this.actions.add(new CutSelfHandler(this));
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public class CutSelfHandler implements ActionListener {
		
		Sword sword;
		
		public CutSelfHandler(Sword sword) {
			this.sword = sword;
		}
		
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(game.player.getHealth() - sword.damage);
			System.out.println(game.player.getHealth());
			game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
			game.createInitialChoices();
		}
	}
}
