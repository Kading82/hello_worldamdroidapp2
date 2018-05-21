package com.example.august.hello_world;

import com.google.firebase.database.DataSnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Viewmodel {

    private Firebaseconnect dataconnect;
    private ArrayList<GetData> matches;

    public ArrayList<GetData> getMatches() {
        return matches;
    }

    public void getMatches(Consumer<ArrayList<GetData>> responseCallback) {
        dataconnect.getMatches(
                (DataSnapshot dataSnapshot) -> {
                    ArrayList<GetData> matches = new ArrayList<>();
                    for (DataSnapshot matchSnapshot : dataSnapshot.getChildren()) {
                        GetData match = matchSnapshot.getValue(GetData.class);
                        assert match != null;
                        matches.add(match);
                    }
                    responseCallback.accept(matches);
                },
                (databaseError -> System.out.println("Look what you've done "))
        );
    }

    public void clear() {
        dataconnect.clear();
    }

}
