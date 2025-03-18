package model;

public class Pochimon {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private String type;
    private String evolution;

    // Constructor completo
    public Pochimon(String name, int level, int maxHp, int attack, int defense, String type, String evolution) {
        this.name = name;
        this.level = level;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.type = type;
        this.evolution = evolution;
    }
    
    public void evolve() {
        if (evolution != null && !evolution.isEmpty()) {
            this.name = evolution; // Cambiar el nombre al de la evolución
        }
    }

    // Constructor simplificado para tests (solo nivel)
    public Pochimon(int level) {
        this("Pochimon", level, 100, 50, 50, "Normal", null);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String getType() {
        return type;
    }

    public String getEvolution() {
        return evolution;
    }
}