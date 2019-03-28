package com.example.materialdesignapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    public List<DataModel> mDataModelList;
    public LayoutInflater inflater;

    public Context mContext;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case

        ImageView ivDelete, ivCopy, ivFlower;
        TextView tvTitle;
        private DataModel current;
        //public int position;

        public MyViewHolder(View v) {
            super(v);
            ivCopy = v.findViewById(R.id.img_copy);
            ivDelete = v.findViewById(R.id.img_delete);
            ivFlower = v.findViewById(R.id.img_thumb);
            tvTitle = v.findViewById(R.id.tvTitle);
        }

        public void setData(DataModel mDataModel, int position) {
            this.tvTitle.setText(mDataModel.getTitle());
            this.ivFlower.setImageResource(mDataModel.getImageID());
            //this.position = position;
            this.current = mDataModel;


        }

        public void setListener() {
            ivDelete.setOnClickListener(this);
            ivCopy.setOnClickListener(this);
            ivFlower.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img_delete:
                removeItem(getAdapterPosition());
                        break;
                case R.id.img_copy:
                    addItem(getAdapterPosition(), current);
                    break;

            }



        }

        private void addItem(int position, DataModel current) {
            mDataModelList.add(position, current);
            notifyItemInserted(position);
            notifyItemRangeChanged(position, mDataModelList.size());
        }

        private void removeItem(int position) {
            mDataModelList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mDataModelList.size());
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapter(Context context, List<DataModel> dataModelList) {
        mContext = context;
        mDataModelList = dataModelList;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    //Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        /*
        * View v = (View) inflater.inflate(R.layout.list_item, parent, false);
        * */

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    //Called by RecyclerView to display the data at the specified position. This method should update the contents of the itemView to reflect the item at the given position.
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        DataModel currentObj= mDataModelList.get(position);
        holder.setData(currentObj, position);

        holder.setListener();

    }

        // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataModelList.size();
    }
}
