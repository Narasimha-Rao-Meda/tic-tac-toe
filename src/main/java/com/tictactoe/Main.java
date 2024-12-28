package com.tictactoe;

import com.tictactoe.controller.TicTacToe;

public class Main {
    public static void main(String [] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initializeGame(3);
        ticTacToe.startGame();
        String gameWinner = ticTacToe.getGameWinner();
        if("Tie!".equals(gameWinner)) {
            System.out.println(gameWinner);
        } else {
            System.out.println(gameWinner + " Won the game");
        }

    }
}
