package npc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.NPC;
import game.Game;

public class Enemy extends NPC {
	
	public Enemy(String name, int damage, int defence, int health) {
		super(name, damage, defence, health);
		this.actionDescriptions.add("attack"); this.actions.add(new AttackHandler(this));
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
