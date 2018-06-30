package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Location;

public class West_Forest extends Location {

	public West_Forest(String name, String description) {
		super(name, description);
		this.actions.add(new Action0());
		// TODO Auto-generated constructor stub
	}
	
	public class Action0 implements ActionListener{
		public void actionPerformed(ActionEvent action) {
			System.out.println("you're in a forest");
		}
	}

}
