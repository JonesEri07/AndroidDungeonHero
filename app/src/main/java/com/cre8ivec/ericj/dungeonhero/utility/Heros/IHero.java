package com.cre8ivec.ericj.dungeonhero.utility.Heros;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.IWeapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class IHero {

    String name;
    Map<IItem, Integer> items;
    ArrayList<IWeapon> inventory;
    IWeapon equipedWeapon;
    Integer health;
    Integer maxHealth;
    Integer resource_front;
    Integer resource_back;

    public String getName() { return name; }

    public Map<IItem, Integer> getItems() { return items; }

    public void addItem(IItem item) {
        Set<IItem> itemKeys = items.keySet();
        boolean found = false;
        for (IItem i : itemKeys){
            if (i.getName().equals(item.getName())) {
                items.put(i, items.get(i) + 1);
                found = true;
            }
        }
        if (!found)
            items.put(item, 1);
//
//        if (items.get(item) == null)
//            items.put(item, 1);
//        else
//            items.put(item, items.get(item) + 1);
    }

    public void useItem(IItem item) {
        Set<IItem> itemKeys = items.keySet();
        IItem check = null;
        boolean found = false;
        for (IItem i : itemKeys){
            if (i.getName().equals(item.getName())) {
                items.put(i, items.get(i) - 1);
                check = i;
            }
        }
        if (check != null) {
            if (items.get(check) == 0)
                items.remove(check);
        }
    }

    public ArrayList<IWeapon> getInventory() { return inventory; }

    public void addWeapon(IWeapon weapon) { inventory.add(weapon); }

    public void dropWeapon(IWeapon weapon) { inventory.remove(weapon); }

    public void equipeWeapon(IWeapon weapon) { equipedWeapon = weapon; }

    public IWeapon getEquipedWeapon() { return equipedWeapon; }

    public Integer getHealth() {
        return health;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void attack(IMonster monster) {
        monster.takeDamage(equipedWeapon.getAttackPwr(), equipedWeapon.getElementType());
    }

    public void takeDamage(Integer attackPwr) {
        health -= attackPwr;
    }

    public Integer getResource_back() {
        return resource_back;
    }

    public Integer getResource_front() {
        return resource_front;
    }

    public void heal(Integer amount) {
        health += amount;
    }
}
