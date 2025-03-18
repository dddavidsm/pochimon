package model;

import model.ElementAbs;
import model.Type;

public class Move extends ElementAbs {
	private int powerPoints;
	private int maxPowerPoints;
	private Type type;

	public Move(String name, int powerPoints, Type type) {
		super(name, 0, 1, 100);
		this.powerPoints = powerPoints;
		this.maxPowerPoints = powerPoints;
		this.type = type;
	}

	public int getPowerPoints() { return powerPoints; }
	public void useMove() {
		if (powerPoints > 0) {
			powerPoints--;
			System.out.println(getName() + " s'ha utilitzat. Queden " + powerPoints + " PP.");
		} else {
			System.out.println(getName() + " no té PP disponibles!");
		}
	}

	public void restorePP() { this.powerPoints = maxPowerPoints; }

	public Type getType() { return type; }
	public void setType(Type type) { this.type = type; }

	public boolean isSpecial() {

		return false; 
	}
}
