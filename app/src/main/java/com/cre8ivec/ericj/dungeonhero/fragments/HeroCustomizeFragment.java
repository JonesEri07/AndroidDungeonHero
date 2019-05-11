package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.IWeapon;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeroCustomizeFragment extends Fragment {


    public HeroCustomizeFragment() {
        // Required empty public constructor
    }

    private IHero hero;

    private ProgressBar heroHealth;
    private TextView healthAmount;

    private ImageButton weapon;
    private TextView attackPwrAmount;
    private TextView elementType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hero_customize, container, false);

        hero = ((GameActivity)getActivity()).getHero();

        heroHealth = v.findViewById(R.id.hero_health2);
        heroHealth.setMax(hero.getMaxHealth());

        healthAmount = v.findViewById(R.id.info_health);

        setHeroHealth();

        weapon = v.findViewById(R.id.imageButton);
        weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleWeaponButton();
            }
        });

        attackPwrAmount = v.findViewById(R.id.info_attackPwr_amount);

        elementType = v.findViewById(R.id.info_element);

        setEquipedWeapon();

        Button returnButton = v.findViewById(R.id.info_return_b);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GameActivity)getActivity()).closeInfo();
            }
        });

        return v;
    }

    public void setHeroHealth() {
        heroHealth.setProgress(hero.getHealth());
        String health = Integer.toString(hero.getHealth()) + "/" + Integer.toString(hero.getMaxHealth());
        healthAmount.setText(health);
    }

    public void setEquipedWeapon() {
        IWeapon equiped = hero.getEquipedWeapon();
        weapon.setImageResource(equiped.getResource());
        attackPwrAmount.setText(Integer.toString(equiped.getAttackPwr()));
        elementType.setText(equiped.getElementType().toString());
    }

    public void handleWeaponButton() {
        ((GameActivity)getActivity()).toggleWeaponsView();
    }



}
