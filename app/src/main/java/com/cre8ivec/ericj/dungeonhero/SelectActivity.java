package com.cre8ivec.ericj.dungeonhero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    public static final String DUNGEON_TYPE = "com.cre8ive.com.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        initButtons();
    }

    private void initButtons() {
        Button mCaveDungeon = findViewById(R.id.cave_button);
        mCaveDungeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("CAVE");
            }
        });

        Button mTowerDungeon = findViewById(R.id.tower_button);
        mTowerDungeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("TOWER");
            }
        });

        Button mUnderWaterButton = findViewById(R.id.water_button);
        mUnderWaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("UNDERWATER");
            }
        });
    }

    private void startGame(String type) {

        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra(DUNGEON_TYPE, type);
        startActivity(intent);
    }
}
