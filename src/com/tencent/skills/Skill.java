package com.tencent.skills;

import com.tencent.items.ItemObject;
import com.tencent.mobs.Mob;

public class Skill {

    protected int dmg = 0;

    protected String name;
    public int maxTargets = 0;

    public Skill() {

    }

    public void doAttack(Mob receiver, Mob attacker) {
        return;
    }

    public String getName(){
        return name;
    }

    protected int getItemScaling(Mob user, int rawDmg) {
        return 0;
    }
}