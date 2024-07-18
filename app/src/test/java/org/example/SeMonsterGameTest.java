package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SeMonsterGameTest {
    @Test

    public void DrawMonstersTest() {
        SeMonsterGame game = new SeMonsterGame(4);
        game.addPlayer("Player1", 3);

        assertNotNull(game.playerMap.get("Player1"));
        assertEquals(3, game.playerMap.get("Player1").getMosterDeck().size());

    }

}