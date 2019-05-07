package com.cre8ivec.ericj.dungeonhero.utility.Heros;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.IWeapon;

import java.util.ArrayList;
import java.util.Map;

public abstract class IHero {

    String name;
    Map<IItem, Integer> items;
    ArrayList<IWeapon> inventory;
    IWeapon equipedWeapon;

    public String getName() { return name; }

    public Map<IItem, Integer> getItems() { return items; }

    public void addItem(IItem item) {
        if (items.get(item) == null)
            items.put(item, 1);
        else
            items.put(item, items.get(item) + 1);
    }

    public void useItem(IItem item) { items.remove(item); }

    public ArrayList<IWeapon> getInventory() { return inventory; }

    public void addWeapon(IWeapon weapon) { inventory.add(weapon); }

    public void dropWeapon(IWeapon weapon) { inventory.remove(weapon); }

    public void equipeWeapon(IWeapon weapon) { equipedWeapon = weapon; }

    public IWeapon getEquipedWeapon() { return equipedWeapon; }

}
