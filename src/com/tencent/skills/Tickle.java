package com.tencent.skills;

import com.tencent.items.ItemObject;
import com.tencent.items.Weapon;
import com.tencent.mobs.Mob;

import java.util.Random;

public class Tickle extends Skill {

    private Random randomizer = new Random();

    public Tickle() {
        super();
        initialize();
    }

    private void initialize() {
        name = "Tickle";
        maxTargets = 1;
        dmg = 1;
    }

    @Override
    public void doAttack(Mob receiver, Mob attacker) {
        int rawDamage = dmg;

        rawDamage = getItemScaling(attacker, rawDamage);

        System.out.println("Tickle Used!");

        receiver.takeDamage(rawDamage, attacker, false);
    }

    @Override
    protected int getItemScaling(Mob user, int rawDmg) {
        int finalDmg = rawDmg;

        return finalDmg;
    }
}
