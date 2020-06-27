package com.tencent.mobs;

import com.tencent.items.ItemObject;
import com.tencent.items.Weapon;
import com.tencent.skills.Skill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mob {

    //MOB PROPERTIES
    protected String name = "";
    protected boolean alive = true;
    protected int lvl = 0;

    //BASE ATTRIBUTES
    protected int hp = 0;
    protected int maxHP = 0;
    protected int mp = 0;
    protected int stam = 0;
    protected int att = 0;
    protected int dex = 0;
    protected int str = 0;
    protected int end = 0;
    protected int intelligence = 0;
    protected int crit = 25;

    //ADVANCED ATTRIBUTES
    protected int att_speed = 0;
    protected int cast_speed = 0;
    protected int cdr_reduction = 0;
    protected List<ItemObject> equipedItems = new ArrayList<>();
    protected List<ItemObject> inventory = new ArrayList<>();

    //SKILLS
    protected List<Skill> skillList = new ArrayList<>();

    //MOB LISTENERS
    protected List<CombatListener> listeners = new ArrayList<>();

    private int lastDamageTaken;
    private int lastDamageDone;

    public Mob(String name) {
        this.name = name;
    }

    public Skill chooseSkill() {
        return null;
    }

    public void addCombatListener(CombatListener listener) {
        listeners.add(listener);
    }

    public void takeDamage(int damage, Mob attacker, boolean trueDamage) {
        attacker.activateEffects(ItemObject.combatPhase.PRE_ATT, this);
        activateEffects(ItemObject.combatPhase.PRE_DEF, attacker);

        int finalDmg = damage;
        if(!trueDamage) {
            finalDmg -= end;
            finalDmg -= dex / 3;
            finalDmg = getFinalDamage(attacker, finalDmg);
        }
        finalDmg = Math.max(finalDmg, 1);
        lastDamageTaken = finalDmg;

        System.out.println(name + " takes -" + String.valueOf(finalDmg) + " damage.");

        hp -= finalDmg;

        System.out.println(name + " has " + hp + " remaining HP");

        attacker.activateEffects(ItemObject.combatPhase.AFTER_ATT, this);
        activateEffects(ItemObject.combatPhase.AFTER_DEF, attacker);

        if(hp < 1) {
            setAlive(false);
            System.out.println(name + " died!");
        }
    }

    private int getFinalDamage(Mob attacker, int rawDmg) {
        int finalDmg = rawDmg;

        for(ItemObject item : attacker.getEquipedItems()) {
            finalDmg -= item.getEnd();
            finalDmg -= item.getDex() / 6;
        }

        return finalDmg;
    }

    public void refreshItemEffects(){
        for (ItemObject item : equipedItems){
            item.refreshEffects();
        }
    }

    public void resetItemEffects() {
        for(ItemObject item : equipedItems) {
            item.resetEffect();
        }
    }

    private void activateEffects(ItemObject.combatPhase phase, Mob m){
        for (ItemObject item : equipedItems){
            item.activateEffect(phase, m);
        }
    }

    private void adjustStats(ItemObject oldItem, ItemObject newItem) {
        if(oldItem != null) {
            att -= oldItem.getAtt();
            hp -= oldItem.getHp();
            maxHP -= oldItem.getHp();
            mp -= oldItem.getMp();
            stam -= oldItem.getStam();
            dex -= oldItem.getDex();
            str -= oldItem.getStr();
            end -= oldItem.getEnd();
            intelligence -= oldItem.getIntelligence();
            crit -= oldItem.getCrit();
            att_speed -= oldItem.getAtt_speed();
            cast_speed -= oldItem.getCast_speed();
            cdr_reduction -= oldItem.getCdr_reduction();
        }

        if(newItem != null) {
            att += newItem.getAtt();
            hp += newItem.getHp();
            maxHP += newItem.getHp();
            mp += newItem.getMp();
            stam += newItem.getStam();
            dex += newItem.getDex();
            str += newItem.getStr();
            end += newItem.getEnd();
            intelligence += newItem.getIntelligence();
            crit += newItem.getCrit();
            att_speed += newItem.getAtt_speed();
            cast_speed += newItem.getCast_speed();
            cdr_reduction += newItem.getCdr_reduction();
        }
    }

    //GETTERS & SETTERS
    public int getCritChance() {
        return crit;
    }

    public List<ItemObject> getEquipedItems() {
        return equipedItems;
    }

    public void equipItem(ItemObject toEquip) {
        if(toEquip.getLvl() < lvl) {
            ItemObject replace = null;
            for (ItemObject item : equipedItems) {
                if (item.getItemType().equals(toEquip.getItemType())) {
                    replace = item;
                    break;
                }
            }

            if (replace != null) {
                equipedItems.remove(replace);
                inventory.add(replace);
            }

            equipedItems.add(toEquip);

            adjustStats(replace, toEquip);
            System.out.println("You have equiped " + toEquip.getName());
        } else {
            System.out.println("Too low level to equip this item.");
        }
    }

    public List<ItemObject> getInventory() {
        return inventory;
    }

    public void addToInventory(ItemObject item) {
        inventory.add(item);
    }

    public void addSkill(Skill skill){
        skillList.add(skill);
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
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

    public int getLastDamageTaken() {
        return lastDamageTaken;
    }

    public int getLastDamageDone() {
        return lastDamageDone;
    }
}
