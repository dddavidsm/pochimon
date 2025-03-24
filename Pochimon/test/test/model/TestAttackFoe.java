package test.model;

import model.Pochimon;
import model.Move;
import model.Type;
import model.TypeEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAttackFoe {

    @Test
    public void testAttackReducesHp() {
        Pochimon attacker = new Pochimon("Attacker", 10, 100, 50, 50, "Normal", null);
        Pochimon defender = new Pochimon("Defender", 10, 100, 40, 50, "Normal", null);
        Move move = new Move("Tackle", 10, new Type(TypeEnum.NORMAL));

        attacker.attackFoe(defender, move);
        assertTrue(defender.getHp() < 100);
    }

    @Test
    public void testAttackOnFaintedPochimon() {
        Pochimon attacker = new Pochimon("Attacker", 10, 100, 50, 50, "Normal", null);
        Pochimon defender = new Pochimon("Defender", 10, 0, 40, 50, "Normal", null);
        Move move = new Move("Tackle", 10, new Type(TypeEnum.NORMAL));

        attacker.attackFoe(defender, move);
        assertEquals(0, defender.getHp());
    }

    @Test
    public void testAttackCallsTakeDamage() {
        Pochimon attacker = new Pochimon("Attacker", 10, 100, 50, 50, "Normal", null);
        Pochimon defender = new Pochimon("Defender", 10, 100, 40, 50, "Normal", null);
        Move move = new Move("Tackle", 10, new Type(TypeEnum.NORMAL));

        int initialHp = defender.getHp();
        attacker.attackFoe(defender, move);
        assertTrue(defender.getHp() < initialHp);
    }
}
