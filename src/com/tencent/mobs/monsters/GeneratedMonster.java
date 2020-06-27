package com.tencent.mobs.monsters;

import com.tencent.mobs.Mob;
import com.tencent.skills.BasicAttack;
import com.tencent.skills.Fireblast;
import com.tencent.skills.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratedMonster extends Mob {

    private List<String> firstNamePool = new ArrayList<String>();
    private List<String> surNamePool = new ArrayList<String>();

    public GeneratedMonster(String name) {
        super(name);
        initialize();
    }

    private void initialize() {
        initNamePool();

        Random rng = new Random();

        setName(firstNamePool.get(rng.nextInt(firstNamePool.size())) + " " + surNamePool.get(rng.nextInt(surNamePool.size())));
        setAtt(rng.nextInt(55));
        setAtt_speed(rng.nextInt(10));
        setCast_speed(rng.nextInt(10));
        setCdr_reduction(rng.nextInt(35));
        setDex(rng.nextInt(46));
        setEnd(rng.nextInt(15));
        setHp(rng.nextInt(15));
        setIntelligence(rng.nextInt(20));
        setLvl(rng.nextInt(20));
        setMp(rng.nextInt(350));
        setHp(rng.nextInt(350));
        setMaxHP(getHp());
        setStam(rng.nextInt(15));
        setStr(rng.nextInt(36));
    }

    private void initNamePool(){
        firstNamePool.add("Pantera");
        firstNamePool.add("Petra");
        firstNamePool.add("Reptilius");
        firstNamePool.add("Balea");
        firstNamePool.add("Subaru");
        firstNamePool.add("Dark witch");
        firstNamePool.add("Red Demon");
        firstNamePool.add("Furry");
        firstNamePool.add("Lanostra");
        firstNamePool.add("Cosa");

        surNamePool.add("Manora");
        surNamePool.add("Misery");
        surNamePool.add("of the dark woods");
        surNamePool.add("of the fallen legion");
        surNamePool.add("of the no mans world");
        surNamePool.add("tomazelli");
        surNamePool.add("liveris");
        surNamePool.add("patajotti");
        surNamePool.add("of crackland");
        surNamePool.add("of BU");
    }

    @Override
    public Skill chooseSkill() {
        BasicAttack skill = new BasicAttack();
        skill.maxTargets = 1;

        System.out.println(name + ", uses Basic Attack");

        return skill;
    }

}
