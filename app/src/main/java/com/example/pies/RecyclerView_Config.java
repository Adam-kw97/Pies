package com.example.pies;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContex;
    private PointsAdapter mPointAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Point> points,List<String> keys){
        mContex=context;
        mPointAdapter=new PointsAdapter(points,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPointAdapter);


    }


    class PointItemView extends RecyclerView.ViewHolder {
        private TextView XTitle;
        private TextView YTitle;

        private String key;
        public PointItemView(ViewGroup parent){
            super(LayoutInflater.from(mContex).inflate(R.layout.points_list_item,parent,false));

            XTitle=(TextView) itemView.findViewById(R.id.X_txtview);
            YTitle=(TextView) itemView.findViewById(R.id.Y_txtview);
        }
        public void bind(Point point, String key){
            XTitle.setText(String.format("%.5f", point.getX()));
            YTitle.setText(String.format("%.5f", point.getY()));
            this.key=key;

        }

    }

    class PointsAdapter extends RecyclerView.Adapter<PointItemView>{
        private List<Point> mPointList;
        private List<String> mKeys;

        public PointsAdapter(List<Point> mPointList, List<String> mKeys) {
            this.mPointList = mPointList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public PointItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PointItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PointItemView holder, int position) {
            holder.bind(mPointList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mPointList.size();
        }
    }




}
