import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void trackingTest(){
        Piece sang = new Piece(5,5,0);
        Piece king = new Piece(5, 6,0);
        Solution solution = new Solution();
        int ret = solution.bfs(sang,king);
        ArrayList<ArrayList<Integer>> track = (ArrayList<ArrayList<Integer>>)solution.tracking();
        for(int i=0;i<track.size();i++)
            System.out.println(track.get(i).get(0)+ " "+ track.get(i).get(1));
        assertThat(ret, is(5));
    }

    @Test
    public void nomalCaseTest(){
        Piece sang = new Piece(1,1,0);
        Piece king = new Piece(4, 3,0);
        Solution solution = new Solution();
        int ret = solution.bfs(sang,king);
        assertThat(ret, is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void InvalidInputInSangTest(){
        Piece sang = new Piece(5,-3,0);
        Piece king = new Piece(2, 3,0);
        Solution solution = new Solution();
        solution.bfs(sang,king);
    }
    @Test(expected = IllegalArgumentException.class)
    public void InvalidInputIsSameTest(){
        Piece sang = new Piece(3,3,0);
        Piece king = new Piece(3,3,0);
        Solution solution = new Solution();
        solution.bfs(sang,king);
    }
    @Test(expected = IllegalArgumentException.class)
    public void InvalidInputInKingTest(){
        Piece sang = new Piece(2,1,0);
        Piece king = new Piece(8, 13,0);
        Solution solution = new Solution();
        solution.bfs(sang,king);
    }
    @Test
    public void externalFileTest(){
        int start = 1;
        int end = 50;
        try {
            for (int nth = start;nth<=end;nth++){
                Solution solution = new Solution();
                BufferedReader brin = new BufferedReader(new FileReader(String.format("./src/main/resources/data/%d.in",nth)));
                BufferedReader brout = new BufferedReader(new FileReader(String.format("./src/main/resources/data/%d.out",nth)));
                String[] inputs;
                Piece sang, king;
                inputs = brin.readLine().split(" ");
                sang = new Piece(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]), 0);
                inputs = brin.readLine().split(" ");
                king = new Piece(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]), 0);
                int ret = solution.bfs(sang, king);
                int output = Integer.parseInt(brout.readLine());
                System.out.println(ret + " " + output);
                assertThat(ret,is(output));
            }
        } catch(Exception e){}
    }

    @Test(timeout = 1000)
    public void timeOutTest() {
        Solution solution = new Solution();
        Piece sang, king;
        sang = new Piece(4, 2, 0);
        king = new Piece(2, 5, 0);
        System.out.print(solution.bfs(sang, king));
    }
}
