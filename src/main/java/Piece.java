import lombok.Data;

@Data
class Piece {
    public int y, x, count;
    public Piece(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}
