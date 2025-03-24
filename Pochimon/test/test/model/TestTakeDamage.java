package test.model;

import model.Pochimon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTakeDamage {

    @Test
    public void testTakeValidDamage() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Normal", null);
        pochimon.takeDamage(30);
        assertEquals(70, pochimon.getHp());
    }

    @Test
    public void testTakeExcessiveDamage() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Normal", null);
        pochimon.takeDamage(150);
        assertEquals(0, pochimon.getHp());
    }

    @Test
    public void testTakeNegativeDamage() {
        Pochimon pochimon = new Pochimon("Test", 10, 100, 50, 50, "Normal", null);
        pochimon.takeDamage(-20);
        assertEquals(100, pochimon.getHp()); // No hauria de canviar
    }
}
