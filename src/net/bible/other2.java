package net.bible;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: sliversniper
 * Date: 4/17/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class other2 extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other2);
        m =new main();
        Log.d(m.txt,m.txt);
//        Log.d("fuckYOU!","fuckyouagain");
//        Log.d("why it wasn't working","shit!");
//        m.createNotification("HELLO");
//        Toast t = Toast.makeText(this,"what the fuck",Toast.LENGTH_SHORT);
//        t.show();
        TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec1=tabHost.newTabSpec("Tab 1");
        Intent in1 = new Intent(this,other.class);
        spec1.setContent(in1);
        spec1.setIndicator("Tab 1");

        TabHost.TabSpec spec2=tabHost.newTabSpec("Tab 2");
        spec2.setIndicator("Tab 2");
        spec2.setContent(R.id.tab2);

        TabHost.TabSpec spec3=tabHost.newTabSpec("Tab 3");
        spec3.setIndicator("Tab 3");
        spec3.setContent(R.id.tab3);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
    }
    public main m;
}
