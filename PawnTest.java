import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void testBlackPawnForwardMove() {
        Pawn blackPawn = new Pawn("♟", Color.BLACK, "0");
        Board newBoard = new Board(false);
        newBoard.board[2][0] = blackPawn;

        assertTrue(blackPawn.validMove(0, 2, 0, 3, newBoard.board));
    }

    @Test
    void testWhitePawnCapture() {
        Pawn whitePawn = new Pawn("♙", Color.WHITE, "0");
        Pawn blackPawn = new Pawn("♟", Color.BLACK, "0");
        Board newBoard = new Board(false);
        newBoard.board[1][0] = blackPawn;
        newBoard.board[2][1] = whitePawn;

        assertTrue(whitePawn.validMove(1, 2, 0, 1, newBoard.board));
    }

    @Test
    void testBlackPawnCapture() {
        Pawn blackPawn = new Pawn("♟", Color.BLACK, "0");
        Pawn whitePawn = new Pawn("♙", Color.WHITE, "0");
        Board newBoard = new Board(false);
        newBoard.board[5][1] = blackPawn;
        newBoard.board[6][0] = whitePawn;

        assertTrue(blackPawn.validMove(1, 5, 0, 6, newBoard.board));
    }

    @Test
    void testWhitePawnForwardMove() {
        Pawn whitePawn = new Pawn("♙", Color.WHITE, "0");
        Board newBoard = new Board(false);
        newBoard.board[6][0] = whitePawn;

        assertTrue(whitePawn.validMove(0, 6, 0, 5, newBoard.board));

    }

    @Test
    void testPawnCaptureOwnColor() {
        Pawn whitePawn = new Pawn("♙", Color.WHITE, "0");
        Pawn whitePawn2 = new Pawn("♙", Color.WHITE, "1");
        Piece[][] board = new Piece[8][8];
        initializeBoard(board);
        board[6][0] = whitePawn;
        board[5][1] = whitePawn2;

        assertFalse(whitePawn.validMove(0, 6, 1, 5, board));
    }

    private void initializeBoard(Piece[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new NullPiece();
            }
        }
    }
}