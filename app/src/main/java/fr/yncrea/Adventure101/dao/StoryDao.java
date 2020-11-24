package fr.yncrea.Adventure101.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.yncrea.Adventure101.model.PossibleAction;

@Dao
public interface StoryDao {
    @Query("SELECT * FROM possibleaction")
    List<PossibleAction> getAll();

    @Insert
    void insert(PossibleAction possibilities);

    @Delete
    void delete(PossibleAction actionne);
}
