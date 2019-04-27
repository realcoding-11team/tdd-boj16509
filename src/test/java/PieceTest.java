import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;

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
    @Test(expected = IllegalArgumentException.class)
    public void invalidCreateTest(){
        Piece piece = new Piece(-5,-3,3);
    }
}
