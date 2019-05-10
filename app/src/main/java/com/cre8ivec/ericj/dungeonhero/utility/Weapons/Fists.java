package com.cre8ivec.ericj.dungeonhero.utility.Weapons;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.ElementType;

public class Fists extends IWeapon {

    public Fists() {
        name = "Fists";
        attackPwr = 5;
        elementType = ElementType.Basic;
        resource = R.drawable.fist;
    }
}
