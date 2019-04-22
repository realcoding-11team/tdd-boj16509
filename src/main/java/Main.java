import java.util.Scanner;

public class Main {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        Piece sang, king;
        sang = new Piece(sc.nextInt(), sc.nextInt(), 0);
        king = new Piece(sc.nextInt(), sc.nextInt(), 0);
        System.out.print(controller.bfs(sang, king));
    }
}
