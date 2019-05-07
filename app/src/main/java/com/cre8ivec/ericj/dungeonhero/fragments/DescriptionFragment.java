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
import com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory.IDungeon;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {


    public DescriptionFragment() {
        // Required empty public constructor
    }

    private IDungeon dungeon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_description, container, false);
        dungeon = ((GameActivity)getActivity()).getDungeon();
        if (dungeon != null) {
            TextView title = v.findViewById(R.id.game_type);
            title.setText(dungeon.toString());
            TextView description = v.findViewById(R.id.game_description);
            description.setText(dungeon.description());
            Button enter = v.findViewById(R.id.enter_button);
            enter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((GameActivity)getActivity()).enterDungeon();
                }
            });
        }
        return v;
    }

    private void s() {

    }

}
