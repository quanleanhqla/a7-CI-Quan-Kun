package Controllers.Scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by QuanLA on 12/28/2016.
 */
public abstract class GameScene {

    protected SceneListener sceneListener;

    public GameScene(){

    }

    public GameScene(SceneListener sceneListener) {
        this.sceneListener = sceneListener;
    }

    public void setSceneListener(SceneListener sceneListener) {
        this.sceneListener = sceneListener;
    }

    public abstract void update(Graphics g);
    public abstract void run();
    public abstract void keyPressed(KeyEvent e);
}
