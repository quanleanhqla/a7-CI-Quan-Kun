package Controllers.Manager;

/**
 * Created by QuanLA on 12/24/2016.
 */
public class GameSetting {
    private int width;
    private int height;

    private GameSetting(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static final GameSetting instance = new GameSetting(800, 600);

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
}
