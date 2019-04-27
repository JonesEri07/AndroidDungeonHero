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

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmFragment extends Fragment {


    public ConfirmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_confirm, container, false);

        String message = ((GameActivity)getActivity()).getDecisionMessage();

        TextView decision = v.findViewById(R.id.decision_prompt);
        decision.setText(message);

        Button yes = v.findViewById(R.id.b_yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GameActivity)getActivity()).leaveGame();
            }
        });

        Button no = v.findViewById(R.id.b_no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GameActivity)getActivity()).keepPlaying();
            }
        });


        return v;
    }

}
