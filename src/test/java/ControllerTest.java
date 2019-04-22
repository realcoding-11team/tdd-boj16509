import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ControllerTest {


    @Test(expected = IllegalArgumentException.class)
    public void InvalidInputInSangTest(){
        Piece sang = new Piece(5,-3,0);
        Piece king = new Piece(2, 3,0);
        Controller controller = new Controller();
        controller.bfs(sang,king);
    }
    @Test(expected = IllegalArgumentException.class)
    public void InvalidInputIsSameTest(){
        Piece sang = new Piece(3,3,0);
        Piece king = new Piece(3,3,0);
        Controller controller = new Controller();
        controller.bfs(sang,king);
    }
    @Test(expected = IllegalArgumentException.class)
    public void InvalidInputInKingTest(){
        Piece sang = new Piece(2,1,0);
        Piece king = new Piece(8, 13,0);
        Controller controller = new Controller();
        controller.bfs(sang,king);
    }
    @Test
    public void externalFileTest(){
        int start = 1;
        int end = 50;
        try {
            for (int nth = start;nth<=end;nth++){
                Controller controller = new Controller();
                BufferedReader brin = new BufferedReader(new FileReader(String.format("./data/%d.in",nth)));
                BufferedReader brout = new BufferedReader(new FileReader(String.format("./data/%d.out",nth)));
                String[] inputs;
                Piece sang, king;
                inputs = brin.readLine().split(" ");
                sang = new Piece(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]), 0);
                inputs = brin.readLine().split(" ");
                king = new Piece(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]), 0);
                int ret = controller.bfs(sang, king);
                int output = Integer.parseInt(brout.readLine());
                System.out.println(ret + " " + output);
                assertThat(ret,is(output));
            }
        } catch(Exception e){}
    }
    
    @Test
    public void nomalCaseTest(){
        Piece sang = new Piece(1,1,0);
        Piece king = new Piece(4, 3,0);
        Controller controller = new Controller();
        int ret = controller.bfs(sang,king);
        assertThat(ret, is(1));
    }
}
