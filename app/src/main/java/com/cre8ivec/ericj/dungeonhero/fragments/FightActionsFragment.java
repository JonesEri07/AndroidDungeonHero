package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory.IDungeon;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

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

    private TextView fightMessage;
    private ImageButton wonFightButton;
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

        fightMessage = v.findViewById(R.id.fightMessage);
        setFightMessage("You encountered a " + monster.getName());

        wonFightButton = v.findViewById(R.id.won_fight_button);
        wonFightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleWonFightButton();
            }
        });
        wonFightButton.setVisibility(View.GONE);


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

    public void setFightMessage(String message) {
        fightMessage.setText(message);
    }

    public void addMonsterMessage(String message) {
        String prev = (String) fightMessage.getText();
        String newMessage = prev + "\n" + message;
        fightMessage.setText(newMessage);
    }

    public void showWonFightButton() {
        wonFightButton.setVisibility(View.VISIBLE);
    }

    private void handleWonFightButton() {
        ((GameActivity)getActivity()).removeAttackFragment();

    }
    private void handleAttack() {
        setFightMessage("Hero attacks with " + hero.getEquipedWeapon().getName() + " " + hero.getEquipedWeapon().getAttackPwr() + " damage.");
        ((GameActivity)getActivity()).heroAttacks();
    }

    private void handleDefend() {
        ((GameActivity)getActivity()).heroDefends();
    }

    private void handleUseItem() {

    }

    private void handleFlee() {

    }

}
