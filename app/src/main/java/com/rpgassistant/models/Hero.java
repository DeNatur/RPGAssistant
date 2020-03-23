package com.rpgassistant.models;

import com.google.firebase.firestore.Exclude;
import com.rpgassistant.R;
import java.io.Serializable;
import java.util.HashMap;

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
public class Hero implements Serializable {
    private String uid;
    private String name;
    @Exclude
    private String id;
    private HashMap<String, Integer> heroClasses;
    private Integer type;
    private String statsJson;
    @Exclude
    private int iconResource;
     public Hero(){ }
    public Hero(String uid, String name, HashMap<String, Integer> heroClasses, Integer type, String statsJson) {
        this.uid = uid;
        this.name = name;
        this.heroClasses = heroClasses;
        this.type = type;
        this.statsJson = statsJson;
        switch (type){
            default:
                setIconResource(getDndResourceIcon(0));
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getHeroClasses() {
        return heroClasses;
    }

    public void setHeroClasses(HashMap<String, Integer> heroClasses) {
        this.heroClasses = heroClasses;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setStatsJson(String statsJson) {
        this.statsJson = statsJson;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public Integer getType() { return type; }

    public String getStatsJson() { return statsJson; }

    public String getName() {
        return name;
    }


    public int getIconResource() {
        switch (type){
            default:
                return getDndResourceIcon(0);
        }
    }
    public String getProperHeroClass(int position){
        switch (type){
            default:
                return getDnDClass(position);
        }
    }
    private String getDnDClass(int position){
        switch (Integer.parseInt(String.valueOf(heroClasses.keySet().toArray()[position]))){
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
    private int getDndResourceIcon(int position){
        int iconResource = 0;
        switch (Integer.parseInt(String.valueOf(heroClasses.keySet().toArray()[position]))){
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
        return iconResource;
    }
}

