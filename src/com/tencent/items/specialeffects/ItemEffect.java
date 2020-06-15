package com.tencent.items.specialeffects;

import com.tencent.mobs.Mob;

public interface ItemEffect {

    public void passiveEffect(Mob m);

    public void preAttack(Mob m);

    public void afterAttack(Mob m);

    public void preDefence(Mob m);

    public void afterDefence(Mob m);

    public void enchance(int enchanceLvl);
}
