package com.cre8ivec.ericj.dungeonhero.utility.Monsters;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public abstract class IMonster {

    protected static final Integer LOW_ENEMY_HEALTH = 5;
    protected static final Integer LOW_ENEMY_ATTACK = 2;

    protected static final Integer MED_ENEMY_HEALTH = 20;
    protected static final Integer MED_ENEMY_ATTACK = 15;

    protected static final Integer HIGH_ENEMY_HEALTH = 50;
    protected static final Integer HIGH_ENEMY_ATTACK = 35;


    protected String name;
    protected Integer level;
    protected Integer health;
    protected Integer attackPwr;
    protected ElementType monsterType;

    public void takeDamage(Integer damage, ElementType attackType) {
        Double scaler = adjustDamage(attackType);
        health -= (int)(damage * scaler);
        if (health < 0)
            health = 0;
    }

    private Double adjustDamage(ElementType attackType) {
        Double scaler = 1.0;
        switch (attackType) {
            case Basic:
                ;
            case Poison:
                ;
            case Fire:
                ;
            case Water:
                ;
            case Ice:
                ;
            case Dark:
                ;
        }
        return scaler;
    }

    public void attack(IHero hero) {
        hero.takeDamage(attackPwr);
    }
    public String getName() { return name; }
    public Integer getLevel() { return level; }
    public Integer getHealth() { return health; }
    public Integer getAttackPwr() { return attackPwr; }
}
