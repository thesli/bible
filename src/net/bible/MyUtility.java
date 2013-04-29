package net.bible;
import android.app.Activity;
import android.content.SharedPreferences;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyUtility {

    public static boolean addFavoriteItem(Activity activity,String favoriteItem){
        //Get previous favorite items
        String favoriteList = getStringFromPreferences(activity,null,"favorites");
        // Append new Favorite item
        if(favoriteList!=null){
            favoriteList = favoriteList+","+favoriteItem;
        }else{
            favoriteList = favoriteItem;
        }
        // Save in Shared Preferences
        return putStringInPreferences(activity,favoriteList,"favorites");
    }
    public static String[] getFavoriteList(Activity activity){
        String favoriteList = getStringFromPreferences(activity,null,"favorites");
        return convertStringToArray(favoriteList);
    }
    private static boolean putStringInPreferences(Activity activity,String nick,String key){
        SharedPreferences sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, nick);
        editor.commit();
        return true;
    }
    private static String getStringFromPreferences(Activity activity,String defaultValue,String key){
        SharedPreferences sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE);
        String temp = sharedPreferences.getString(key, defaultValue);
        return temp;
    }

    private static String[] convertStringToArray(String str){
        String[] arr = str.split(",");
        return arr;
    }

    public static void deleteAllEntries(Activity activity){
        SharedPreferences sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("favorites");
        editor.commit();
    }

    private static List<String> convertArrayToArrayList(String[] arr){
        List<String> arrlist = new ArrayList<String>();
        arrlist = Arrays.asList(arr);
        return arrlist;
    }

    private static String[] convertArrayListToArray(ArrayList arrlist){
        return (String[]) arrlist.toArray();
    }

    private static List<String> removeListItem(ArrayList arrlist,String s){
        arrlist.remove(s);
        return arrlist;
    }

    public static String[] removeOneItemInArray(String[] arr,String s){
        List<String> arrlist = convertArrayToArrayList(arr);
        arrlist.remove(s);
        return convertArrayListToArray((ArrayList) arrlist);
    }
}