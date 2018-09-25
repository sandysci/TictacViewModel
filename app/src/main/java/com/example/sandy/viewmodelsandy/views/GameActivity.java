package com.example.sandy.viewmodelsandy.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sandy.viewmodelsandy.R;
import com.example.sandy.viewmodelsandy.databinding.ActivityGameBinding;
import com.example.sandy.viewmodelsandy.viewmodels.GameViewModel;
import android.arch.lifecycle.ViewModelProviders;

public class GameActivity extends AppCompatActivity {
    private GameViewModel gameViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        initDataBinding("sandy","chioma");


    }
    private void initDataBinding(String player1, String player2) {
        ActivityGameBinding activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.init(player1, player2);
        activityGameBinding.setGameViewModel(gameViewModel);
    }


}
