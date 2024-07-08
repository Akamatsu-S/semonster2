package org.example;

public class SpecialMonster extends Monster{
    SpecialMonster(int nameNum, int rare) {
        super(nameNum, rare);
    }

    @Override
    public String Summon(int nameNum ) {
        // nameNumの値のチェック
        if (nameNum < 0 || nameNum > 5) {
            throw new IllegalArgumentException("nameNumは0～5の範囲で指定してください");
        }
        String monsters[] = {"メタルスライムキング", "ダークドラゴン", "ファントムナイト", "トキシックスライム", "ドラゴンジュニア", "デーモンロード"};
        return monsters[nameNum];
    }
}
