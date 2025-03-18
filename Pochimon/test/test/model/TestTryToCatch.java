package test.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import model.Pochimon;
import model.Trainer;

public class TestTryToCatch {

    @Test
    public void testTryToCatchSuccess() {
        Trainer trainer = new Trainer("Ash");
        trainer.addBadge("Boulder Badge"); // Añadir una medalla
        Pochimon pochimon = new Pochimon(30); // Pochimon de nivel 30

        // Simular múltiples intentos de captura
        boolean captureResult = false;
        for (int i = 0; i < 100; i++) { // Intentar 100 veces
            if (trainer.tryToCatch(pochimon)) {
                captureResult = true;
                break;
            }
        }

        assertTrue(captureResult, "El entrenador debería poder capturar al Pochimon después de varios intentos");
    }

    @Test
    public void testTryToCatchFailure() {
        Trainer trainer = new Trainer("Ash");
        Pochimon pochimon = new Pochimon(100); // Pochimon de nivel 100 (más difícil de capturar)

        // Simular múltiples intentos de captura
        boolean captureResult = true;
        for (int i = 0; i < 100; i++) { // Intentar 100 veces
            if (!trainer.tryToCatch(pochimon)) {
                captureResult = false;
                break;
            }
        }

        assertTrue(!captureResult, "El entrenador no debería capturar al Pochimon fácilmente con un nivel tan alto");
    }

    @Test
    public void testTryToCatchNotNull() {
        Trainer trainer = new Trainer("Ash");
        Pochimon pochimon = new Pochimon(30); // Pochimon de nivel 30

        Boolean captureResult = trainer.tryToCatch(pochimon);
        assertNotNull(captureResult, "El resultado de tryToCatch no debe ser null");
    }
}