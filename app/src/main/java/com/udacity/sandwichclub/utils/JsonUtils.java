package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String SANDWICH_NAME = "name";

    private static final String SANDWICH_MAIN_NAME = "mainName";

    private static final String SANDWICH_AKA = "aka";

    private static final String SANDWICH_ORIGIN = "origin";

    private static final String SANDWICH_DESCRIPTION = "description";

    private static final String SANDWICH_IMAGE = "image";

    private static final String SANDWICH_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        String sandwichJson = "{\"name\":{\"mainName\":\"Ham and cheese sandwich\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"\",\"description\":\"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\"ingredients\":[\"Sliced bread\",\"Cheese\",\"Ham\"]}";

        JSONObject Sandwich = new JSONObject(sandwichJson);

        JSONObject nameJson = Sandwich.getJSONObject(SANDWICH_NAME);

        String mainName = nameJson.getString(SANDWICH_MAIN_NAME);

        JSONArray akaJsonArray = nameJson.getJSONArray(SANDWICH_AKA);

        String origin = Sandwich.getString(SANDWICH_ORIGIN);

        String description = Sandwich.getString(SANDWICH_DESCRIPTION);

        String image = Sandwich.getString(SANDWICH_IMAGE);

        JSONArray ingredientsJsonArray = Sandwich.getJSONArray(SANDWICH_INGREDIENTS);

        List<String> akaList = new ArrayList<>(akaJsonArray.length());
        for (int i = 0; i < akaJsonArray.length(); i++) {
            akaList.add(akaJsonArray.getString(i));
        }

        List<String> ingredientsList = new ArrayList<>(ingredientsJsonArray.length());
        for (int i = 0; i < ingredientsJsonArray.length(); i++) {
            ingredientsList.add(ingredientsJsonArray.getString(i));
        }


        return new Sandwich(mainName, akaList, origin, description, image, ingredientsList);
    }
}
