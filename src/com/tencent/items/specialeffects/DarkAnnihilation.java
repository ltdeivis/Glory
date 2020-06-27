package com.tencent.items.specialeffects;

import com.tencent.items.ItemObject;
import com.tencent.items.Weapon;
import com.tencent.mobs.Mob;

public class DarkAnnihilation extends ItemObject implements ItemEffect, Weapon {

    //EFFECT ATTRIBUTES
    private int comboCount = 0;
    private int minHit = 10;
    private int maxHit = 19;

    public DarkAnnihilation(Mob owner) {
        super(owner);
        initialize();
    }

    private void initialize() {
        setName("Dark Annihilation Spear");
        setType(types.WEAPON);
        itemType = "Weapon";
        setAtt(10);
        setAtt_speed(5);
        setCast_speed(5);
        setCdr_reduction(25);
        setDex(35);
        setDurability(100);
        setEnchanceLevel(0);
        setEnd(0);
        setHp(0);
        setIntelligence(15);
        setLvl(50);
        setMp(250);
        setPrice(10000);
        setStam(10);
        setStr(28);
        setCrit(25);
        setEffect(this);
    }

    @Override
    public void passiveEffect(Mob m) {

    }

    @Override
    public void preAttack(Mob m) {

    }

    @Override
    public void afterAttack(Mob m) {
        int damageCount = owner.getLastDamageDone();
        if(damageCount > 20){
            System.out.println("The weapon grows in power.");
            setStr(str + 5);
            System.out.println(str);
        }
    }

    @Override
    public void preDefence(Mob m) {

    }

    @Override
    public void afterDefence(Mob m) {

    }

    @Override
    public void enchance(int enchanceLvl) {

    }

    @Override
    public int getMinHit() {
        return minHit;
    }

    @Override
    public int getMaxHit() {
        return maxHit;
    }
}
