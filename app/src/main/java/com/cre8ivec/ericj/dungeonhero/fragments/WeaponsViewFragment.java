package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.Fists;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.IWeapon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeaponsViewFragment extends Fragment {


    public WeaponsViewFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;

    private IHero hero;

    private ImageView weaponImage;
    private TextView weaponDescription;
    private Button equipButton;

    private IWeapon weaponToEquip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weapons_view, container, false);

        hero = ((GameActivity)getActivity()).getHero();

        weaponImage = v.findViewById(R.id.detailed_weawpon_image);
        weaponImage.setVisibility(View.GONE);

        weaponDescription = v.findViewById(R.id.weapon_description);
        weaponDescription.setVisibility(View.GONE);

        equipButton = v.findViewById(R.id.b_equip_weapon);
        equipButton.setVisibility(View.GONE);

        equipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleEquipButton();
            }
        });

        recyclerView = v.findViewById(R.id.weapon_recycler_view);

        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyWeaponAdapter(hero.getInventory());
        recyclerView.setAdapter(mAdapter);


        return v;
    }

    private void handleEquipButton() {
        if (weaponToEquip == hero.getEquipedWeapon()) {
            hero.equipeWeapon(new Fists());
            String equip = "Equip Weapon";
            equipButton.setText(equip);
        }
        else {
            hero.equipeWeapon(weaponToEquip);
            String unequip = "Unequip Weapon";
            equipButton.setText(unequip);

        }
        ((GameActivity)getActivity()).equipWeapon();

    }

    public class MyWeaponAdapter extends RecyclerView.Adapter<MyWeaponAdapter.MyWeaponViewHolder> {
        private ArrayList<IWeapon> mDataset;

        public class MyWeaponViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public ImageView imageView;
            public TextView textView;
            public View layout;
            public MyWeaponViewHolder(View v) {
                super(v);
                v.setOnClickListener(this);
                layout = v;
                imageView = (ImageView) v.findViewById(R.id.itemImage);
                textView = v.findViewById(R.id.item_count);
                textView.setVisibility(View.GONE);
            }

            @Override
            public void onClick(View view) {
                int pos = getPosition();
                weaponToEquip = mDataset.get(pos);
                weaponImage.setVisibility(View.VISIBLE);
                weaponDescription.setVisibility(View.VISIBLE);
                equipButton.setVisibility(View.VISIBLE);

                weaponImage.setImageResource(weaponToEquip.getResource());
                //weaponDescription.setText("Description");

                if (weaponToEquip == hero.getEquipedWeapon()) {
                    String unequip = "Unequip Weapon";
                    equipButton.setText(unequip);
                }


            }
        }

        public MyWeaponAdapter(ArrayList<IWeapon> dataSet) {
            mDataset = dataSet;
        }

        @Override
        public MyWeaponAdapter.MyWeaponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.item_view, parent, false);

            MyWeaponViewHolder vh = new MyWeaponViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyWeaponViewHolder holder, int position) {
            IWeapon weapon = mDataset.get(position);
            holder.imageView.setImageResource(weapon.getResource());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

}
