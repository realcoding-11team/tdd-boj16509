import java.util.*;

class Solution {

    private final int[] dy = new int[]{-3, -3, -2, 2, 3, 3, 2, -2};
    private final int[] dx = new int[]{-2, 2, 3, 3, 2, -2, -3, -3};
    private final int[] cy = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
    private final int[] cx = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
    private final int[] ay = new int[]{-1, -1, 0, 0, 1, 1, 0, 0};
    private final int[] ax = new int[]{0, 0, 1, 1, 0, 0, -1, -1};
    private final int Y = 10;
    private final int X = 9;
    private static int[][][] track;
    private static List<List<Integer>> trackList;
    private Piece king;

    public boolean isRange(int y, int x){
        return !(y < 0 || y >= Y || x < 0 || x >= X);
    }
    public void assertInput(Piece sang, Piece king){
        if(sang.y == king.y && sang.x == king.x)
            throw new IllegalArgumentException();
        if(!(isRange(sang.y, sang.x) && isRange(king.y, king.x)))
            throw new IllegalArgumentException();
    }

    public List tracking(){

        trackList = new ArrayList<List<Integer>>();
        tracking(king);
        return trackList;
    }
    private void tracking(Piece u){
        if(u.y == -1 && u.x == -1) return;
        tracking(new Piece(track[u.y][u.x][0],track[u.y][u.x][1],0));
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(u.y);
        item.add(u.x);
        trackList.add(item);
    }
    public int bfs(Piece sang, Piece king) {
        this.king = king;
        assertInput(sang, king);

        track = new int[Y][X][2];
        for(int i=0;i<Y;i++)
            for(int j=0;j<X;j++)
                Arrays.fill(track[i][j],-1);

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
                if (!isRange(y,x) || (y == king.y && x == king.x))
                    continue;

                y = u.y + cy[i];
                x = u.x + cx[i];
                if (!isRange(y,x) || (y == king.y && x == king.x))
                    continue;

                y = u.y + dy[i];
                x = u.x + dx[i];
                if (!isRange(y,x) || visited[y][x])
                    continue;
                track[y][x][0] = u.y;
                track[y][x][1] = u.x;
                q.add(new Piece(y, x, u.count + 1));
                visited[y][x] = true;
            }
        }
        return -1;
    }
}
