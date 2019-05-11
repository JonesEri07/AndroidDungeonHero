package com.cre8ivec.ericj.dungeonhero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;
import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;

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

    private ImageView detailedImageView;
    private TextView detailedTextView;
    private Button detailedUseButton;
    private Button useOnHeroButton;

    private IItem itemToUse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items_view, container, false);

        hero = ((GameActivity)getActivity()).getHero();

        detailedImageView = v.findViewById(R.id.detailed_image);
        detailedTextView = v.findViewById(R.id.item_description);
        detailedUseButton = v.findViewById(R.id.b_description_use);
        useOnHeroButton = v.findViewById(R.id.b_eat_item);

        detailedImageView.setVisibility(View.GONE);
        detailedTextView.setVisibility(View.GONE);
        detailedUseButton.setVisibility(View.GONE);
        useOnHeroButton.setVisibility(View.GONE);

        detailedUseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleUseItemButton();
            }
        });
        useOnHeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleEatItem();
            }
        });

        recyclerView = v.findViewById(R.id.item_recycler_view);

        layoutManager = new GridLayoutManager(getContext(), 2);
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

    //TODO: Maybe don't switch fragments, instead display toast if anything happened.

    public void handleUseItemButton() {
        ((GameActivity)getActivity()).attemptToUseItem(itemToUse);
    }

    public void handleEatItem() {
        ((GameActivity)getActivity()).eatItem(itemToUse);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Map<IItem, Integer> mDataset;

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public ImageView imageView;
            //public TextView textView;
            public TextView countTextView;
            public View layout;
            public MyViewHolder(View v) {
                super(v);
                v.setOnClickListener(this);
                layout = v;
                countTextView = v.findViewById(R.id.item_count);
                //textView = (TextView) v.findViewById(R.id.itemName);
                imageView = (ImageView) v.findViewById(R.id.itemImage);
            }

            @Override
            public void onClick(View view) {
                int pos = getPosition();
                Object[] keys = mDataset.keySet().toArray();
                itemToUse = (IItem) keys[pos];
                detailedImageView.setVisibility(View.VISIBLE);
                detailedTextView.setVisibility(View.VISIBLE);
                detailedUseButton.setVisibility(View.VISIBLE);
                detailedImageView.setImageResource(itemToUse.getResource());

                String use = itemToUse.isUsableOnHero();
                if (use != null) {
                    useOnHeroButton.setVisibility(View.VISIBLE);
                    useOnHeroButton.setText(use);
                }
                else {
                    useOnHeroButton.setVisibility(View.GONE);
                }

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
