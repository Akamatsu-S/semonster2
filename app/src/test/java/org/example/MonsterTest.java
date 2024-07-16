package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {
  @Test
  public void testSummon() {
    Monster monster = new Monster(0, 1);
    assertEquals("スライム", monster.Summon(0));
  }

  @Test
  public void testToString() {
    Monster monster = new Monster(0, 1);
    assertEquals("モンスター名: スライム レア度: 1 レベル: 1 攻撃力: 1", monster.toString());
  }

  @Test
  public void testLevelUp() {
    Monster monster = new Monster(1, 2);
    int initialLevel = 1;
    int initialAttackPower = monster.calculateAttackPower();
    assertEquals(initialLevel, monster.getLevel());
    assertEquals(2 * initialLevel, initialAttackPower);

    monster.levelUp();
    assertEquals(initialLevel + 1, monster.getLevel());
    assertEquals(2 * (initialLevel + 1), monster.calculateAttackPower());
  }

  @Test
  public void testAttack() {
    Monster monster = new Monster(2, 3);
    monster.levelUp();
    monster.attack();
  }
}
