package com.example.august.hello_world;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileContentFragment extends Fragment {

    private DatabaseReference databaseReference;
    private DatabaseReference logReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    public TileContentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("matches");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();


        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // Set padding for Tiles (not needed for Cards/Lists!)
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        Context context;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.mathces_tab, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.imageView4);
            name = (TextView) itemView.findViewById(R.id.textViewmatches1);
                Button btn = (Button) itemView.findViewById(R.id.action_button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "You liked " + name.toString() + "!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 6;


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("matches");

            myRef.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    //you have data now traverse
                    for (DataSnapshot child: dataSnapshot.getChildren()){
                        //your data may come up in map so handle here
                        HashMap<String,GetData> hashMap =  (HashMap<String,GetData>)child.getValue();
                        //if everything is okay then just iterate over the map and create a list
                        List<GetData> matcheslist = new ArrayList<>();
                        for (HashMap.Entry<String,GetData> modelEntry:hashMap.entrySet()){
                            matcheslist.add(modelEntry.getValue());
                        }
                        holder.picture.setImageDrawable(matcheslist[position % matcheslist.hashCode()]);
                        holder.name.setText(matcheslist.getClass(GetData).getName());
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //for some reason data did't show up
                }
            });

            holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            holder.name.setText(mPlaces[position % mPlaces.length]);
        }


        @Override
        public int getItemCount() {
            return LENGTH;
        }

    }
}