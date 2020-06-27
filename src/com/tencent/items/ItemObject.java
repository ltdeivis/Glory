package com.tencent.items;

import com.tencent.items.specialeffects.ItemEffect;
import com.tencent.mobs.Mob;

public class ItemObject {

    //ITEM PROPERTIES
    protected String name = "";
    protected int price = 0;
    protected int durability = 0;
    protected int enchanceLevel = 0;
    protected int lvl = 0;
    protected types type;

    //BASE ATTRIBUTES MODIFIERS
    protected int hp = 0;
    protected int mp = 0;
    protected int stam = 0;
    protected int att = 0;
    protected int dex = 0;
    protected int str = 0;
    protected int end = 0;
    protected int intelligence = 0;
    protected int crit = 0;

    //ADVANCED ATTRIBUTES MODIFIERS
    protected int att_speed = 0;
    protected int cast_speed = 0;
    protected int cdr_reduction = 0;
    protected ItemEffect effect;

    //TECHNICAL ELEMENTS
    public static enum types {ARMOUR, WEAPON, USEABLE};
    protected String itemType = "";
    public static enum combatPhase { PRE_ATT, AFTER_ATT, PRE_DEF, AFTER_DEF };
    protected Mob owner;

    //EFFECT CONTROL
    private boolean preAtkUsed;
    private boolean afterAtkUsed;
    private boolean preDefUsed;
    private boolean afterDefUsed;

    public ItemObject(Mob m) {
        this.owner = m;
    }

    public void activateEffect(combatPhase phase, Mob m) {
        if(phase == combatPhase.PRE_ATT && !preAtkUsed) {
            effect.preAttack(m);
            preAtkUsed = true;
        } else if(phase == combatPhase.AFTER_ATT && !afterAtkUsed) {
            effect.afterAttack(m);
            afterAtkUsed = true;
        } else if(phase == combatPhase.PRE_DEF && !preDefUsed) {
            effect.preDefence(m);
            preDefUsed = true;
        } else if(phase == combatPhase.AFTER_DEF && !afterDefUsed) {
            effect.afterDefence(m);
            afterDefUsed = true;
        }
    }

    //GETTERS & SETTERS
    public void refreshEffects(){
        preAtkUsed = false;
        afterAtkUsed = false;
        preDefUsed = false;
        afterDefUsed = false;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public types getType() {
        return type;
    }

    public String getItemType() { return itemType; }

    public void setType(types type) {
        this.type = type;
    }

    protected void setEffect(ItemEffect effect) {
        this.effect = effect;
    }

    public int getStam() {
        return stam;
    }

    public void setStam(int stam) {
        this.stam = stam;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAtt_speed() {
        return att_speed;
    }

    public void setAtt_speed(int att_speed) {
        this.att_speed = att_speed;
    }

    public int getCast_speed() {
        return cast_speed;
    }

    public void setCast_speed(int cast_speed) {
        this.cast_speed = cast_speed;
    }

    public int getCdr_reduction() {
        return cdr_reduction;
    }

    public void setCdr_reduction(int cdr_reduction) {
        this.cdr_reduction = cdr_reduction;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getLvl() {
        return lvl;
    }

    public void setEnchanceLevel(int enchanceLevel) {
        this.enchanceLevel = enchanceLevel;
    }

    public int getEnchanceLevel() {
        return enchanceLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }
}
