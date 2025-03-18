package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import model.Pochimon;

public class TestEvolve {

    @Test
    public void testEvolveWithEvolutionAvailable() {
        Pochimon pochimon = new Pochimon("Pikachu", 25, 100, 50, 50, "Electric", "Raichu");

        // Verificar que el Pochimon evoluciona correctamente
        pochimon.evolve();
        assertEquals("Raichu", pochimon.getName(), "El Pochimon debería evolucionar a Raichu");
    }

    @Test
    public void testEvolveWithoutEvolutionAvailable() {
        Pochimon pochimon = new Pochimon("Pikachu", 25, 100, 50, 50, "Electric", null);

        // Verificar que el Pochimon no evoluciona
        String originalName = pochimon.getName();
        pochimon.evolve();
        assertEquals(originalName, pochimon.getName(), "El Pochimon no debería evolucionar si no tiene evolución disponible");
    }
}