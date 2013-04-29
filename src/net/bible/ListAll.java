package net.bible;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created with IntelliJ IDEA.
 * User: sliversniper
 * Date: 4/18/13
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class ListAll extends ListActivity {
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list, storer.str_unarrayed));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        }
    }

