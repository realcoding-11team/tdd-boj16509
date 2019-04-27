import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        Piece sang, king;
        sang = new Piece(sc.nextInt(), sc.nextInt(), 0);
        king = new Piece(sc.nextInt(), sc.nextInt(), 0);
        System.out.print(solution.bfs(sang, king));
    }
}
