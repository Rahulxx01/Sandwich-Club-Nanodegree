package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    static Sandwich sandwich = null;

    public static Sandwich parseSandwichJson(String json) {

        List<String> alsoKnownAsArrayList = new ArrayList<String>();
        List<String> ingredientsArrayList = new ArrayList<String>();

        try {

            JSONObject root = new JSONObject(json);
            JSONObject name = root.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsArrayList.add(alsoKnownAsArray.getString(i));
            }
            String placeOfOrigin = root.getString("placeOfOrigin");
            String description = root.getString("description");
            String imageUrl = root.getString("image");

            JSONArray ingredientsArray = root.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredientsArrayList.add(ingredientsArray.getString(i));
            }
            sandwich = new Sandwich(mainName, alsoKnownAsArrayList, placeOfOrigin, description, imageUrl, ingredientsArrayList);
            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return null;

    }


}

