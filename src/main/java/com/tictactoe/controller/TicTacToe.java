package com.tictactoe.controller;

import com.tictactoe.model.Board;
import com.tictactoe.model.PlayerCross;
import com.tictactoe.model.PlayerRound;
import com.tictactoe.model.PlayerSign;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToe {
    private Deque<PlayerSign> players;
    private Board gameBoard;
    private Scanner scanner;
    private String gameWinner = "Tie!";

    public TicTacToe() {

    }

    public void initializeGame(int size) {
        gameBoard = new Board(size);
        PlayerCross p1 = new PlayerCross();
        PlayerRound p2 = new PlayerRound();
        players = new LinkedList<>();
        players.add(p1);
        players.add(p2);
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        while(true) {
            PlayerSign player = players.removeFirst();
            gameBoard.printBoard();
            System.out.println(player.getName() + " move");
            System.out.println("Place Sign on the board");
            System.out.println("Enter comma separated Row and Column , example: 1,1");
            String position;
            String[] positions;
            int row, col;

            try {
                position = scanner.next();
                position.trim();
                positions = position.split(",");
                row = Integer.parseInt(positions[0].strip());
                col = Integer.parseInt(positions[1].strip());
            } catch (Exception  exception) {
                System.out.println("Invalid input elected. Please provide the correct input");
                players.addFirst(player);
                continue;
            }
            boolean isValidMove = gameBoard.canPlace(row, col);
            if(!isValidMove) {
                System.out.println("Invalid position selected, please place the sign again");
                players.addFirst(player);
                continue;
            }
            gameBoard.addPiece(row, col, player);
            String winner = gameBoard.getWinner(row, col, player);
            if(!"".equals(winner)) {
                gameWinner = winner;
                break;
            }
            players.addLast(player);
        }
    }

    public String getGameWinner() {
        return gameWinner;
    }
}
