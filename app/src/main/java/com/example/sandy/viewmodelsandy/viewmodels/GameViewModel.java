package com.example.sandy.viewmodelsandy.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayMap;
import android.util.Log;

import com.example.sandy.viewmodelsandy.models.Game;
import com.example.sandy.viewmodelsandy.models.Cell;
import com.example.sandy.viewmodelsandy.models.Player;

import static com.example.sandy.viewmodelsandy.utilities.StringUtilities.stringFromNumbers;


public class GameViewModel extends ViewModel {

    public ObservableArrayMap<String, String> cells;
    private Game game;

    public void init(String player1, String player2) {
        game = new Game(player1, player2);
        cells = new ObservableArrayMap<>();
    }

    public void onClickedCellAt(int row, int column) {
        try {

            if (game.cells[row][column] == null) {
                game.cells[row][column] = new Cell(game.currentPlayer);
                cells.put(stringFromNumbers(row, column), game.currentPlayer.value);
                if (game.gamehasEnded()) {
                    game.gameReset();
                }
                else
                    game.switchPlayer();
            }
        }catch (Exception e){
            Log.i("REQUEST_TAG",e.getMessage());
        }
    }

    public LiveData<Player> getWinner() {
        Log.i("REQUEST_TAG","gameviewmodel-"+game.winner);
        return game.winner;
    }

}
