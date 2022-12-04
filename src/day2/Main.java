package day2;

import utils.MyFiles;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Move[] moves = fileToMoves("src/input.txt");
        System.out.println(getTotalPoints(moves));
    }

    // converts a two letter string to a "Move" object containing the moves of two players
    public static Move stringToMove(String s) {
        // convert 'A' and 'X' to Rock, 'B' and 'Y' to Paper, and 'C' and 'Z' to Scissors
        return new Move(s.charAt(0) == 'A' ? "ROCK" : s.charAt(0) == 'B' ? "PAPER" : "SCISSORS",
                s.charAt(2) == 'X' ? "ROCK" : s.charAt(2) == 'Y' ? "PAPER" : "SCISSORS");
    }

    public static Move stringToMove2(String s) {
        // convert 'A' to Rock, 'B' to Paper, and 'C' to Scissors
        // convert 'X' to whatever is needed to lose, 'Y' to whatever is needed to tie, and 'Z' to whatever is needed to win
        String player1 = s.charAt(0) == 'A' ? "ROCK" : s.charAt(0) == 'B' ? "PAPER" : "SCISSORS";
        String player2Lose = s.charAt(0) == 'A' ? "SCISSORS" : s.charAt(0) == 'B' ? "ROCK" : "PAPER";
        return new Move(player1,
                s.charAt
                        (2) == 'X' ? player2Lose :
                        s.charAt(2) == 'Y' ? player1 :
                                s.charAt(0) == 'A' ? "PAPER" : s.charAt(0) == 'B' ? "SCISSORS" : "ROCK");
    }


    // maps a file to a list of moves
    public static Move[] fileToMoves(String path) throws IOException {
        String[] strings = MyFiles.fileToList(path);
        Move[] moves = new Move[strings.length];
        for (int i = 0; i < strings.length; i++) {
            moves[i] = stringToMove2(strings[i]);
        }
        return moves;
    }

    //    takes a move and returns player2's points
    public static int getRoundPoints(Move move) {
        if (move.player1.equals(move.player2)) {
            return 3;
        } else if (move.player1.equals("ROCK") && move.player2.equals("SCISSORS")) {
            return 0;
        } else if (move.player1.equals("PAPER") && move.player2.equals("ROCK")) {
            return 0;
        } else if (move.player1.equals("SCISSORS") && move.player2.equals("PAPER")) {
            return 0;
        } else {
            return 6;
        }
    }

    // takes a move and returns player2's object points
    public static int getRoundObjectPoints(Move move) {
        if (move.player2.equals("ROCK")) {
            return 1;
        }
        if (move.player2.equals("PAPER")) {
            return 2;
        }
        if (move.player2.equals("SCISSORS")) {
            return 3;
        }
        return 0;
    }

    //    takes a list of moves and returns the total points of player2
    public static int getTotalPoints(Move[] moves) {
        int totalPoints = 0;
        for (Move move : moves) {
            totalPoints += (getRoundPoints(move) + getRoundObjectPoints(move));
        }
        return totalPoints;
    }

    // "Move" Object
    public static class Move {
        public String player1;
        public String player2;

        public Move(String player1, String player2) {
            this.player1 = player1;
            this.player2 = player2;
        }
    }
}
