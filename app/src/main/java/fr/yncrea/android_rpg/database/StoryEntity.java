package fr.yncrea.android_rpg.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import fr.yncrea.android_rpg.dao.StoryDao;
import fr.yncrea.android_rpg.model.PossibleAction;

@Database(entities = {PossibleAction.class}, version = 2)
public abstract class StoryEntity extends RoomDatabase {
    private static final String DB_NAME = "possibleaction";
    private static StoryEntity instance;

    public static synchronized StoryEntity getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), StoryEntity.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract StoryDao storyDao();
}
