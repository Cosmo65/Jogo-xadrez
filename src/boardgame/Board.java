package boardgame;

import exceptions.BoardException;

public class Board {
    private int rows;
    private int columns;
    private final Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns <1){
            throw new BoardException("Error creating board:there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][ columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if (! positionExists(row, column)){
            throw new BoardException("Position out of board (" + row + "," + column + ")");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if (! positionExists(position.getRow(), position.getColumn())){
            throw new BoardException("Position out of board (" + position + ")");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if  (thereIsAPiece(position)){
            throw new BoardException("There is alredy a piece on position (" + position + ")");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if (! this.positionExists(position)){
            throw new BoardException("Position not on the board!");
        }
        if (piece(position) == null){
            return null;
        }

        Piece p = piece(position);
        p.position = null;
        pieces[position.getRow()][position.getColumn()] = null;

        return p;
    }


    private boolean positionExists(int row, int column){
        return ((row >= 0 && row < rows) && (column >= 0 && column < columns));
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (positionExists(position)){
            return (piece(position) != null);
        }
        throw new BoardException("Position is out of board (" + position + ")");
    }


}
