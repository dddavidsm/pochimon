package model;

public class Badge {
    private String name;
    private int boost;
    private int obedienceLevel;

    public Badge(String name, int boost, int obedienceLevel) {
        this.name = name;
        this.boost = boost;
        this.obedienceLevel = obedienceLevel;
    }

    public String getName() { return name; }
}
