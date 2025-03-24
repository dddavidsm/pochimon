package test.model;

import model.Pochimon;
import model.Type;
import model.TypeEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestCalculateDamage {

    @Test
    public void testBasicDamageCalculation() {
        Pochimon attacker = new Pochimon("Attacker", 10, 100, 50, 50, "Normal", null);
        Pochimon defender = new Pochimon("Defender", 10, 100, 40, 50, "Normal", null);

        int damage = attacker.calculateDamage(defender, 0);
        assertEquals(0, damage);
    }

    @Test
    public void testDamageWithEffectiveness() {
        Pochimon attacker = new Pochimon("Attacker", 10, 100, 50, 50, "Fire", null);
        Pochimon defender = new Pochimon("Defender", 10, 100, 40, 50, "Grass", null);

        ArrayList<Type> enemyTypes = new ArrayList<>();
        Type grassType = new Type(TypeEnum.GRASS);
        grassType.addWeakAgainst(TypeEnum.FIRE);
        enemyTypes.add(grassType);

        int damage = (int) ((50 - 50) * 2.0); // Simulació de dany
        assertEquals(damage, attacker.calculateDamage(defender, 0));
    }
}
