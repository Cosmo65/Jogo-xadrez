package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

import java.io.Serializable;

public class King extends ChessPiece implements Serializable {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        if (getColor().toString().equals("WHITE")){
            return "\u2654";
        }
        return "\u265A";
    }
}
