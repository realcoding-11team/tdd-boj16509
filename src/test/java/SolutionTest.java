import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SolutionTest {


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
    @Test(timeout = 1000)
    public void timeOutTest() {
        Solution solution = new Solution();
        Piece sang, king;
        sang = new Piece(4, 2, 0);
        king = new Piece(2, 5, 0);
        System.out.print(solution.bfs(sang, king));
    }
    @Test
    public void trackingMethodTest(){
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
    public void trackingRightWayTestWithUniqueWayCase(){
        //유일한 경로를 갖는 경우
        Piece sang = new Piece(1,0,0);
        Piece king = new Piece(0, 1,0);
        Solution solution = new Solution();
        int ret = solution.bfs(sang,king);
        ArrayList<ArrayList<Integer>> track = (ArrayList<ArrayList<Integer>>)solution.tracking();
        //상의 시작 위치 1,0
        assertThat(track.get(0).get(0), is(1));
        assertThat(track.get(0).get(1), is(0));
        //상의 다음 위치 3,3
        assertThat(track.get(1).get(0), is(3));
        assertThat(track.get(1).get(1), is(3));
        //상의 다음 위치 0,1
        assertThat(track.get(2).get(0), is(0));
        assertThat(track.get(2).get(1), is(1));

        assertThat(ret, is(2));
    }

    @Test
    public void trackingBoundaryTestWithEdgeCases(){
        Piece sang, king;
        int[][] placeOfSang = {{0,0},{0,0},
                {9,0},{9,0},
                {0,8},{0,8},
                {9,8},{9,8}};
        int[][] placeOfKing = {{0,1},{1,0},
                {8,0},{9,1},
                {1,8},{0,7},
                {8,8},{9,7}};
        for (int nth = 0;nth<placeOfSang.length;nth++) {
            sang = new Piece(placeOfSang[nth][0], placeOfSang[nth][1],  0);
            king = new Piece(placeOfKing[nth][0], placeOfKing[nth][1],  0);
            Solution solution = new Solution();

            int ret = solution.bfs(sang, king);
            ArrayList<ArrayList<Integer>> track = (ArrayList<ArrayList<Integer>>) solution.tracking();
            for(int i=0;i<track.size();i++){
                assertThat(track.get(i).get(0), greaterThanOrEqualTo(0));
                assertThat(track.get(i).get(1), greaterThanOrEqualTo(0));
                assertThat(track.get(i).get(0), lessThanOrEqualTo(9));
                assertThat(track.get(i).get(1), lessThanOrEqualTo(8));
            }
            assertThat(ret,is(5));
        }
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
                //System.out.println(ret + " " + output);
                assertThat(ret,is(output));
            }
        } catch(Exception e){}
    }


}
