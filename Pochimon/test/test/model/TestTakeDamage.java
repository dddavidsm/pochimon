package test.model;

import model.Pochimon;
import model.Move;
import model.Type;
import model.TypeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

// Test per a heal(int amount)
class TestTakeDamage {
    private Pochimon pochimon;

    @BeforeEach
    void setUp() {
        pochimon = new Pochimon("Pochimon1", 10, 100, 50, 50, "Fire", null);
    }

    @Test
    void testTakeDamage() {
        pochimon.takeDamage(30);
        assertEquals(70, pochimon.getHp(), "La vida ha de reduir-se correctament");
        pochimon.takeDamage(100);
        assertEquals(0, pochimon.getHp(), "La vida no pot ser negativa");
        pochimon.takeDamage(-10);
        assertEquals(0, pochimon.getHp(), "No s'ha de permetre restar valors negatius");
    }
}
}