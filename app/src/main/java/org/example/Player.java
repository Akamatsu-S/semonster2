package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
    private LinkedList<Integer> randomList; // モンスターIDのリスト
    private String name; // プレイヤーの名前
    private ArrayList<Monster> monsterDeck; // プレイヤーのモンスターのデッキ

    /**
     * コンストラクタ - プレイヤーオブジェクトを初期化
     * 
     * @param randomList モンスターIDのリスト
     * @param name プレイヤーの名前
     */
    public Player(LinkedList<Integer> randomList, String name) {
        this.randomList = randomList;
        this.name = name;
        this.monsterDeck = new ArrayList<>();
    }

    /**
     * モンスターをデッキに追加するメソッド
     * randomListに基づいてランダムにモンスターを生成し、デッキに追加する
     */
    public void drawMonsters() {
        for (int id : randomList) {
            monsterDeck.add(new Monster(id, (int)(Math.random() * 10) + 1)); // ランダムな攻撃力を持つモンスターを生成
        }
    }

    /**
     * モンスターのデッキを取得するメソッド
     * 
     * @return モンスターのデッキ
     */
    public ArrayList<Monster> getMonsterDeck() {
        return monsterDeck;
    }

    /**
     * プレイヤーの名前を取得するメソッド
     * 
     * @return プレイヤーの名前
     */
    public String getName() {
        return name;
    }

    /**
     * モンスターのデッキのサイズを取得するメソッド
     * 
     * @return モンスターのデッキのサイズ
     */
    public int showDecksize() {
        return monsterDeck.size();
    }

    /**
     * モンスターをデッキに追加するメソッド
     * 
     * @param monster 追加するモンスター
     */
    public void addMonster(Monster monster) {
        monsterDeck.add(monster);
    }

    /**
     * デッキのモンスターを表示するメソッド
     * 各モンスターの情報を標準出力に表示する
     */
    public void showDeck() {
        for (Monster monster : monsterDeck) {
            // toStringメソッドを使用してMonsterオブジェクトの情報を出力
            System.out.println(monster.toString());
        }
    }

    /**
     * デッキ内のすべてのモンスターのレベルを上げるメソッド
     */
    public void levelUpAllMonsters() {
        for (Monster monster : monsterDeck) {
            monster.levelUp();
        }
    }

    /**
     * デッキ内のすべてのモンスターに攻撃させるメソッド
     */
    public void attackWithAllMonsters() {
        for (Monster monster : monsterDeck) {
            monster.attack();
        }
    }
}
