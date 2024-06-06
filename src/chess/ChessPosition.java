package chess;

import boardGame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8){ // isso é aceito: column < 'a'
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }
    public char getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }

    protected Position toPosition(){ // convertendo a posição do xadrez para uma posição
        return new Position(8 - row, column - 'a');     //matriz 8x8: se a linha passada for 1, 8 - 1 =  7, 7 na matriz é igual a linha 1
                                                                    // e para a column, tá sendo usado o unicode das letras. 'b' - 'a' = 1
    }
    protected static ChessPosition fromPosition(Position position){ // retorna a forma inversa recebendo uma posição e retornando uma ChessPosition
        return new ChessPosition((char)('a' - position.getColumn()),8 - position.getRow());
    }
    @Override
    public String toString(){
        return  "" + column + row;
    }

}
