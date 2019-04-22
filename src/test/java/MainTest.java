import org.junit.Test;

public class MainTest {
    @Test(timeout = 1000)
    public void main() {
        Controller controller = new Controller();
        Piece sang, king;
        sang = new Piece(4, 2, 0);
        king = new Piece(2, 5, 0);
        System.out.print(controller.bfs(sang, king));
    }
}
