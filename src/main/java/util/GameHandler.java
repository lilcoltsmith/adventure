package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import adventure.Game;
import components.Exit;

public class GameHandler {
	
	private Game game;
	
	public TitleScreenHandler tsHandler = new TitleScreenHandler();
	public NavigationHandler navHandler = new NavigationHandler();
	public ActionHandler actionHandler = new ActionHandler();
	public BackHandler backHandler = new BackHandler();
	public NextHandler nextHandler = new NextHandler();
	public PreviousHandler prevHandler = new PreviousHandler();
	public NorthHandler nHandler = new NorthHandler();
	public SouthHandler sHandler = new SouthHandler();
	public EastHandler eHandler = new EastHandler();
	public WestHandler wHandler = new WestHandler();
	public InHandler iHandler = new InHandler();
	public OutHandler oHandler = new OutHandler();
	public UpHandler uHandler = new UpHandler();
	public DownHandler dHandler = new DownHandler();
	public TestHandler testHandler = new TestHandler();
	
	public GameHandler(Game game) {
		this.game = game;
	}

	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createGameScreen();
		}
	}
	
	public class NavigationHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createNavigation(game.navPage);
		}
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createActions(game.actionPage);
		}
	}
	
	public class BackHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createInitialChoices();
		}
	}
	
	public class NextHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			switch(game.menuState) {
				case "main":
					break;
				case "nav":
					game.navPage++; game.createNavigation(game.navPage); break;
				case "action":
					game.actionPage++; game.createActions(game.actionPage); break;
			}
		}
	}
	
	public class PreviousHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			switch(game.menuState) {
			case "main":
				break;
			case "nav":
				game.navPage--; game.createNavigation(game.navPage); break;
			case "action":
				game.actionPage--; game.createActions(game.actionPage); break;
		}
		}
	}
	
	public class NorthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("NORTH")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class SouthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("SOUTH")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class EastHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("EAST")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class WestHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("WEST")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class InHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("IN")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class OutHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("OUT")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class UpHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("UP")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class DownHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("DOWN")) {
					game.player.setLocation(game.player.getLocation().getExits().get(i).getLeadsTo());
					game.locationLabelName.setText(game.player.getLocationName());
					game.mainTextArea.setText(game.player.getLocation().getDescription());
					game.createInitialChoices();
				}
			}
		}
	}
	
	public class TestHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			String choice = action.getActionCommand();
			switch(choice) {
				case "cut self":
					game.player.setHealth(game.player.getHealth() - 5);
					System.out.println(game.player.getHealth());
					game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
					break;
				case "jump":
					game.player.setHealth(0);
					game.hpLabelNumber.setText(Integer.toString(game.player.getHealth()));
					break;
			}
			game.createInitialChoices();
		}
	}
}
