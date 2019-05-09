package com.cre8ivec.ericj.dungeonhero.utility.Weapons;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;

public abstract class IWeapon {
    protected String name;
    protected Integer attackPwr;
    protected ElementType elementType;

    public String getName() { return name; }
    public Integer getAttackPwr() { return attackPwr; }
    public ElementType getElementType() { return elementType; }
}
