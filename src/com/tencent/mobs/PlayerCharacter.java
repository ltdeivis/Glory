package com.tencent.mobs;

import com.tencent.items.specialeffects.DarkAnnihilation;
import com.tencent.items.specialeffects.MithrilArmour;
import com.tencent.skills.*;

import java.awt.desktop.SystemSleepEvent;
import java.util.Random;
import java.util.Scanner;

public class PlayerCharacter extends Mob {

    public PlayerCharacter(String name) {
        super(name);
        initialize();
    }

    private void initialize() {
        setAtt(10);
        setAtt_speed(5);
        setCast_speed(5);
        setCdr_reduction(25);
        setDex(35);
        setEnd(10);
        setHp(10);
        setIntelligence(15);
        setLvl(90);
        setMp(250);
        setHp(250);
        setMaxHP(250);
        setStam(10);
        setStr(28);


        addSkill(new Fireblast());
        addSkill(new BasicAttack());
        addSkill(new Iceblast());
        addSkill(new Tickle());

        equipItem(new DarkAnnihilation(this));
        equipItem(new MithrilArmour(this));
    }

    @Override
    public Skill chooseSkill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available skills : ");

        for (int i = 0; i < skillList.size(); i++){
            System.out.println(String.valueOf(i) + " : " + skillList.get(i).getName());
        }

        System.out.print("Please choose a skill to use : ");
        int selection = scanner.nextInt();

        return skillList.get(selection);
    }
}
