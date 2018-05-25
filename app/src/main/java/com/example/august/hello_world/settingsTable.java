package com.example.august.hello_world;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "settingsTable")
public class settingsTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "dMrT")
    private String dMrT;

    @ColumnInfo(name = "max_distance")
    private int maxDistance;

    @ColumnInfo(name = "gender")
    private String gender;

    @ColumnInfo(name = "age_range")
    private String ageRange;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdMrT() {
        return dMrT;
    }

    public void setdMrT(String dMrT) {
        this.dMrT = dMrT;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getAccountSettings() {
        return accountSettings;
    }

    public void setAccountSettings(String accountSettings) {
        this.accountSettings = accountSettings;
    }

    @ColumnInfo(name = "account_settings")
    private String accountSettings;


}
