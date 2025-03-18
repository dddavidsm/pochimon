package test.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import model.Pochimon;
import model.Trainer;

public class TestCaptureRate {

    @Test
    public void testCaptureRateWithinBounds() {
        Trainer trainer = new Trainer("Ash");
        trainer.addBadge("Boulder Badge"); // Añadir una medalla
        trainer.addBadge("Cascade Badge"); // Añadir otra medalla
        Pochimon pochimon = new Pochimon(30); // Pochimon de nivel 30

        double captureRate = trainer.getCaptureRate(pochimon);
        assertTrue("La tasa de captura debe estar entre 1% y 99%", captureRate >= 1 && captureRate <= 99);
    }

    @Test
    public void testCaptureRateWithDifferentLevels() {
        Trainer trainerLowLevel = new Trainer("Ash");
        Trainer trainerHighLevel = new Trainer("Misty");
        trainerHighLevel.gainExperience(100); // Subir de nivel a Misty

        Pochimon pochimonLowLevel = new Pochimon(1); // Pochimon de nivel 1
        Pochimon pochimonHighLevel = new Pochimon(100); // Pochimon de nivel 100

        double captureRateLowLevel = trainerLowLevel.getCaptureRate(pochimonLowLevel);
        double captureRateHighLevel = trainerHighLevel.getCaptureRate(pochimonHighLevel);

        assertTrue("La tasa de captura con niveles bajos debe ser baja", captureRateLowLevel < captureRateHighLevel);
    }

    @Test
    public void testCaptureRateWithMedals() {
        Trainer trainerNoMedals = new Trainer("Ash");
        Trainer trainerWithMedals = new Trainer("Misty");
        trainerWithMedals.addBadge("Boulder Badge"); // Añadir una medalla
        trainerWithMedals.addBadge("Cascade Badge"); // Añadir otra medalla

        Pochimon pochimon = new Pochimon(30); // Pochimon de nivel 30

        double captureRateNoMedals = trainerNoMedals.getCaptureRate(pochimon);
        double captureRateWithMedals = trainerWithMedals.getCaptureRate(pochimon);

        assertTrue("La tasa de captura debe aumentar con más medallas", captureRateWithMedals > captureRateNoMedals);
    }
}