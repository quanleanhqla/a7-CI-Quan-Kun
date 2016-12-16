package Controllers;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class KeySetting {
    private int keyUp;
    private int keyDown;
    private int keyLeft;
    private int keyRight;
    private int keyFire;

    public KeySetting(int keyUp, int keyDown, int keyLeft, int keyRight, int keyFire) {
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyFire = keyFire;
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

    public int getKeyFire() { return keyFire; }

}
