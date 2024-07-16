package org.example;

public class Monster {
  // test
  private String name;
  private int rare;
  private int level;
  private int attackPower;

  public Monster(int nameNum, int rare) {
    this.name = this.Summon(nameNum);
    this.rare = rare;
    this.level = 1;
    this.attackPower = calculateAttackPower();
  }

  public int calculateAttackPower() {
    return this.rare * this.level;
  }

  public void levelUp() {
    this.level++;
    this.attackPower = calculateAttackPower();
  }

  public String Summon(int nameNum) {
    String monsters[] = { "スライム", "ドラキー", "ゴースト", "バブルスライム", "ベビーニュート", "ベビーサタン" };
    return monsters[nameNum];
  }

  public void attack() {
    System.out.println(this.name + "の攻撃！");
  }
  
  public int getLevel() {
    return this.level;
  }

  @Override
  public String toString() {
    return "モンスター名: " + this.name + " レア度: " + this.rare + " レベル: " + this.level + " 攻撃力: " + this.attackPower;
  }
}
