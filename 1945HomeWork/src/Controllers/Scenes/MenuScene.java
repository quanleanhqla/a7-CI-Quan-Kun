package Controllers.Scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by QuanLA on 12/28/2016.
 */
public class MenuScene extends GameScene {


    public MenuScene() {

    }

    @Override
    public void update(Graphics g) {

    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(new PlayGameScene(), true);
    }

}
