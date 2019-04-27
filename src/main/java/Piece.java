import lombok.Data;

@Data
class Piece {
    public int y, x, count;
    public Piece(int y, int x, int count) {
        if(x < 0 || y < 0)
            throw new IllegalArgumentException();
        this.y = y;
        this.x = x;
        this.count = count;
    }
}
