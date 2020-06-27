package com.tencent.items.specialeffects;

import com.tencent.mobs.Mob;

public interface ItemEffect {

    void passiveEffect(Mob m);

    void preAttack(Mob m);

    void afterAttack(Mob m);

    void preDefence(Mob m);

    void afterDefence(Mob m);

    void enchance(int enchanceLvl);

    void resetEffects();
}
