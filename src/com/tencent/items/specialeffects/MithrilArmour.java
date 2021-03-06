package com.tencent.items.specialeffects;

import com.tencent.items.ItemObject;
import com.tencent.items.Weapon;
import com.tencent.mobs.Mob;

public class MithrilArmour extends ItemObject implements ItemEffect, Weapon {

    public MithrilArmour(Mob owner){
        super(owner);
        initialize();
    }

    public void initialize(){
        setName("Armour of Mithril");
        setType(types.WEAPON);
        itemType = "Armour";
        setAtt(0);
        setAtt_speed(0);
        setCast_speed(0);
        setCdr_reduction(25);
        setDex(50);
        setDurability(250);
        setEnchanceLevel(0);
        setEnd(35);
        setHp(40);
        setIntelligence(0);
        setLvl(50);
        setMp(100);
        setPrice(10000);
        setStam(10);
        setStr(0);
        setCrit(0);
        setEffect(this);
    }

    @Override
    public int getMinHit() {
        return 0;
    }

    @Override
    public int getMaxHit() {
        return 0;
    }

    @Override
    public void passiveEffect(Mob m) {

    }

    @Override
    public void preAttack(Mob m) {

    }

    @Override
    public void afterAttack(Mob m) {

    }

    @Override
    public void preDefence(Mob m) {

    }

    @Override
    public void afterDefence(Mob m) {
        System.out.println(owner.getName() + "'s, Mithril armour thorns activated!");
        float returnDamage = owner.getLastDamageTaken() * 0.2f;
        int finalDmg = Math.max(Math.round(returnDamage) , 1);
        m.takeDamage(finalDmg, owner, true);
    }

    @Override
    public void enchance(int enchanceLvl) {

    }

    @Override
    public void resetEffects() {

    }
}
