package Models;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class BulletModel {
    private int x;
    private int y;

    public BulletModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy){
        this.x+=dx;
        this.y+=dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
