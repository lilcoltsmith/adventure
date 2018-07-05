package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adventure.Game;
import components.Location;

public class Awakening extends Location {
	
	private Game game;
	
	public Awakening(Game game, String name, String description) {
		super(name, description);
		this.game = game;
		this.actionDescriptions.add("cut self - 5");
		this.actions.add(new CutSelfHandler());
		this.actionDescriptions.add("cut self - 10");
		this.actions.add(new CutSelfHandler1());
		this.actionDescriptions.add("cut self - 15");
		this.actions.add(new CutSelfHandler2());
		this.actionDescriptions.add("cut self - 20");
		this.actions.add(new CutSelfHandler3());
		this.actionDescriptions.add("cut self - 25");
		this.actions.add(new CutSelfHandler4());
	}
	
	public class CutSelfHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(game.player.getHealth() - 5);
			game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
			game.createInitialChoices();
		}
	}
	
	public class CutSelfHandler1 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(game.player.getHealth() - 10);
			game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
			game.createInitialChoices();
		}
	}
	
	public class CutSelfHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(game.player.getHealth() - 15);
			game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
			game.createInitialChoices();
		}
	}
	
	public class CutSelfHandler3 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(game.player.getHealth() - 20);
			game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
			game.createInitialChoices();
		}
	}
	
	public class CutSelfHandler4 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(game.player.getHealth() - 25);
			game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
			game.createInitialChoices();
		}
	}

}
