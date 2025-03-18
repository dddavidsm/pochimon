package model;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
	private static int idCounter = 1;

	private String name;
	private int id;
	private int level;
	private int experience;
	private List<String> badges;
	private List<Pochimon> team;

	// Constructor
	public Trainer(String name) {
		this.name = name;
		this.id = idCounter++;
		this.level = 1;
		this.experience = 0;
		this.badges = new ArrayList<>();
		this.team = new ArrayList<>();
	}

	public boolean tryToCatch(Pochimon pochimon) {
		double captureRate = getCaptureRate(pochimon);
		int randomValue = (int) (Math.random() * 100) + 1; // Número aleatorio entre 1 y 100
		return randomValue <= captureRate; // True si el número aleatorio es menor o igual a la tasa de captura
	}


	// Getters y setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getLevel() {
		return level;
	}

	public int getExperience() {
		return experience;
	}

	public List<String> getBadges() {
		return badges;
	}

	public List<Pochimon> getTeam() {
		return team;
	}

	// Métodos principales
	public void addBadge(String badge) {
		badges.add(badge);
	}

	public int getNumberOfBadges() {
		return badges.size(); // El número de medallas es el tamaño de la lista de badges
	}

	public void addPochimon(Pochimon pochimon) {
		if (team.size() < 6) {
			team.add(pochimon);
		} else {
			System.out.println("Your team is full!");
		}
	}

	public void removePochimon(Pochimon pochimon) {
		team.remove(pochimon);
	}

	public void gainExperience(int xp) {
		this.experience += xp;
		if (this.experience >= 100) { // Ejemplo: 100 XP para subir de nivel
			levelUp();
		}
	}

	private void levelUp() {
		this.level++;
		this.experience = 0;
		System.out.println(name + " has leveled up to level " + level + "!");
	}

	// Método para calcular la tasa de captura
	public double getCaptureRate(Pochimon pochimon) {
		double captureRate = (this.level * 1.5) + (this.getNumberOfBadges() * 5) - (pochimon.getLevel() * 0.5);
		return Math.max(1, Math.min(99, captureRate)); // Asegurar que esté entre 1% y 99%
	}



}

