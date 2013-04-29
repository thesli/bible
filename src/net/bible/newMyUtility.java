package net.bible;

import android.app.Activity;
import android.content.*;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sliversniper
 * Date: 4/18/13
 * Time: 12:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class newMyUtility extends Activity {
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.fb);
    }
    public boolean addFavoriteItem(String favoriteItem){
        //Get previous favorite items
        String favoriteList = getStringFromPreferences(null,"favorites");
        // Append new Favorite item
        if(favoriteList!=null){
            favoriteList = favoriteList+","+favoriteItem;
        }else{
            favoriteList = favoriteItem;
        }
        // Save in Shared Preferences
        return putStringInPreferences(favoriteList,"favorites");
    }
    public String[] getFavoriteList(Activity activity){
        String favoriteList = getStringFromPreferences(null,"favorites");
        return convertStringToArray(favoriteList);
    }
    Context c = getApplicationContext();
    public boolean putStringInPreferences(String nick, String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, nick);
        editor.commit();
        return true;
    }

    private String getStringFromPreferences(String defaultValue,String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        String temp = sharedPreferences.getString(key, defaultValue);
        return temp;
    }

    private static String[] convertStringToArray(String str){
        String[] arr = str.split(",");
        return arr;
    }

    public void deleteAllEntries(Activity activity){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
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