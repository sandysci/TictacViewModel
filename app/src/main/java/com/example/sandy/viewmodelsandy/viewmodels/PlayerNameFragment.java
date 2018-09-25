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
import android.widget.Button;
import android.widget.Toast;

import com.example.sandy.viewmodelsandy.R;
import com.example.sandy.viewmodelsandy.views.GameActivity;

public class PlayerNameFragment extends DialogFragment {
   private View rootView;
   private GameActivity gameActivity;
   private TextInputLayout player1Layout,player2Layout;
   private TextInputEditText player1EditText,player2EditText;



   public static PlayerNameFragment newinstance(GameActivity activity){
       PlayerNameFragment playerNameFragment = new PlayerNameFragment();
       playerNameFragment.gameActivity =activity;
       return playerNameFragment;
   }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       initViews();
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(rootView)
                .setTitle("Enter name")
                .setCancelable(true)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(),"Sumbit clicked",Toast.LENGTH_SHORT).show();
                        gameActivity.setPlayerName(player1EditText.getText().toString(),player2EditText.getText().toString());
                        dismiss();
                    }
                })
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);


        return alertDialog;
    }


    private void initViews() {
        rootView = LayoutInflater.from(getContext())
                .inflate(R.layout.dialog_players_name, null, false);
        player1Layout = rootView.findViewById(R.id.layout_player1);
        player2Layout = rootView.findViewById(R.id.layout_player2);

        player1EditText = rootView.findViewById(R.id.et_player1);
        player2EditText = rootView.findViewById(R.id.et_player2);
//        addTextWatchers();
    }
    public void onButtonClicked(AlertDialog dialog){

    }
}
