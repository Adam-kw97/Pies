package com.example.pies;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class FireBaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<Point> points=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Point> points,List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();

    }

    public FireBaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference=mDatabase.getReference("coordinates");

    }

    public void readPoints(final DataStatus dataStatus){
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                points.clear();
                List<String> keys= new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Point point =keyNode.getValue(Point.class);
                    points.add(point);

                }
                dataStatus.DataIsLoaded(points,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
