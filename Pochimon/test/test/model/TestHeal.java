package test.model;

import model.Pochimon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestHeal {

    @Test
    public void testHealWithinMaxHp() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Normal", null);
        pochimon.takeDamage(30);
        pochimon.heal(20);
        assertEquals(90, pochimon.getHp());
    }

    @Test
    public void testHealExceedingMaxHp() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Normal", null);
        pochimon.heal(50);
        assertEquals(100, pochimon.getHp());
    }

    @Test
    public void testHealWithZeroOrNegativeValue() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Normal", null);
        pochimon.takeDamage(20);
        pochimon.heal(0);
        assertEquals(80, pochimon.getHp());
        pochimon.heal(-10);
        assertEquals(80, pochimon.getHp());
    }
}
