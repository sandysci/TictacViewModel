package com.example.sandy.viewmodelsandy.viewmodels;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandy.viewmodelsandy.R;
import com.example.sandy.viewmodelsandy.views.GameActivity;

public class PlayerEndGameFragment extends DialogFragment {
   private View rootView;
   private GameActivity gameActivity;
   private TextView playerTextView;
   private static String winner;



   public static PlayerEndGameFragment newinstance(GameActivity activity, String win){
       PlayerEndGameFragment playerNameFragment = new PlayerEndGameFragment();
       playerNameFragment.gameActivity =activity;
       winner = win;
       return playerNameFragment;
   }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       initViews();
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(rootView)
                .setTitle("Game End")
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                })
                .setNegativeButton("ExitGame", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     exitGame();
                    }
                })
                .setCancelable(true)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);


        return alertDialog;
    }


    private void initViews() {
        rootView = LayoutInflater.from(getContext())
                .inflate(R.layout.dialog_player_endgame, null, false);
        playerTextView = rootView.findViewById(R.id.winner_name);
        playerTextView.setText(winner);
    }

    private void newGame(){
       dismiss();
       gameActivity.openPlayerDialog();
    }
    private void exitGame(){
        dismiss();
        gameActivity.closeGame();
    }
}
