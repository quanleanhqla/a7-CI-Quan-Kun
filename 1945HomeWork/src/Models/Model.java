package Models;

import java.awt.*;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isAlive ;
    private int hp;

    public Model(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isAlive = true;
        hp = 3;
    }

    public void move(int dx, int dy){
        this.x+=dx;
        this.y+=dy;
    }

    public boolean isAlive() {

        return isAlive;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRect(){
        return new Rectangle(x, y, width, height);
    }

    public boolean intersects(Model other){
        Rectangle rect1 = this.getRect();
        Rectangle react2 = other.getRect();
        return rect1.intersects(react2);
    }
}
