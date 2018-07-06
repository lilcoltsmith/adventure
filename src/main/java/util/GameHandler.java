package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import adventure.Game;
import components.Exit;

public class GameHandler {
	
	private Game game;
	
	public TitleScreenHandler tsHandler = new TitleScreenHandler();
	public ResetHandler resetHandler = new ResetHandler();
	public NavigationHandler navHandler = new NavigationHandler();
	public ActionHandler actionHandler = new ActionHandler();
	public InventoryHandler inventoryHandler = new InventoryHandler();
	public ItemHandler itemHandler = new ItemHandler();
	public NpcHandler npcHandler = new NpcHandler();
	public MapHandler mapHandler = new MapHandler();
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
	
	public GameHandler(Game game) {
		this.game = game;
	}

	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createGameScreen();
		}
	}
	
	public class ResetHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.resetGame();
		}
	}
	
	public class NavigationHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createNavigation(game.navPage);
		}
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createActions(game.actionPage, "general", 0);
		}
	}
	
	public class InventoryHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createInventory(game.inventoryPage);
		}
	}
	
	public class ItemHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createActions(game.actionPage, "item", Integer.parseInt(action.getActionCommand()));
		}
	}
	
	public class NpcHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.createActions(game.npcPage, "npc", 0);
		}
	}
	
	public class MapHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = game.player.getLocation().getExits();
			String exitStr = "";
			for(Exit e : exits) {
				exitStr += e.getDirectionName() + ": " + e.getLeadsTo().getName() + "\n";
			}
			game.mainTextArea.setText(exitStr);
			game.createInitialChoices();
		}
	}
	
	public class BackHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.mainTextArea.setText(game.player.getLocation().getDescription());
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
					game.actionPage++; game.createActions(game.actionPage, "general", 0); break;
				case "inventory":
					game.inventoryPage++; game.createInventory(game.inventoryPage); break;
				case "npc":
					game.npcPage++; game.createActions(game.npcPage, "npc", 0); break;
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
				game.actionPage--; game.createActions(game.actionPage, "general", 0); break;
			case "inventory":
				game.inventoryPage--; game.createInventory(game.inventoryPage); break;
			case "npc":
				game.npcPage--; game.createActions(game.npcPage, "npc", 0); break;
		}
		}
	}
	
	public class NorthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("NORTH");
		}
	}
	
	public class SouthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("SOUTH");
		}
	}
	
	public class EastHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("EAST");
		}
	}
	
	public class WestHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("WEST");
		}
	}
	
	public class InHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("IN");
		}
	}
	
	public class OutHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("OUT");
		}
	}
	
	public class UpHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("UP");
		}
	}
	
	public class DownHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.updateLocation("DOWN");
		}
	}
}
