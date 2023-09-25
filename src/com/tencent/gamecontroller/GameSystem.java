package com.tencent.gamecontroller;

import com.tencent.gamecontroller.scenes.FightScene;
import com.tencent.mobs.Mob;
import com.tencent.mobs.PlayerCharacter;
import com.tencent.mobs.monsters.GeneratedMonster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSystem {

    private PlayerCharacter player;

    public GameSystem() {
        initialize();

        testFight();
    }

    private void initialize() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character name : ");

        player = new PlayerCharacter(scanner.nextLine());
    }

    private void testFight() {
        List<Mob> monsters = new ArrayList<>();
        monsters.add(new GeneratedMonster(""));
        monsters.add(new GeneratedMonster(""));

        FightScene scene = new FightScene(player, monsters);
        scene.start();

        //zzzz
    }
}
