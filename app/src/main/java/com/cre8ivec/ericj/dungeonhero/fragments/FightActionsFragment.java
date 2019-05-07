package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.utility.DungeonFactory.IDungeon;
import com.cre8ivec.ericj.utility.Heros.IHero;
import com.cre8ivec.ericj.utility.Monsters.IMonster;

/**
 * A simple {@link Fragment} subclass.
 */
public class FightActionsFragment extends Fragment {


    public FightActionsFragment() {
        // Required empty public constructor
    }

    private IDungeon dungeon;
    private IHero hero;
    private IMonster monster;

    private Button attack;
    private Button defend;
    private Button useItem;
    private Button flee;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fight_actions, container, false);

        dungeon = ((GameActivity)getActivity()).getDungeon();
        hero = ((GameActivity)getActivity()).getHero();
        monster = dungeon.getCurrentRoom().getMonster();

        attack = v.findViewById(R.id.attack);
        defend = v.findViewById(R.id.defend);
        useItem = v.findViewById(R.id.use_an_item);
        flee = v.findViewById(R.id.flee);

        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAttack();
            }
        });

        defend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDefend();
            }
        });

        useItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleUseItem();
            }
        });

        flee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFlee();
            }
        });

        return v;
    }

    private void handleAttack() {

    }

    private void handleDefend() {

    }

    private void handleUseItem() {

    }

    private void handleFlee() {

    }

}
