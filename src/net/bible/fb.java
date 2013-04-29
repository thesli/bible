package net.bible;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: sliversniper
 * Date: 4/18/13
 * Time: 12:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class fb extends Activity {
    String line,verse,txt;
    TextView tvline,tvverse;
    Button copy,share;
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.fb);
        line = storer.str[main.current][0];
        verse = storer.str[main.current][1];
        txt = line+verse;
        tvline = (TextView)findViewById(R.id.Line);
        tvverse = (TextView)findViewById(R.id.verse);
        tvline.setText(line);
        tvverse.setText(verse);
        copy = (Button)findViewById(R.id.copy);
        share = (Button)findViewById(R.id.share);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text",txt);
                clipboard.setPrimaryClip(clip);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.facebook.com/sharer.php?u=http://bible.is";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
