package com.cre8ivec.ericj.dungeonhero.utility.Heros;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.IWeapon;

import java.util.ArrayList;
import java.util.Map;

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
