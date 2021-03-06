package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory.IDungeon;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.Hero;
import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.IWeapon;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        IDungeon dungeon = ((GameActivity)getActivity()).getDungeon();
        Hero hero = ((GameActivity)getActivity()).getHero();

        String message = "Nothing found.";
        Integer res = -1;
        Object item = dungeon.getItemInCurrentRoom();
        if (item != null) {
            if (item instanceof IItem) {
                IItem i = (IItem) item;
                message = "You found an item!\n" + i.getName();
                res = i.getResource();
                hero.addItem(i);
            }
            if (item instanceof IWeapon) {
                IWeapon i = (IWeapon) item;
                message = "You found a weapon!\n" + i.getName();
                res = i.getResource();
                hero.addWeapon(i);
            }
        }

        TextView searchResult = v.findViewById(R.id.search_result);
        searchResult.setText(message);

        if (res != -1) {
            ImageView foundItem = v.findViewById(R.id.found_item);
            foundItem.setImageResource(res);
        }

        Button okButton = v.findViewById(R.id.b_search_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GameActivity)getActivity()).removeSearch();
            }
        });

        return v;
    }

}
