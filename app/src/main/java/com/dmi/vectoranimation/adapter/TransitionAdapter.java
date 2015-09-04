package com.dmi.vectoranimation.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.dmi.vectoranimation.R;

import java.util.ArrayList;
import java.util.List;

public class TransitionAdapter extends RecyclerView.Adapter<TransitionAdapter.VerticalItemHolder> {

    private ArrayList<TransitionItem> mItems;

    private AdapterView.OnItemClickListener mOnItemClickListener;

    public TransitionAdapter() {
        mItems = new ArrayList<TransitionItem>();
    }

    /*
    * Inserting a new item at the head of the list. This uses a specialized
    * RecyclerView method, notifyItemInserted(), to trigger any enabled item
    * animations in addition to updating the view.
    */
    public void addItems(List<TransitionItem> items) {
       if(items!=null){
           mItems.addAll(items);
           notifyDataSetChanged();
       }


    }

    /*
     * Inserting a new item at the head of the list. This uses a specialized
     * RecyclerView method, notifyItemRemoved(), to trigger any enabled item
     * animations in addition to updating the view.
     */
    public void removeItem(int position) {
        if (position >= mItems.size()) return;

        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public VerticalItemHolder onCreateViewHolder(ViewGroup container, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View root = inflater.inflate(R.layout.view_match_item, container, false);

        return new VerticalItemHolder(root, this);
    }

    @Override
    public void onBindViewHolder(VerticalItemHolder itemHolder, int position) {
        TransitionItem item = mItems.get(position);
        itemHolder.setTitle(String.valueOf(item.title));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private void onItemHolderClick(VerticalItemHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }

    public static class TransitionItem {
        public String title;


        public TransitionItem(String homeTeam) {
            this.title = homeTeam;
        }
    }

    public static class VerticalItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitle;

        private TransitionAdapter mAdapter;

        public VerticalItemHolder(View itemView, TransitionAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
            mTitle = (TextView) itemView.findViewById(R.id.view_item_title);

        }

        @Override
        public void onClick(View v) {
            mAdapter.onItemHolderClick(this);
        }

        public void setTitle(CharSequence homeScore) {
            mTitle.setText(homeScore);
        }


    }
}