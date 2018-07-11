package components;

import adventure.Game;
import items.Armor;
import items.Weapon;

public class Equipment {
	public Inventory inventory;
	public Armor head;
	public Armor chest;
	public Armor legs;
	public Weapon rightHand;
	public Item offHand;
	
	public Equipment(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void equip(Item item) {
		switch(item.getClass().getName()) {
			case "items.Weapon":
				switch(item.type) {
				case "rightHand":
					unequip("rightHand"); setRightHand((Weapon) item); removeFromInventory(item); break;
				case "offHand":
					unequip("offHand"); setOffHand((Weapon) item); removeFromInventory(item); break;
			}
			case "items.Armor":
				switch(item.type) {
					case "head":
						unequip("head"); setHead((Armor) item); removeFromInventory(item); break;
					case "chest":
						unequip("chest"); setChest((Armor) item); removeFromInventory(item); break;
					case "legs":
						unequip("legs"); setLegs((Armor) item); removeFromInventory(item); break;
					case "offHand":
						unequip("offHand"); setOffHand((Armor) item); removeFromInventory(item); break;
				}
		}
	}
	
	public void unequip(String item) {
		switch(item) {
			case "head":
				if(head != null) Game.player.setDefence(Game.player.getDefence() - this.head.defence); addToInventory(head); head = null; break;
			case "chest":
				if(chest != null) Game.player.setDefence(Game.player.getDefence() - this.chest.defence); addToInventory(chest); chest = null; break;
			case "legs":
				if(legs != null) Game.player.setDefence(Game.player.getDefence() - this.legs.defence); addToInventory(legs); legs = null; break;
			case "rightHand":
				if(rightHand != null) Game.player.setDamage(5); addToInventory(rightHand); rightHand = null; break;
			case "offHand":
				if(offHand != null) addToInventory(offHand); offHand = null; break;
		}
	}
	
	public void removeFromInventory(Item item) {
		inventory.removeItem(item);
	}
	
	public void addToInventory(Item item) {
		inventory.addItem(item);
	}

	public Item getHead() {
		return head;
	}

	public void setHead(Armor head) {
		this.head = head;
		Game.player.setDefence(Game.player.getDefence() + head.defence);
	}

	public Item getChest() {
		return chest;
	}

	public void setChest(Armor chest) {
		this.chest = chest;
		Game.player.setDefence(Game.player.getDefence() + chest.defence);
	}

	public Item getLegs() {
		return legs;
	}

	public void setLegs(Armor legs) {
		this.legs = legs;
		Game.player.setDefence(Game.player.getDefence() + legs.defence);
	}

	public Item getRightHand() {
		return rightHand;
	}

	public void setRightHand(Weapon rightHand) {
		this.rightHand = rightHand;
		Game.player.setDamage(rightHand.damage);
	}

	public Item getOffHand() {
		return offHand;
	}

	public void setOffHand(Item offHand) {
		this.offHand = offHand;
	}
}
