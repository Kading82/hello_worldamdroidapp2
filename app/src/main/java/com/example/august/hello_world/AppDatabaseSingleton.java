package com.example.august.hello_world;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseSingleton {
    private static settingsDb INSTANCE;

    public static settingsDb getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), settingsDb.class, "user-database")
                            .build();
        }
        return INSTANCE;
    }
}
