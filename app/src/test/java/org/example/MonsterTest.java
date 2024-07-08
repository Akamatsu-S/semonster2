package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {
    @Test
    public void testSummon() {
        Monster monster = new Monster(0, 1);
        assertEquals("スライム", monster.Summon(0));
    }
}
