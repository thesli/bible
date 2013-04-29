package net.bible;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import net.bible.R;

/**
 * Created with IntelliJ IDEA.
 * User: sliversniper
 * Date: 4/22/13
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class favlist2 extends Activity {
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.favlist2);
//        MyUtility.addFavoriteItem(this,"fuckYOu?");
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());
//        alertDialogBuilder.setTitle("deletetheStuff")
//                .setMessage("Click Yes to Delete")
//                .setCancelable(false)
//                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),"Yes Clicked",Toast.LENGTH_LONG);
//                    }
//                })
//                .setNegativeButton("No",new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
        Context context =this;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Your Title");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        favlist2.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
