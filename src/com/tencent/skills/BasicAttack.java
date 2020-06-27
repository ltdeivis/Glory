package com.tencent.skills;

import com.tencent.items.ItemObject;
import com.tencent.items.Weapon;
import com.tencent.mobs.Mob;

import java.util.Random;

public class BasicAttack extends Skill {

    private Random randomizer = new Random();

    public BasicAttack() {
        super();
        initialize();
    }

    private void initialize() {
        name = "Basic Attack";
        maxTargets = 1;
        dmg = 1;
    }

    @Override
    public void doAttack(Mob receiver, Mob attacker) {
        int rawDamage = dmg;

        rawDamage += attacker.getAtt_speed() / 2;
        rawDamage += attacker.getAtt();
        rawDamage += attacker.getStr() * 2;
        rawDamage += attacker.getDex() / 4;

        receiver.takeDamage(getItemScaling(attacker,rawDamage), attacker);
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
            System.out.println("Basic Attack Critical Strikes!");
        }

        return finalDmg;
    }
}
