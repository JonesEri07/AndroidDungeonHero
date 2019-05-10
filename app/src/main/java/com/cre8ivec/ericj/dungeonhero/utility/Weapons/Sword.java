package com.cre8ivec.ericj.dungeonhero.utility.Weapons;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.ElementType;

public class Sword extends IWeapon {

    public Sword() {
        name = "Sword";
        attackPwr = 12;
        elementType = ElementType.Basic;
        resource = R.drawable.sword;
    }
}
