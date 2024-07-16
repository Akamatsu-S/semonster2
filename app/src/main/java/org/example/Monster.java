package org.example;

public class Monster {
  // test
  private String name;
  private int rare;
  private int level;

  public Monster(int nameNum, int rare) {
    this.name = this.Summon(nameNum);
    this.rare = rare;
    this.level = 1;
  }

  public void levelUp() {
    this.level++;
  }

  public String Summon(int nameNum) {
    String monsters[] = { "スライム", "ドラキー", "ゴースト", "バブルスライム", "ベビーニュート", "ベビーサタン" };
    return monsters[nameNum];
  }

  @Override
  public String toString() {
    return "モンスター名: " + this.name + " レア度: " + this.rare + " レベル: " + this.level;
  }
}
