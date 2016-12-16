package Controllers;

import Controllers.Manager.BodyManager;
import Models.Model;
import Utils.Utils;
import Views.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class PlaneController extends Controller implements Body {
    private Vector<BulletController> bulletControllers;
    private KeySetting keySetting;

    public PlaneController(Model model, View view, KeySetting keySetting) {
        super(model, view);
        this.keySetting = keySetting;
        bulletControllers = new Vector<>();
        BodyManager.instance.register(this);
    }

    public void keyPressed(KeyEvent e){
        if(keySetting != null){
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()){
                model.move(0, -5);
            }
            if(keyCode == keySetting.getKeyDown()){
                model.move(0, 5);
            }
            if(keyCode == keySetting.getKeyLeft()){
                model.move(-5, 0);
            }
            if(keyCode == keySetting.getKeyRight()){
                model.move(5, 0);
            }
            if(keyCode == keySetting.getKeyFire()){
                BulletController bulletController = new BulletController(new Model(this.model.getX() + 35 -6, this.model.getY() -15, 12, 30), new View(Utils.loadImage("resources/bullet.png"))  );
                bulletControllers.add(bulletController);
            }
        }
    }

    public KeySetting getKeySetting() {
        return keySetting;
    }

    public void setKeySetting(KeySetting keySetting) {
        this.keySetting = keySetting;
    }

    public static PlaneController createPlane(int x, int y, String path, KeySetting keySetting){
        PlaneController planeController = new PlaneController(new Model(x, y, 70, 50), new View(Utils.loadImage(path)), keySetting);
        return planeController;
    }

    public void run(){
        Iterator<BulletController> bulletControllerIterator = this.bulletControllers.iterator();
        for(BulletController bulletController : this.bulletControllers){
            bulletController.run();
        }
        while (bulletControllerIterator.hasNext()){
            BulletController bulletController = bulletControllerIterator.next();
            if(!bulletController.getModel().isAlive()) bulletControllerIterator.remove();
        }
    }

    public void draw(Graphics g){
        super.draw(g);
        for(BulletController bulletController : this.bulletControllers){
            bulletController.draw(g);
        }
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletEnemyController){
            System.out.println("Oh Shit");
            this.getModel().setAlive(false);
            BodyManager.instance.remove(other);
        }
    }
}
