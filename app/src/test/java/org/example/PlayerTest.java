package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private static final String TEST_PLAYER_NAME = "testPlayer"; // テストプレイヤーの名前
    private Player player;

    /**
     * テストのセットアップメソッド
     * 各テストメソッドの前に実行され、プレイヤーオブジェクトを初期化する
     */
    @Before
    public void setUp() {
        player = new Player(new LinkedList<>(), TEST_PLAYER_NAME);
    }

    /**
     * drawMonstersメソッドのテスト
     * 指定されたモンスターIDリストに基づいてモンスターをデッキに追加する
     */
    @Test
    public void drawMonstersTest() {
        LinkedList<Integer> randomList = new LinkedList<>();
        randomList.add(0);
        randomList.add(2);
        randomList.add(1);
        player = new Player(randomList, TEST_PLAYER_NAME);
        player.drawMonsters();
        assertEquals(3, player.showDecksize()); // デッキに追加されたモンスターの数を確認
    }

    /**
     * addMonsterメソッドのテスト
     * モンスターをデッキに追加する機能を検証する
     */
    @Test
    public void addMonsterTest() {
        player.addMonster(new Monster(1, 5));
        assertEquals(1, player.showDecksize()); // デッキに追加されたモンスターの数を確認
    }

    /**
     * showDeckメソッドのテスト
     * デッキ内のモンスター情報が正しく出力されるかを検証する
     */
    @Test
    public void showDeckTest() {
        List<Monster> monsters = List.of(
            new Monster(1, 5),
            new Monster(2, 8)
        );

        // モンスターをデッキに追加
        for (Monster monster : monsters) {
            player.addMonster(monster);
        }

        // 標準出力をキャプチャする
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        player.showDeck(); // デッキの内容を表示

        // 標準出力を元に戻す
        System.setOut(originalOut);

        // キャプチャした出力を検証する
        String actualOutput = outContent.toString().replaceAll("\\s+", "");
        StringBuilder expectedOutputBuilder = new StringBuilder();
        for (Monster monster : monsters) {
            expectedOutputBuilder.append(monster.toString().replaceAll("\\s+", ""));
        }

        String expectedOutput = expectedOutputBuilder.toString();
        assertEquals(expectedOutput, actualOutput); // 期待される出力と実際の出力を比較
    }

    /**
     * levelUpAllMonstersメソッドのテスト
     * デッキ内のすべてのモンスターのレベルを上げる機能を検証する
     */
    @Test
    public void levelUpAllMonstersTest() {
        List<Monster> monsters = List.of(
            new Monster(1, 5),
            new Monster(2, 8)
        );

        // モンスターをデッキに追加
        for (Monster monster : monsters) {
            player.addMonster(monster);
        }

        // すべてのモンスターのレベルを上げる
        player.levelUpAllMonsters();

        // 各モンスターのレベルが上がったことを検証する
        for (Monster monster : player.getMonsterDeck()) {
            assertEquals(2, monster.getLevel());
        }
    }

    /**
     * attackWithAllMonstersメソッドのテスト
     * デッキ内のすべてのモンスターに攻撃させる機能を検証する
     */
    @Test
    public void attackWithAllMonstersTest() {
        List<Monster> monsters = List.of(
            new Monster(1, 5),
            new Monster(2, 8)
        );

        // モンスターをデッキに追加
        for (Monster monster : monsters) {
            player.addMonster(monster);
        }

        // 標準出力をキャプチャする
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // すべてのモンスターに攻撃させる
        player.attackWithAllMonsters();

        // 標準出力を元に戻す
        System.setOut(originalOut);

        // キャプチャした出力を検証する
        String actualOutput = outContent.toString().replaceAll("\\s+", "");
        assertTrue(actualOutput.contains("の攻撃！")); // 出力が含まれていることを確認
    }
}
