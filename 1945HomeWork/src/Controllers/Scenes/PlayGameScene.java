package Controllers.Scenes;

import Controllers.BaseController;
import Controllers.Manager.ControllerManager;
import Controllers.Manager.GameSetting;
import Controllers.Manager.PlaneEnemyControllerManager;
import Controllers.PlaneController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static Utils.Utils.loadImage;

/**
 * Created by QuanLA on 12/28/2016.
 */
public class PlayGameScene extends GameScene {
    Vector<BaseController> baseControllers;
    Image background;


    public PlayGameScene() {
        baseControllers = new Vector<>();
        baseControllers.add(PlaneController.instance);
        baseControllers.add(new PlaneEnemyControllerManager());
        baseControllers.add(ControllerManager.explosion);
        background =  loadImage("resources/background.png");

    }

    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
        for (BaseController baseController : this.baseControllers) {
            baseController.draw(g);
        }
    }

    @Override
    public void run() {
        for(BaseController baseController : this.baseControllers){
            baseController.run();
        }
        if(PlaneController.instance.getLive() < 1){
            this.sceneListener.replaceScene(new GameOverScene(), true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        PlaneController.instance.keyPressed(e);
    }
}
