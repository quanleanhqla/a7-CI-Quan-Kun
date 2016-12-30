package Controllers.Scenes;

import Controllers.Manager.GameSetting;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by QuanLA on 12/30/2016.
 */
public class GameOverScene extends GameScene {
    @Override
    public void update(Graphics g) {
        g.drawImage(Utils.loadImage("resources/1945-logo.png"), 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.back();
    }
}
