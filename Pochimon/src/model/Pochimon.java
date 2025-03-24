package model;

import java.util.ArrayList;

public class Pochimon {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private String type;
    private String evolution;

    // Constructor complet
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
            this.name = evolution; // Canviar el nom al de l’evolució
        }
    }

    // Constructor simplificat per a tests (només nivell)
    public Pochimon(int level) {
        this("Pochimon", level, 100, 50, 50, "Normal", null);
    }

    // Getters
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public String getType() { return type; }
    public String getEvolution() { return evolution; }

    // Métode per curar el Pochimon
    public void heal(int amount) {
        if (amount > 0) {
            hp = Math.min(hp + amount, maxHp); // Evita superar el màxim HP
        }
    }

    // Métode per rebre dany
    public void takeDamage(int amount) {
        if (amount > 0) {
            hp = Math.max(hp - amount, 0); // Evita que l’HP sigui negatiu
        }
    }

    // Métode per calcular l'efectivitat d'un atac
    public float calculateEffectivenessMultiplier(int movementIndex, ArrayList<Type> enemyTypes) {
        if (enemyTypes == null || enemyTypes.isEmpty()) return 1.0f;
        
        float multiplier = 1.0f;
        for (Type enemyType : enemyTypes) {
            if (enemyType.getWeakAgainst().contains(TypeEnum.valueOf(type.toUpperCase()))) {
                multiplier *= 2.0f; // Si l’enemic és feble, el dany es multiplica
            } else if (enemyType.getEffectiveAgainst().contains(TypeEnum.valueOf(type.toUpperCase()))) {
                multiplier *= 0.5f; // Si l’enemic és resistent, el dany es redueix
            }
        }
        return multiplier;
    }

    // Métode per calcular el dany d'un atac
    public int calculateDamage(Pochimon enemy, int movementIndex) {
        float effectiveness = calculateEffectivenessMultiplier(movementIndex, enemy.getTypes());
        return (int) ((attack - enemy.getDefense()) * effectiveness);
    }

    // Métode per atacar un enemic
    public void attackFoe(Pochimon enemy, Move move) {
        if (hp > 0 && enemy.getHp() > 0) {
            int damage = calculateDamage(enemy, 0);
            enemy.takeDamage(damage);
        }
    }

    // Retorna una llista amb els tipus del Pochimon (simulat)
    public ArrayList<Type> getTypes() {
        ArrayList<Type> types = new ArrayList<>();
        types.add(new Type(TypeEnum.valueOf(type.toUpperCase())));
        return types;
    }
}
