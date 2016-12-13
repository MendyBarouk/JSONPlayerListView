package com.firstproject.mendy.jsonplayerlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mendy on 12/12/2016.
 */

public class PlayerAdapter extends ArrayAdapter<Player> {

    public PlayerAdapter(Context context, List<Player> players){
        super(context, R.layout.list_item, players);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlayerViewHolder playerViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            playerViewHolder = new PlayerViewHolder();
            playerViewHolder.name = (TextView) convertView.findViewById(R.id.list_item_name);
            playerViewHolder.Positioning = (TextView) convertView.findViewById(R.id.list_item_positioning);
            playerViewHolder.birthDate = (TextView) convertView.findViewById(R.id.list_item_birth_date);
            playerViewHolder.isCaptain = (TextView) convertView.findViewById(R.id.list_item_is_captain);
            convertView.setTag(playerViewHolder);
        } else {
            playerViewHolder = (PlayerViewHolder) convertView.getTag();
        }

        Player player = getItem(position);
        playerViewHolder.name.setText(player.getFullName());
        playerViewHolder.Positioning.setText(player.getPosition());
        playerViewHolder.birthDate.setText(player.getDateOfBirth());
        if (player.isCaptain())
            playerViewHolder.isCaptain.setText("©");
        else playerViewHolder.isCaptain.setText("");

        return convertView;

    }

    private class PlayerViewHolder{
        public TextView name;
        public TextView Positioning;
        public TextView birthDate;
        public TextView isCaptain;
    }
}
