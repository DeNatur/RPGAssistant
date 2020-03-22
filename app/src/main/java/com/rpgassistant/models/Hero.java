package com.rpgassistant.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.rpgassistant.R;
import com.rpgassistant.utils.Converters;

import java.util.ConcurrentModificationException;
import java.util.List;

/*
    Type: 0 Dungeons And Dragons
        Dnd classes:
            0: Barbarian
            1: Bard
            2: Cleric
            3: Druid
            4: Fighter
            5: Monk
            6: Paladin
            7: Ranger
            8: Rogue
            9: Sorcerer
            10: Warlock
            11: Wizard
            12: Bloodhunter
            13+: Custom
*/
@Entity(tableName = "hero_table")
public class Hero {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @TypeConverters(Converters.class)
    private int[] heroClasses;
    private Integer type;
    private String statsJson;
    @TypeConverters(Converters.class)
    private int[] lvls;
    private int iconResource;

    public Hero(String name, int[] heroClasses, Integer type, String statsJson, int[] lvls) {
        this.name = name;
        this.heroClasses = heroClasses;
        this.lvls = lvls;
        this.type = type;
        this.statsJson = statsJson;
        switch (type){
            default:
                setDndResourceIcon();
                break;
        }
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public Integer getType() { return type; }

    public String getStatsJson() { return statsJson; }

    public String getName() {
        return name;
    }

    public int[] getHeroClasses() { return heroClasses; }

    public int[] getLvls() {
        return lvls;
    }

    public int getIconResource() {
        return iconResource;
    }
    public String getProperHeroClass(int position){
        switch (type){
            default:
                return getDnDClass(position);
        }
    }
    private String getDnDClass(int position){
        switch (heroClasses[position]){
            case 0:
                return "Barbarian";
            case 1:
                return "Bard";
            case 2:
                return "Cleric";
            case 3:
                return "Druid";
            case 4:
                return "Fighter";
            case 5:
                return "Monk";
            case 6:
                return "Paladin";
            case 7:
                return "Ranger";
            case 8:
                return "Rogue";
            case 9:
                return "Sorcerer";
            case 10:
                return "Warlock";
            case 11:
                return "Wizard";
            case 12:
                return "Bloodhunter";
            case 13:
                return "Custoom";
        }
        return "";
    }
    private void setDndResourceIcon(){
        switch (heroClasses[0]){
            case 0:
                iconResource = R.drawable.barbarian;
                break;
            case 1:
                iconResource = R.drawable.bard;
                break;
            case 2:
                iconResource = R.drawable.cleric;
                break;
            case 3:
                iconResource = R.drawable.druid;
                break;
            case 4:
                iconResource = R.drawable.fighter;
                break;
            case 5:
                iconResource = R.drawable.monk;
                break;
            case 6:
                iconResource = R.drawable.paladin;
                break;
            case 7:
                iconResource = R.drawable.ranger;
                break;
            case 8:
                iconResource = R.drawable.rogue;
                break;
            case 9:
                iconResource = R.drawable.sorcerer;
                break;
            case 10:
                iconResource = R.drawable.warlock;
                break;
            case 11:
                iconResource = R.drawable.wizard;
                break;
            case 12:
                iconResource = R.drawable.barbarian;
                break;
            case 13:
                iconResource = R.drawable.barbarian;
                break;
        }
    }
}

