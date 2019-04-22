import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./realtemp.txt"));
            bw.write("asdsads");
        } catch(Exception e){}

        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        Piece sang, king;
        sang = new Piece(sc.nextInt(), sc.nextInt(), 0);
        king = new Piece(sc.nextInt(), sc.nextInt(), 0);
        System.out.print(controller.bfs(sang, king));
    }
}
