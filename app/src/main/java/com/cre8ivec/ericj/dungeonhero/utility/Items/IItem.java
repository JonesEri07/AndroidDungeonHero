package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public abstract class IItem {
    protected String name;
    protected Integer resource;
    protected String useOnHero;

    public String getName() { return name; }
    public Integer getResource() { return resource; }
    public String isUsableOnHero() { return useOnHero; }

    public abstract void useOnHero(IHero hero);
}
