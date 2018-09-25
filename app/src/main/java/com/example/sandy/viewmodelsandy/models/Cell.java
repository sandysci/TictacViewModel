package com.example.sandy.viewmodelsandy.models;

import com.example.sandy.viewmodelsandy.utilities.StringUtilities;

public class Cell {
    public Player player;

    public Cell(Player player){
        this.player = player;
    }
    public boolean isEmpty() {
        return player == null || StringUtilities.isNullOrEmpty(player.value);
    }
}
