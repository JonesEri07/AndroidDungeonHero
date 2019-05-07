package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.utility.DungeonFactory.IDungeon;
import com.cre8ivec.ericj.utility.Heros.Hero;
import com.cre8ivec.ericj.utility.Monsters.IMonster;
import com.cre8ivec.ericj.utility.Rooms.Doors.IDoor;
import com.cre8ivec.ericj.utility.Rooms.Doors.LockedDoor;
import com.cre8ivec.ericj.utility.Rooms.IRoom;

/**
 * A simple {@link Fragment} subclass.
 */
public class DecisionFragment extends Fragment {


    public DecisionFragment() {
        // Required empty public constructor
    }

    private IDungeon dungeon;

    private TextView roomName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_decision, container, false);


        dungeon = ((GameActivity) getActivity()).getDungeon();

        roomName = v.findViewById(R.id.room_name);

        ((GameActivity) getActivity()).setUpDrawPad();
        ((GameActivity) getActivity()).putMoveButtonsView();

        return v;
    }

    public void setRoomName() {
        roomName.setText(dungeon.getCurrentRoom().getName());
    }
}
