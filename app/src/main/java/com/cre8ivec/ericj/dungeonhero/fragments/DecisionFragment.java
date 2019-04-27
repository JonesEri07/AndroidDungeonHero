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
    private Hero hero;

    private TextView roomName;
    private Button north;
    private Button east;
    private Button south;
    private Button west;
    private Button up;
    private Button down;

    private Button info;
    private Button drawErase;
    private Button search;
    private Button useItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_decision, container, false);

        dungeon = ((GameActivity)getActivity()).getDungeon();

        roomName = v.findViewById(R.id.room_name);
        setRoomName(dungeon.getCurrentRoom().getName());

        ((GameActivity)getActivity()).setUpDrawPad();

        north = v.findViewById(R.id.b_north);
        east = v.findViewById(R.id.b_east);
        south = v.findViewById(R.id.b_south);
        west = v.findViewById(R.id.b_west);
        up = v.findViewById(R.id.b_up);
        down = v.findViewById(R.id.b_down);

        handleNorth();
        handleEast();
        handleSouth();
        handleWest();
        handleUp();
        handleDown();


        info = v.findViewById(R.id.b_hero_info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GameActivity)getActivity()).infoPushed();
            }
        });

        drawErase = v.findViewById(R.id.b_draw_erase);
        drawErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawErase.getText().equals("Erase")) {
                    ((GameActivity)getActivity()).setToErase();
                    drawErase.setText(R.string.draw);
                }
                else {
                    ((GameActivity)getActivity()).setToDraw();
                    drawErase.setText(R.string.erase);
                }
            }
        });

        drawErase.setVisibility(View.GONE);

        search = v.findViewById(R.id.b_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSearch();
            }
        });

        useItem = v.findViewById(R.id.b_use_item);
        useItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GameActivity)getActivity()).useItemPushed();
            }
        });

        enableButtons();

        return v;
    }

    private void handleNorth() {
        north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check door first
                if (dungeon.getCurrentRoom().canOpenNorth()) {
                    dungeon.goNorth();
                    roomEvents();
                }
                else
                    printWhyCantOpen(dungeon.getCurrentRoom().getNorthDoor());
            }
        });
    }

    private void handleEast() {
        east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dungeon.getCurrentRoom().canOpenEast()) {
                    dungeon.goEast();
                    roomEvents();
                }
                else
                    printWhyCantOpen(dungeon.getCurrentRoom().getEastDoor());
            }
        });
    }

    private void handleSouth() {
        south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dungeon.getCurrentRoom().canOpenSouth()) {
                    dungeon.goSouth();
                    roomEvents();
                }
                else
                    printWhyCantOpen(dungeon.getCurrentRoom().getSouthDoor());
            }
        });
    }

    private void handleWest() {
        west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dungeon.getCurrentRoom().canOpenWest()) {
                    dungeon.goWest();
                    roomEvents();
                }
                else
                    printWhyCantOpen(dungeon.getCurrentRoom().getWestDoor());
            }
        });
    }

    private void handleUp() {
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dungeon.getCurrentRoom().canOpenUp()) {
                    dungeon.goUp();
                    roomEvents();
                }
                else
                    printWhyCantOpen(dungeon.getCurrentRoom().getUpDoor());
            }
        });
    }

    private void handleDown() {
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dungeon.getCurrentRoom().canOpenDown()) {
                    dungeon.goDown();
                    roomEvents();
                }
                else
                    printWhyCantOpen(dungeon.getCurrentRoom().getDownDoor());
            }
        });
    }

    private void handleSearch() {
        disableButtons();
        ((GameActivity)getActivity()).searchPushed();
    }

    public void handleReloadDecision() {
        enableButtons();
        info.setEnabled(true);
        search.setEnabled(true);
        useItem.setEnabled(true);
        drawErase.setEnabled(true);
    }

    private void roomEvents() {
        // Check if Monster , or trap, or
        handleIfMonster();

        enableButtons();
        setRoomName(dungeon.getCurrentRoom().getName());
    }

    private void handleIfMonster() {
        IMonster mon;
    }

    private void setRoomName(String name) { roomName.setText(name); }

    private void enableButtons() {
        IRoom current = dungeon.getCurrentRoom();
        if (current.hasDoorToNorth())
            north.setEnabled(true);
        else
            north.setEnabled(false);

        if (current.hasDoorToEast())
            east.setEnabled(true);
        else
            east.setEnabled(false);

        if (current.hasDoorToSouth())
            south.setEnabled(true);
        else
            south.setEnabled(false);

        if (current.hasDoorToWest())
            west.setEnabled(true);
        else
            west.setEnabled(false);

        if (!dungeon.getUpDownEnabled()) {
            up.setVisibility(View.GONE);
            down.setVisibility(View.GONE);
        }
        else {
            if (current.hasDoorToUp())
                up.setEnabled(true);
            else
                up.setEnabled(false);

            if (current.hasDoorToDown())
                down.setEnabled(true);
            else
                down.setEnabled(false);
        }
    }

    public void disableButtons() {
        info.setEnabled(false);
        drawErase.setEnabled(false);
        up.setEnabled(false);
        down.setEnabled(false);
        north.setEnabled(false);
        east.setEnabled(false);
        south.setEnabled(false);
        west.setEnabled(false);
        search.setEnabled(false);
        useItem.setEnabled(false);
    }

    private void printWhyCantOpen(IDoor door) {
        String message = "";
        if (door instanceof LockedDoor) {
            LockedDoor uDoor = (LockedDoor) door;
            message = "Door is locked.\nUse " + uDoor.getItemNeeded().getName() + " to unlock the door.";
        }

        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

}
