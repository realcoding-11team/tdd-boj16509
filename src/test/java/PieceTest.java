import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PieceTest {
    @Test
    public void checkNegNumber(){
        Piece piece=new Piece(1,2,3);
        assertFalse(piece.x<0||piece.y<0);
    }
    @Test
    public void pieceCreateTest(){
        Piece piece = new Piece(1,2,3);
        assertThat(piece.y, is(1));
        assertThat(piece.x, is(2));
        assertThat(piece.count, is(3));
    }
}
