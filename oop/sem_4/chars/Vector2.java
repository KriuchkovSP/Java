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
    public double getDistance(Vector2 pos_unit2){
        return Math.sqrt((Math.pow(this.x - pos_unit2.x, 2)) + (Math.pow(this.y - pos_unit2.y, 2)));
    }
}