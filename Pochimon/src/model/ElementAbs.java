package model;

public abstract class ElementAbs {
    private String name;
    private int exp;
    private int level;
    private int expToNextLevel;

    public ElementAbs(String name, int exp, int level, int expToNextLevel) {
        this.name = name;
        this.exp = exp;
        this.level = level;
        this.expToNextLevel = expToNextLevel;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getExp() { return exp; }
    public void setExp(int exp) { this.exp = exp; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getExpToNextLevel() { return expToNextLevel; }
    public void setExpToNextLevel(int expToNextLevel) { this.expToNextLevel = expToNextLevel; }

    public void gainExp(int amount) {
        this.exp += amount;
        if (this.exp >= this.expToNextLevel) {
            levelUp();
        }
    }

    public void levelUp() {
        this.level++;
        this.exp = 0;
        this.expToNextLevel += 50; // Exemple de creixement
        System.out.println(name + " ha pujat de nivell! Ara és nivell " + level);
    }
}
