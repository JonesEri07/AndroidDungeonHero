package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cre8ivec.ericj.dungeonhero.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsViewFragment extends Fragment {


    public ItemsViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items_view, container, false);
    }

//    String mDrawableName = "myimageName";
//    int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
//    imgView.setImageResource(resID);

}
