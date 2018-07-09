package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import adventure.Game;
import components.Exit;

public class GameHandler {
		
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
	
	public GameHandler() {
		
	}

	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.createGameScreen();
		}
	}
	
	public class ResetHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.resetGame();
		}
	}
	
	public class NavigationHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.createNavigation(Game.navPage);
		}
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.createActions(Game.actionPage, "general", 0);
		}
	}
	
	public class InventoryHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.createInventory(Game.inventoryPage);
		}
	}
	
	public class ItemHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.createActions(Game.actionPage, "item", Integer.parseInt(action.getActionCommand()));
		}
	}
	
	public class NpcHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.createActions(Game.npcPage, "npc", 0);
		}
	}
	
	public class MapHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = Game.player.getLocation().getExits();
			String exitStr = "";
			for(Exit e : exits) {
				exitStr += e.getDirectionName() + ": " + e.getLeadsTo().getName() + "\n";
			}
			Game.mainTextArea.setText(exitStr);
			Game.createInitialChoices();
		}
	}
	
	public class BackHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.mainTextArea.setText(Game.player.getLocation().getDescription());
			Game.createInitialChoices();
		}
	}
	
	public class NextHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			switch(Game.menuState) {
				case "main":
					break;
				case "nav":
					Game.navPage++; Game.createNavigation(Game.navPage); break;
				case "action":
					Game.actionPage++; Game.createActions(Game.actionPage, "general", 0); break;
				case "inventory":
					Game.inventoryPage++; Game.createInventory(Game.inventoryPage); break;
				case "npc":
					Game.npcPage++; Game.createActions(Game.npcPage, "npc", 0); break;
			}
		}
	}
	
	public class PreviousHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			switch(Game.menuState) {
			case "main":
				break;
			case "nav":
				Game.navPage--; Game.createNavigation(Game.navPage); break;
			case "action":
				Game.actionPage--; Game.createActions(Game.actionPage, "general", 0); break;
			case "inventory":
				Game.inventoryPage--; Game.createInventory(Game.inventoryPage); break;
			case "npc":
				Game.npcPage--; Game.createActions(Game.npcPage, "npc", 0); break;
		}
		}
	}
	
	public class NorthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("NORTH");
		}
	}
	
	public class SouthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("SOUTH");
		}
	}
	
	public class EastHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("EAST");
		}
	}
	
	public class WestHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("WEST");
		}
	}
	
	public class InHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("IN");
		}
	}
	
	public class OutHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("OUT");
		}
	}
	
	public class UpHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("UP");
		}
	}
	
	public class DownHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.updateLocation("DOWN");
		}
	}
}
