package com.example.sandy.viewmodelsandy.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.sandy.viewmodelsandy.R;
import com.example.sandy.viewmodelsandy.databinding.ActivityGameBinding;
import com.example.sandy.viewmodelsandy.models.Player;
import com.example.sandy.viewmodelsandy.viewmodels.GameViewModel;
import com.example.sandy.viewmodelsandy.viewmodels.PlayerEndGameFragment;
import com.example.sandy.viewmodelsandy.viewmodels.PlayerNameFragment;

import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private GameViewModel gameViewModel;
    private String player1, player2;
    //private PlayerNameFragment playerNameFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        openPlayerDialog();



    }

    public void  setPlayerName(String play1, String play2){
        player1 = play1;
        player2 = play2;
        Log.i("REQUEST_TAG","player1");
        Log.i("REQUEST_TAG",player1);
        Log.i("REQUEST_TAG",player2);

        if(player1.equals("") && player2.equals("")){
            Toast.makeText(this,"Using System configuration name",Toast.LENGTH_SHORT).show();
            initDataBinding("Player1","Player2");
        }
        else if(player1.equals("")){
            Toast.makeText(this,"Using System configuration name for player1",Toast.LENGTH_SHORT).show();
            initDataBinding("Player1",player2);
        }
        else if(player2.equals("")){
            Toast.makeText(this,"Using System configuration name for Player2",Toast.LENGTH_SHORT).show();
            initDataBinding(player1,"Player2");
        }
        else{
            initDataBinding(player1,player2);
        }

    }
    public void openPlayerDialog(){
        PlayerNameFragment playerNameFragment = PlayerNameFragment.newinstance(this);
        playerNameFragment.setCancelable(false);
        playerNameFragment.show(getSupportFragmentManager(),"players");
    }
    private void initDataBinding(String player1, String player2) {
        ActivityGameBinding activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.init(player1, player2);
        activityGameBinding.setGameViewModel(gameViewModel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        onwinnerSet();
    }

    public void onwinnerSet(){
        gameViewModel.getWinner().observe(this,this::showWinnerdialog);
    }
    public void showWinnerdialog(Player player){
        String winner = null;
        try {
            Log.i("REQUEST_TAG","winner game activity");
            Log.i("REQUEST_TAG",player.toString());
             winner = (player == null ? "No one won , try again , but you are good mehn":player.name);

        }catch (NullPointerException e){
            winner = "No one won , try again , but you are good mehn";
        }
        PlayerEndGameFragment playerEndGameFragment = PlayerEndGameFragment.newinstance(this,winner);
        playerEndGameFragment.setCancelable(false);
        playerEndGameFragment.show(getSupportFragmentManager(),"end game");


    }
    public void closeGame(){
        this.finish();
    }


}
