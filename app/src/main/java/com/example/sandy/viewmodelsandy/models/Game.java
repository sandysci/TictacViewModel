package com.example.sandy.viewmodelsandy.models;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

public class Game {
    private static final String TAG = "REQUEST_TAG";
    private static final int BOARD_SIZE = 3;

    public Player player1;
    public Player player2;

    public Player currentPlayer = player1;
    public Cell[][] cells;

    public MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo) {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        player1 = new Player(playerOne, "x");
        player2 = new Player(playerTwo, "o");
        currentPlayer = player1;
    }

    public boolean gamehasEnded(){
        if(isHorinzonatlCell() || isVerticalCell() || isDiagonalCells() ){
            winner.setValue(currentPlayer);
            return true;
        }
        if(checkIfBoardisFull()){
            winner.setValue(null);
            return true;
        }
        return  false;
    }
    public void switchPlayer(){
        currentPlayer = (currentPlayer == player1)?player2:player1;
    }
    public void gameReset(){
        Log.i("REQUEST_TAG","winner" +currentPlayer.name);
        player1=null;
        player2=null;
        currentPlayer = null;
        cells = null;
    }
    public boolean isHorinzonatlCell(){
        try{
            for(int i = 0 ; i <BOARD_SIZE ; i++){
                if(areEqual(cells[i][0],cells[i][1],cells[i][2]))
                    return true;
            }
         return false;
        }catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }


    }
    public boolean isVerticalCell(){
        try{
            for(int i = 0 ; i <BOARD_SIZE ; i++){
                if(areEqual(cells[0][i],cells[1][i],cells[2][i]))
                    return true;
            }
         return false;

        }catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }


    }
    public boolean isDiagonalCells() {
        try {
            return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                    areEqual(cells[0][2], cells[1][1], cells[2][0]);
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }
    public boolean areEqual(Cell... cells){
        if(cells == null|| cells.length == 0)
            return false;
        for (Cell cell: cells)
            if(cell == null)
                return false;
        for(Cell cell: cells){
          Cell compareeachcell = cells[0];
          if(!compareeachcell.player.value.equals(cell.player.value))
              return false;
         }
      return  true;
    }

    public boolean checkIfBoardisFull(){
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell == null || cell.isEmpty()) {
                    return false;
                }
            }

        }
        return true;

    }
}
