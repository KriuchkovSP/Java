package mechanic;

public class Coord{
    private int col;
    private int row;

    public Coord(int col, int row) {
        super();
        this.col = col;
        this.row = row;
    }
    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
}