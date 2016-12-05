package Controllers;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class KeySetting {
    private int keyUp;
    private int keyDown;
    private int keyLeft;
    private int keyRight;

    public KeySetting(int keyUp, int keyDown, int keyLeft, int keyRight) {
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
    }

    public int getKeyUp() {
        return keyUp;
    }

    public int getKeyDown() {
        return keyDown;
    }

    public int getKeyLeft() {
        return keyLeft;
    }

    public int getKeyRight() {
        return keyRight;
    }

}
