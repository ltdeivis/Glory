package com.tencent.gamecontroller.scenes;

import com.tencent.mobs.Mob;
import com.tencent.skills.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FightScene {

    private Mob player;
    private List<Mob> enemies;

    public FightScene(Mob player, List<Mob> enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    public void start() {
        boolean playerTurn = true;
        boolean battleOver = false;

        while (!battleOver) {
            if(playerTurn) {
                System.out.println("Player Turn...");
                Skill attack = player.chooseSkill();
                int target = chooseTarget();
                int targetsToHit = Math.min(attack.maxTargets, enemies.size());

                attack.doAttack(enemies.get(target), player);
                for(int i = 0; i < targetsToHit - 1; i++) {
                    if(target != i) {
                        attack.doAttack(enemies.get(i), player);
                    }
                }

                adjustEnemies();

                playerTurn = false;
            } else {
                System.out.println("Enemy Turn...");
                for(Mob m : enemies) {
                    Skill mAttack = m.chooseSkill();
                    mAttack.doAttack(player, m);
                }
                playerTurn = true;
            }
            System.out.println("---------------------------------------");
            System.out.println("");
            if(!player.isAlive()) {
                System.out.println("You are dead, game over.");
                battleOver = true;
            }
            if(enemies.size() == 0) {
                System.out.println("All enemies defeated!");
                battleOver = true;
            }
        }
    }

    private int chooseTarget() {
        System.out.println("Choose target");
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < enemies.size(); i++) {
            System.out.println(String.valueOf(i) + " : " + enemies.get(i).getName() + "   " + enemies.get(i).getHp() + "/" + enemies.get(i).getMaxHP());
        }
        return scanner.nextInt();
    }

    private void adjustEnemies() {
        List<Mob> dead = new ArrayList<>();
        for(Mob m : enemies) {
            if(!m.isAlive()) {
                dead.add(m);
            }
        }

        enemies.removeAll(dead);
    }
}
