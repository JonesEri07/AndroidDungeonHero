package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cre8ivec.ericj.dungeonhero.GameActivity;
import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.utility.Heros.IHero;
import com.cre8ivec.ericj.utility.Items.IItem;

import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsViewFragment extends Fragment {


    public ItemsViewFragment() {
        // Required empty public constructor
    }

    private IHero hero;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items_view, container, false);

        hero = ((GameActivity)getActivity()).getHero();

        recyclerView = v.findViewById(R.id.item_recycler_view);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(hero.getItems());
        recyclerView.setAdapter(mAdapter);

        Button goBack = v.findViewById(R.id.b_search_return);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GameActivity)getActivity()).removeItemsView();
            }
        });

        return v;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Map<IItem, Integer> mDataset;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public TextView textView;
            public View layout;
            public MyViewHolder(View v) {
                super(v);
                layout = v;
                textView = (TextView) v.findViewById(R.id.itemName);
                imageView = (ImageView) v.findViewById(R.id.itemImage);
            }
        }

        public MyAdapter(Map<IItem, Integer> dataSet) {
            mDataset = dataSet;
        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.item_view, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //IItem[] keys = (IItem[]) mDataset.keySet().toArray();
            holder.textView.setText("test");
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }



//    String mDrawableName = "myimageName";
//    int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
//    imgView.setImageResource(resID);

}
