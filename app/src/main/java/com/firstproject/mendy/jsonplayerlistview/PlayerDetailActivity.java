package com.firstproject.mendy.jsonplayerlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlayerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        TextView[] textViews = new TextView[8];
        textViews[0] = (TextView) findViewById(R.id.activity_player_detail_team);
        textViews[1] = (TextView) findViewById(R.id.activity_player_detail_number);
        textViews[2] = (TextView) findViewById(R.id.activity_player_detail_position);
        textViews[3] = (TextView) findViewById(R.id.activity_player_detail_name);
        textViews[4] = (TextView) findViewById(R.id.activity_player_detail_club);
        textViews[5] = (TextView) findViewById(R.id.activity_player_detail_club_country);
        textViews[6] = (TextView) findViewById(R.id.activity_player_detail_date_of_birth);
        textViews[7] = (TextView) findViewById(R.id.activity_player_detail_is_captain);

        Intent intent = getIntent();

        Player player = (Player) intent.getSerializableExtra(MainActivity.PLAYER);

        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setText(player.getElementByI(i));
        }

    }
}
