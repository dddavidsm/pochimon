package model;
import java.util.ArrayList;

public class PochimonSpecies {
    private String name;
    private ArrayList<Type> types;
    private PochimonSpecies evolution;

    public PochimonSpecies(String name) {
        this.name = name;
        this.types = new ArrayList<>();
        this.evolution = null;
    }

    public String getName() { return name; }

    public ArrayList<Type> getTypes() { return types; }
    public void addType(Type type) { types.add(type); }

    public PochimonSpecies getEvolution() { return evolution; }
    public void setEvolution(PochimonSpecies evolution) { this.evolution = evolution; }
}
