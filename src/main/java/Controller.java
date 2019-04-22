import java.util.LinkedList;
import java.util.Queue;

class Controller {

   private final int[] dy = new int[]{-3, -3, -2, 2, 3, 3, 2, -2};
   private final int[] dx = new int[]{-2, 2, 3, 3, 2, -2, -3, -3};
   private final int[] cy = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
   private final int[] cx = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
   private final int[] ay = new int[]{-1, -1, 0, 0, 1, 1, 0, 0};
   private final int[] ax = new int[]{0, 0, 1, 1, 0, 0, -1, -1};
   private final int Y = 10;
   private final int X = 9;

   public int bfs(Piece sang, Piece king) {
       Queue<Piece> q = new LinkedList<Piece>();
       boolean[][] visited = new boolean[Y][X];
       q.add(sang);
       visited[sang.y][sang.x] = true;

       while (!q.isEmpty()) {
           Piece u = q.poll();
           if (u.y == king.y && u.x == king.x)
               return u.count;

           for (int i = 0; i < 8; i++) {
               int y = u.y + ay[i];
               int x = u.x + ax[i];
               if (y < 0 || y >= Y || x < 0 || x >= X || (y == king.y && x == king.x))
                   continue;

               y = u.y + cy[i];
               x = u.x + cx[i];
               if (y < 0 || y >= Y || x < 0 || x >= X || (y == king.y && x == king.x))
                   continue;

               y = u.y + dy[i];
               x = u.x + dx[i];
               if (y < 0 || y >= Y || x < 0 || x >= X || visited[y][x])
                   continue;

               q.add(new Piece(y, x, u.count + 1));
               visited[y][x] = true;
           }
       }

       return -1;

    }
}
