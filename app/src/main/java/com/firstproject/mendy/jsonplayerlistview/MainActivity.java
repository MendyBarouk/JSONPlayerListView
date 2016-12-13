package com.firstproject.mendy.jsonplayerlistview;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String PLAYER = "com.firstproject.mendy.jsonplayerlistview.PLAYER";
    List<Player> players = new ArrayList<Player>();
    ListView mListView;
    PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        JSONArray jsonArray = loadJsonArrayFromRaw();
        addPlayersFromJsonArray(jsonArray);

        mListView = (ListView) findViewById(R.id.activity_main_list_view_player);
        mListView.setOnItemClickListener(this);

        playerAdapter = new PlayerAdapter(this, players);
        mListView.setAdapter(playerAdapter);

        Log.d("menahem", jsonArray.toString());


    }

    private void addPlayersFromJsonArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String team = jsonObject.getString("Team");
                int number = jsonObject.getInt("Number");
                String position = jsonObject.getString("Position");
                String fullName = jsonObject.getString("FullName");
                String club = jsonObject.getString("Club");
                String clubCountry = jsonObject.getString("ClubCountry");
                String dateOfBirth = jsonObject.getString("DateOfBirth");
                boolean isCaptain = jsonObject.getBoolean("IsCaptain");
                players.add(new Player(team,number,position,fullName,club,clubCountry,dateOfBirth,isCaptain));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    private JSONArray loadJsonArrayFromRaw(){
        try {
            return new JSONArray(IOUtils.toString(getResources().openRawResource(R.raw.brazil_players)));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, PlayerDetailActivity.class);
        Player player = (Player) playerAdapter.getItem(i);
        intent.putExtra(PLAYER, player);
        startActivity(intent);
    }
}
