package boardGame;

public class Board {
    private int rows;
    private int colums;
    private Piece[][] pieces;

    public Board(int rows, int colums) {
        if (rows < 1 || colums < 1){ // verifica se as linhas e as colunas são pelo menos maiores do que zero pra criar o tabuleiro
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.colums = colums;
        pieces = new Piece[rows][colums];
    }
    public int getRows() {
        return rows;
    }

    public int getColums() {
        return colums;
    }

    public Piece piece(int row, int column){
        if (!positionExists(row, column)){ // verifica se a posição existe antes de colocar no tabuleiro
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if (!positionExists(position)){ // verifica se a posição existe antes de colocar no tabuleiro
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){ // método de colocar uma peça em uma dada posição
        if(thereIsAPiece(position)){ // verifico se já tem outra peça na posição antes de colocar
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        if (!thereIsAPiece(position)){ // verifica se a posição onde eu quero remover a peça tem uma peça
            return null;
        }
        Piece aux = piece(position); // aux recebe a peça da posição
        aux.position = null; // a posição da peça recebe null
        pieces[position.getRow()][position.getColumn()] = null; // retirando a peça do tabuleiro
        return aux; // retorna a peça removida
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < colums;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){ // método para testar se tem uma peça nessa posição
        if (!positionExists(position)){ // verifico antes se a posição existe
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null; // se for diferente de nulo significa que tem uma peça nessa posição
    }

}
