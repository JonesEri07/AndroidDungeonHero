package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.utility.DungeonFactory.IDungeon;
import com.cre8ivec.ericj.utility.Heros.Hero;
import com.cre8ivec.ericj.utility.Items.IItem;

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

        String message;
        IItem item = dungeon.getItemInCurrentRoom();
        if (item != null) {
            message = "You found a " + item.getName() + "!";
            hero.addItem(item);
        }
        else
            message = "Nothing found.";

        TextView searchResult = v.findViewById(R.id.search_result);
        searchResult.setText(message);

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
