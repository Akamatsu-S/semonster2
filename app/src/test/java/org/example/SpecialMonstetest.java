package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SpecialMonstetest {
    @Test
    public void testSummon() {
        // 正常系のテスト
        SpecialMonster monster = new SpecialMonster(0, 1);
        assertEquals("メタルスライムキング", monster.Summon(0));

        // 不正なnameNumを指定した場合のテスト
        try {
            monster.Summon(6);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("nameNumは0～5の範囲で指定してください", e.getMessage());
        }

    }
}
