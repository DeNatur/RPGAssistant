package com.rpgassistant.utils;

import androidx.room.TypeConverter;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static String JSONArrayfromIntArray(int[] values) {
        JSONArray jsonArray = new JSONArray();
        for (int value : values) {
            jsonArray.put(value);
        }
        return jsonArray.toString();
    }

    @TypeConverter
    public static int[] JSONArrayToIntArray(String values) {
        try {
            JSONArray jsonArray = new JSONArray(values);
            int[] floatArray = new int[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                floatArray[i] = Integer.parseInt(jsonArray.getString(i));
            }
            return floatArray;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
