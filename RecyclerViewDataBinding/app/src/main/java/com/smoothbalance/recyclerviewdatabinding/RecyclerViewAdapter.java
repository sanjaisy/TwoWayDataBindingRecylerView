package com.smoothbalance.recyclerviewdatabinding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smoothbalance.recyclerviewdatabinding.databinding.EachRowBinding;

import java.util.ArrayList;

/**
 * Created by San on 4/5/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context mContext;
    private ArrayList<User> mUsersList = null;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(Context mContext, ArrayList<User> mUsersList) {
        this.mContext = mContext;
        this.mUsersList = mUsersList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//       View view = inflater.inflate(R.layout.each_row,viewGroup,false);
        EachRowBinding binding = EachRowBinding.inflate(inflater);
        MyViewHolder myViewHolder = new MyViewHolder(binding);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        User user = mUsersList.get(i);
        myViewHolder.vBinding.setUser(user);
    }
    @Override
    public int getItemCount() {
        return mUsersList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        EachRowBinding vBinding;
        public MyViewHolder(EachRowBinding binding) {
            super(binding.getRoot());
            this.vBinding = binding;
        }
    }
}
