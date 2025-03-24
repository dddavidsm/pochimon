package test.model;

import model.Pochimon;
import model.Type;
import model.TypeEnum;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalculateEffectivenessMultiplier {

    @Test
    public void testSuperEffective() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Fire", null);
        ArrayList<Type> enemyTypes = new ArrayList<>();
        Type grassType = new Type(TypeEnum.GRASS);
        grassType.addWeakAgainst(TypeEnum.FIRE);
        enemyTypes.add(grassType);
        
        assertEquals(2.0f, pochimon.calculateEffectivenessMultiplier(0, enemyTypes));
    }

    @Test
    public void testNotVeryEffective() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Water", null);
        ArrayList<Type> enemyTypes = new ArrayList<>();
        Type fireType = new Type(TypeEnum.FIRE);
        fireType.addEffectiveAgainst(TypeEnum.WATER);
        enemyTypes.add(fireType);

        assertEquals(0.5f, pochimon.calculateEffectivenessMultiplier(0, enemyTypes));
    }

    @Test
    public void testNeutralEffectiveness() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Normal", null);
        ArrayList<Type> enemyTypes = new ArrayList<>();

        assertEquals(1.0f, pochimon.calculateEffectivenessMultiplier(0, enemyTypes));
    }
}
