package com.cre8ivec.ericj.dungeonhero.fragments;


import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;
import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;

import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {


    public InfoFragment() {
        // Required empty public constructor
    }

    private IHero hero;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        hero = ((GameActivity)getActivity()).getHero();

        ImageView heroFace = v.findViewById(R.id.info_hero_image);

        heroFace.setImageResource(hero.getResource_front());

        recyclerView = v.findViewById(R.id.info_item_recycler_view);

        layoutManager = new GridLayoutManager(getContext(), 2, GridLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyInfoAdapter(hero.getItems());
        if (hero.getItems().size() > 0)
            recyclerView.setAdapter(mAdapter);
        else
            recyclerView.setVisibility(View.GONE);

        return v;
    }

    public class MyInfoAdapter extends RecyclerView.Adapter<MyInfoAdapter.MyInfoViewHolder> {
        private Map<IItem, Integer> mDataset;

        public class MyInfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public ImageView imageView;
            public TextView countTextView;
            public View layout;
            public MyInfoViewHolder(View v) {
                super(v);
                v.setOnClickListener(this);
                layout = v;
                countTextView = v.findViewById(R.id.item_count);
                imageView = v.findViewById(R.id.itemImage);
            }

            @Override
            public void onClick(View view) {
                int pos = getPosition();
                Object[] keys = mDataset.keySet().toArray();
                IItem item = (IItem) keys[pos];
                String use = item.isUsableOnHero();
                if (use != null) {
                    item.useOnHero(hero);
                    hero.useItem(item);
                    mAdapter = new MyInfoAdapter(hero.getItems());
                    recyclerView.setAdapter(mAdapter);
                    ((GameActivity)getActivity()).setHeroHealth();

                }

            }
        }

        public MyInfoAdapter(Map<IItem, Integer> dataSet) {
            mDataset = dataSet;
        }

        @Override
        public MyInfoAdapter.MyInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.item_view, parent, false);

            MyInfoAdapter.MyInfoViewHolder vh = new MyInfoAdapter.MyInfoViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyInfoAdapter.MyInfoViewHolder holder, int position) {
            Object[] keys =  mDataset.keySet().toArray();
            IItem item = (IItem) keys[position];
            holder.imageView.setImageResource(item.getResource());
            String count = Integer.toString(mDataset.get(item));
            holder.countTextView.setText(count);

            //holder.textView.setText(item.getName());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }



}
