public class Bishop extends Piece{
    public Bishop(String piece, Color color, String iD) {
        super(piece, color, iD);
    }

    @Override
    public boolean validMove(int x, int y, int moveX, int moveY, Piece[][] board) {
        int dy = Math.abs(moveY - y);
        int dx = Math.abs(moveX - x);

        if(moveX < 0 || moveX>7 || moveY >7 || moveY<0){
            return false;
        }
        else return dy == dx &&
                isClearDiagonal(x, y, moveX, moveY, board)
                && (board[moveY][moveX] instanceof NullPiece ||
                board[moveY][moveX].getColor() != getColor());
    }

    public boolean isClearDiagonal(int x, int y, int moveX, int moveY, Piece[][] board){
        int directionX = moveX >x ? 1 : -1;
        int directionY = moveY > y ? 1 : -1;
        if(directionX > 0&& directionY > 0){
            for(int r = y + directionY; r != moveY; r++){
                for(int c = x + directionX; c!=moveX; c++){
                    if(!(board[r][c] instanceof NullPiece)){
                        return false;
                    }
                }
            }
        }
        else if(directionX < 0&& directionY < 0){
            for(int r = y + directionY; r != moveY; r--){
                for(int c = x + directionX; c!=moveX; c--){
                    if(!(board[r][c] instanceof NullPiece)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    @Override
    public boolean isClear(int x, int y, Piece[][] board) {
        return board[y][x].getColor() != getColor();
    }

    public boolean isClearUp(int x, int y, int moveX, int moveY, Piece[][] board){
        for (int r = y; r < moveY; r++){
            for(int c = x; c < moveX; c++){
                if(board[r][c] != null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isClearDown(int x, int y, int moveX, int moveY, Piece[][] board){
        for (int r = y; r > moveY; r--){
            for(int c = x; c > moveX; c--){
                if(board[r][c] != null){
                    return false;
                }
            }
        }
        return true;
    }
}
