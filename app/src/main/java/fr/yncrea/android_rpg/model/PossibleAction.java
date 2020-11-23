package fr.yncrea.android_rpg.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "possibleaction")
public class PossibleAction {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "target")
    public Integer targetEvent;

}