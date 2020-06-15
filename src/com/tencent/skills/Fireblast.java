package com.tencent.skills;

import com.tencent.items.ItemObject;
import com.tencent.items.Weapon;
import com.tencent.mobs.Mob;

import java.util.Random;

public class Fireblast extends Skill {

    private Random randomizer = new Random();

    public Fireblast() {
        super();
        initialize();
    }

    private void initialize() {
        name = "Fireblast";
        maxTargets = 1;
        dmg = 10;
    }

    @Override
    public void doAttack(Mob receiver, Mob attacker) {
        int rawDamage = dmg;

        rawDamage += attacker.getIntelligence() * 1.5f;
        rawDamage += attacker.getMp() / 50;
        rawDamage = getItemScaling(attacker, rawDamage);

        System.out.println("Fireblast Used!");

        receiver.takeDamage(rawDamage, attacker);
    }

    @Override
    protected int getItemScaling(Mob user, int rawDmg) {
        int finalDmg = rawDmg;

        for(ItemObject item : user.getEquipedItems()) {
            if(item.getType() == ItemObject.types.WEAPON) {
                int max = ((Weapon) item).getMaxHit();
                int min = ((Weapon) item).getMinHit();
                finalDmg += randomizer.nextInt((max - min) + 1) + min;
            }
        }

        if(randomizer.nextInt(100) < user.getCritChance()) {
            finalDmg *= 2;
        }

        return finalDmg;
    }
}
