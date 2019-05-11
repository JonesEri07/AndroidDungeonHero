package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory.IDungeon;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttackFragment extends Fragment {


    public AttackFragment() {
        // Required empty public constructor
    }

    private IDungeon dungeon;
    private IHero hero;
    private IMonster monster;

    private ImageView monsterImage;
    private ImageView heroImage;
    private TextView monsterName;
    private TextView heroHealthAmount;
    private ProgressBar monsterHealth;
    private ProgressBar heroHealth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_attack, container, false);

        dungeon = ((GameActivity)getActivity()).getDungeon();
        hero = ((GameActivity)getActivity()).getHero();
        monster = dungeon.getCurrentRoom().getMonster();

        monsterImage = v.findViewById(R.id.monster_image);
        monsterImage.setImageResource(R.drawable.nake_mole_bat);
        heroImage = v.findViewById(R.id.hero_image);
        heroImage.setImageResource(R.drawable.warrior_back);
        monsterName = v.findViewById(R.id.monster_name);
        monsterName.setText(monster.getName());

        heroHealthAmount = v.findViewById(R.id.health_amount);

        monsterHealth = v.findViewById(R.id.monster_health);
        monsterHealth.setMax(monster.getHealth());

        heroHealth = v.findViewById(R.id.hero_health);
        heroHealth.setMax(hero.getMaxHealth());
        updateHealthBars();

        return v;
    }

    private void updateHealthBars() {
        monsterHealth.setProgress(monster.getHealth());
        heroHealth.setProgress(hero.getHealth());
        heroHealthAmount.setText(Integer.toString(hero.getHealth()));
    }

    public void heroAttacks() {
        hero.attack(monster);
        if (monster.getHealth() > 0) {
            monster.attack(hero);
            ((GameActivity)getActivity()).addMonsterMessage(monster.getName() + " deals " + monster.getAttackPwr() + " damage");

        }
        else {
            dungeon.getCurrentRoom().monsterDefeated();
            ((GameActivity) getActivity()).monsterDefeated();
        }

        //TODO: make game over screen if hero dies
        updateHealthBars();
    }

    public void heroDefends() {

    }

}
