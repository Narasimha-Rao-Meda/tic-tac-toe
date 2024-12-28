package com.tictactoe.model;

import static java.lang.Math.abs;

public class Board {

    private final int size;
    private final PlayerSign[][] board;
    private int emptySpaces;
    private final int[] rowSum, colSum;
    private int diagSum, revDiagSum;

    public Board(int size) {
        this.size = size;
        this.board = new PlayerSign[size][size];
        this.emptySpaces = size * size;
        this.rowSum = new int[size];
        this.colSum = new int[size];
        this.diagSum = 0;
        this.revDiagSum = 0;
    }

    public boolean canPlace(int row, int col) {
        if(row < 0 || row >= this.size || col < 0 || col >= this.size) {
            return false;
        }
        return this.board[row][col] == null;
    }

    public void addPiece(int row, int col, PlayerSign playerSign) {
        board[row][col] = playerSign;
        int value = playerSign instanceof PlayerCross ? 1 : -1;
        this.rowSum[row] += value;
        this.colSum[col] += value;
        if(row == col) {
            this.diagSum += value;
        }
        if (row == this.size-1-col) {
            this.revDiagSum += value;
        }

        this.emptySpaces -= 1;

    }

    public void printBoard() {
        for(int row=0; row<this.size; row++) {
            for(int col=0; col< this.size; col++) {
                String value = " ";
                if(board[row][col] == null) {
                    value = " ";
                } else if(board[row][col] instanceof PlayerCross) {
                    value = "X";
                } else if(board[row][col] instanceof PlayerRound) {
                    value = "O";
                }
                System.out.print(" " + value + " |");
            }
            System.out.println();
        }
    }

    public String getWinner(int row, int col, PlayerSign player) {
        if(this.emptySpaces == 0) {
            return "Tie!";
        }

        if(this.emptySpaces == 1 && (abs(this.rowSum[row]) < this.size-1 || abs(this.colSum[col]) < this.size-1 || abs(this.diagSum) < this.size-1 || abs(this.revDiagSum) < this.size-1)) {
            return "Tie!";
        }

        if(abs(this.rowSum[row]) == this.size || abs(this.colSum[col]) == this.size || abs(this.diagSum) == this.size || abs(this.revDiagSum) == this.size) {
            return player.getName();
        }
        return "";
    }

}
