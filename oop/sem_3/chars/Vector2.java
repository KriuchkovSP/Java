public class Vector2 {
    public int x,y;

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean isEqual(Vector2 pos){
        if (pos.y == y & pos.x ==x) return true;
        return false;
    }
}