package com.cre8ivec.ericj.dungeonhero;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.cre8ivec.ericj.dungeonhero.fragments.AttackFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.ConfirmFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.DecisionFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.DescriptionFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.DrawPadFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.InfoFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.ItemsViewFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.MoveActionsFragment;
import com.cre8ivec.ericj.dungeonhero.fragments.SearchFragment;
import com.cre8ivec.ericj.utility.DungeonFactory.GetDungeonFactory;
import com.cre8ivec.ericj.utility.DungeonFactory.IDungeon;
import com.cre8ivec.ericj.utility.Heros.Hero;

public class GameActivity extends FragmentActivity {

    private IDungeon dungeon;
    private Hero hero;
    private String decisionMessage;

    public IDungeon getDungeon() {
        return dungeon;
    }
    public Hero getHero() { return hero; }
    public String getDecisionMessage() { return decisionMessage; }
    public void setDecisionMessage(String message) { decisionMessage = message; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        String type = intent.getStringExtra(SelectActivity.DUNGEON_TYPE);
        GetDungeonFactory dungeonFactory = new GetDungeonFactory();
        dungeon = dungeonFactory.getDungeon(type);
        dungeon.buildDungeon();

        hero = new Hero();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_manager, new DescriptionFragment()).commit();




    }

    private DecisionFragment decisionFragment;

    private DrawPadFragment drawPadFragment;
    private SearchFragment searchFragment;
    private ItemsViewFragment itemsViewFragment;

    private MoveActionsFragment moveActionsFragment;


    public void enterDungeon() {
        decisionFragment = new DecisionFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_manager, decisionFragment).commit();
    }

    public void setUpDrawPad() {
        drawPadFragment = new DrawPadFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.decision_view, drawPadFragment).commit();
    }

    public void putMoveButtonsView() {
        moveActionsFragment = new MoveActionsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.decision_view_actions, moveActionsFragment).commit();
    }

    public void setToDraw() {
        drawPadFragment.setToDraw();
    }

    public void setToErase() {
        drawPadFragment.setToErase();
    }

    public void setRoomName() {
        decisionFragment.setRoomName();
    }

    public void infoPushed() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_manager, new InfoFragment()).commit();
    }

    public void searchPushed() {
        searchFragment = new SearchFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.decision_view, searchFragment).commit();
    }

    public void removeSearch() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.decision_view, drawPadFragment).commit();
        searchFragment = null;
        moveActionsFragment.handleReloadDecision();
    }

    public void useItemPushed() {
        itemsViewFragment = new ItemsViewFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.decision_view, itemsViewFragment).commit();
    }

    public void removeItemsView() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.decision_view, drawPadFragment).commit();
        itemsViewFragment = null;
        moveActionsFragment.handleReloadDecision();
    }

    public void monsterInRoom() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_manager, new AttackFragment()).commit();
    }

    public void showDecision(String message) {
        decisionMessage = message;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.decision_view, new ConfirmFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        if (decisionFragment == null)
            super.onBackPressed();
        else {
            showDecision("Leave game?");
            moveActionsFragment.disableButtons();
        }
    }

    public void leaveGame() {
        super.onBackPressed();
    }

    public void keepPlaying() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (searchFragment != null)
            ft.replace(R.id.decision_view, searchFragment).commit();
        else {
            ft.replace(R.id.decision_view, drawPadFragment).commit();
            moveActionsFragment.handleReloadDecision();
        }
    }
}
