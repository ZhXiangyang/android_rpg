package fr.yncrea.Adventure101.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "possibleaction")
public class PossibleAction {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "target")
    public Integer targetEvent;

}