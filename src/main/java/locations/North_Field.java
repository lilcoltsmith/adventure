package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Location;

public class North_Field extends Location {

	public North_Field(String name, String description) {
		super(name, description);
		this.actions.add(new Handler0());
		// TODO Auto-generated constructor stub
	}
	
	public class Handler0 implements ActionListener{
		public void actionPerformed(ActionEvent action) {
			System.out.println("you're in a field");
		}
	}

}
