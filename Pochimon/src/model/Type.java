package model;
import java.util.ArrayList;

public class Type {
    private TypeEnum type;
    private ArrayList<TypeEnum> effectiveAgainst;
    private ArrayList<TypeEnum> weakAgainst;

    public Type(TypeEnum type) {
        this.type = type;
        this.effectiveAgainst = new ArrayList<>();
        this.weakAgainst = new ArrayList<>();
    }

    public TypeEnum getType() { return type; }
    public void setType(TypeEnum type) { this.type = type; }

    public ArrayList<TypeEnum> getEffectiveAgainst() { return effectiveAgainst; }
    public ArrayList<TypeEnum> getWeakAgainst() { return weakAgainst; }

    public void addEffectiveAgainst(TypeEnum t) { effectiveAgainst.add(t); }
    public void addWeakAgainst(TypeEnum t) { weakAgainst.add(t); }
}
