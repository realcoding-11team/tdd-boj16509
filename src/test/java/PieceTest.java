import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PieceTest {
    @Test
    public void checkNegNumber(){
        Piece piece=new Piece(1,2,3);
        assertFalse(piece.x<0||piece.y<0);
    }

}