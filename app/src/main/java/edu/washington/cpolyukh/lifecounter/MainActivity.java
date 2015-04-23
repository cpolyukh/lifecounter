package edu.washington.cpolyukh.lifecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView p1_total;
    private Button p1_plus1;
    private Button p1_minus1;
    private Button p1_plus5;
    private Button p1_minus5;

    private TextView p2_total;
    private Button p2_plus1;
    private Button p2_minus1;
    private Button p2_plus5;
    private Button p2_minus5;

    private TextView p3_total;
    private Button p3_plus1;
    private Button p3_minus1;
    private Button p3_plus5;
    private Button p3_minus5;

    private TextView p4_total;
    private Button p4_plus1;
    private Button p4_minus1;
    private Button p4_plus5;
    private Button p4_minus5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1_total = (TextView) findViewById(R.id.p1_total);
        p1_plus1 = (Button) findViewById(R.id.p1_plus1);
        p1_minus1 = (Button) findViewById(R.id.p1_minus1);
        p1_plus5 = (Button) findViewById(R.id.p1_plus5);
        p1_minus5 = (Button) findViewById(R.id.p1_minus5);

        p2_total = (TextView) findViewById(R.id.p2_total);
        p2_plus1 = (Button) findViewById(R.id.p2_plus1);
        p2_minus1 = (Button) findViewById(R.id.p2_minus1);
        p2_plus5 = (Button) findViewById(R.id.p2_plus5);
        p2_minus5 = (Button) findViewById(R.id.p2_minus5);

        p3_total = (TextView) findViewById(R.id.p3_total);
        p3_plus1 = (Button) findViewById(R.id.p3_plus1);
        p3_minus1 = (Button) findViewById(R.id.p3_minus1);
        p3_plus5 = (Button) findViewById(R.id.p3_plus5);
        p3_minus5 = (Button) findViewById(R.id.p3_minus5);

        p4_total = (TextView) findViewById(R.id.p4_total);
        p4_plus1 = (Button) findViewById(R.id.p4_plus1);
        p4_minus1 = (Button) findViewById(R.id.p4_minus1);
        p4_plus5 = (Button) findViewById(R.id.p4_plus5);
        p4_minus5 = (Button) findViewById(R.id.p4_minus5);

        setAllPlayerListeners(p1_total, p1_plus1, p1_minus1, p1_plus5, p1_minus5, 1);
        setAllPlayerListeners(p2_total, p2_plus1, p2_minus1, p2_plus5, p2_minus5, 2);
        setAllPlayerListeners(p3_total, p3_plus1, p3_minus1, p3_plus5, p3_minus5, 3);
        setAllPlayerListeners(p4_total, p4_plus1, p4_minus1, p4_plus5, p4_minus5, 4);
    }

    private void setAllPlayerListeners(TextView player_total, Button player_plus1, Button player_minus1,
                                       Button player_plus5, Button player_minus5, int player) {
        setPlayerListener(player_total, player_plus1, 1, player);
        setPlayerListener(player_total, player_minus1, -1, player);
        setPlayerListener(player_total, player_plus5, 5, player);
        setPlayerListener(player_total, player_minus5, -5, player);
    }

    private void setPlayerListener(final TextView current_text, Button current_button,
                                   final int change, final int player) {
        current_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int p1_current = Integer.parseInt(current_text.getText().toString());
                current_text.setText(updateScore(p1_current, change, player));
            }
        });
    }

    private String updateScore(int current, int change, int player) {
        int newScore  = current + change;
        if (newScore <= 0) {
            TextView loser = (TextView) findViewById(R.id.loser);
            loser.setText("Player " + player + " LOSES!");
            newScore = 0;
        }
        return String.valueOf(newScore);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
