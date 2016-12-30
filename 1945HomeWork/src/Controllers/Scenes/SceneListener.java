package Controllers.Scenes;

/**
 * Created by QuanLA on 12/28/2016.
 */
public interface SceneListener {
    void replaceScene(GameScene newScene, boolean addToBackStack);
    void back();
}
