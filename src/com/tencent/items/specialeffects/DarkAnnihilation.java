package com.tencent.items.specialeffects;

import com.tencent.items.ItemObject;
import com.tencent.items.Weapon;
import com.tencent.mobs.Mob;

public class DarkAnnihilation extends ItemObject implements ItemEffect, Weapon {

    //EFFECT ATTRIBUTES
    private int comboCount = 0;
    private int minHit = 10;
    private int maxHit = 19;

    //EFFECT VARS
    private int strIncrease = 0;
    private int totalStrIncrease = 0;
    private int turnToTransform = 5;
    private int currentTurn = 0;
    private boolean transformed = false;

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
        currentTurn++;
        if(currentTurn >= turnToTransform) {
            transformed = true;
            System.out.println("Power surges through Dark Anhiliation causing it to transform!");
            //TODO : Transform
        }
    }

    @Override
    public void afterAttack(Mob m) {
        if(!transformed) {
            System.out.println("Dark Annihilation grows in power...");
            strIncrease++;
            owner.setStr(owner.getStr() + strIncrease);
            totalStrIncrease += strIncrease;
            System.out.println("Current strengh of " + owner.getName() + " : " + owner.getStr()); //TODO : Remove
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
    public void resetEffects() {
        owner.setStr(owner.getStr() - totalStrIncrease);
        currentTurn = 1;
        transformed = false;
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
