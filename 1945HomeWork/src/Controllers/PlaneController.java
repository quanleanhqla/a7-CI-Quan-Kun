package Controllers;

import Controllers.Enemies.BulletEnemyController;
import Controllers.Enemies.PlaneEnemyController;
import Controllers.Manager.BodyManager;
import Controllers.Manager.ControllerManager;
import Models.Model;
import Utils.Utils;
import Views.Animation;
import Views.BaseView;
import Views.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class PlaneController extends Controller implements Body, BaseController {
    private Vector<BulletController> bulletControllers;
    private KeySetting keySetting;
    private int time;
    private int live;
    public static final PlaneController instance = new PlaneController(new Model(300, 300, 70, 50), new View(Utils.loadImage("resources/plane3.png")), new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE));

    private PlaneController(Model model, View baseView, KeySetting keySetting) {
        super(model, baseView);
        this.keySetting = keySetting;
        bulletControllers = new Vector<>();
        BodyManager.instance.register(this);
        time = 0;
        this.live = 3;
    }

    public void keyPressed(KeyEvent e){
        if(keySetting != null){
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()){
                if(this.getModel().isAlive()) model.move(0, -5);
            }
            if(keyCode == keySetting.getKeyDown()){
                if(this.getModel().isAlive()) model.move(0, 5);
            }
            if(keyCode == keySetting.getKeyLeft()){
                if(this.getModel().isAlive()) model.move(-5, 0);
            }
            if(keyCode == keySetting.getKeyRight()){
                if(this.getModel().isAlive()) model.move(5, 0);
            }
            if(keyCode == keySetting.getKeyFire()){
                if(this.getModel().isAlive()) {
                    BulletController bulletController = new BulletController(new Model(this.model.getX() + 35 - 6, this.model.getY() - 15, 12, 30), new View(Utils.loadImage("resources/bullet.png")));
                    bulletControllers.add(bulletController);
                    Utils.playSound("resources/Laser_Shoot.wav", false);
                }
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
        super.run();
        if(!this.getModel().isAlive()){
            time++;
            if(time > 150){
                if(this.getLive() > 0) {
                    this.getModel().setAlive(true);
                    this.getModel().setHp(3);
                    BodyManager.instance.register(this);
                    time = 0;
                }
            }
        }
        Iterator<BulletController> bulletControllerIterator = this.bulletControllers.iterator();
        for(BulletController bulletController : this.bulletControllers){
            bulletController.run();
        }
        while (bulletControllerIterator.hasNext()){
            BulletController bulletController = bulletControllerIterator.next();
            if(!bulletController.getModel().isAlive()||bulletController.getModel().getY() < 0) bulletControllerIterator.remove();
        }
    }

    public void draw(Graphics g){
        if(this.model.isAlive()) super.draw(g);
        for(BulletController bulletController : this.bulletControllers){
            bulletController.draw(g);
        }
        g.setFont(new Font("Forte", Font.BOLD, 35));
        g.setColor(Color.ORANGE);
        g.drawString(String.valueOf(this.getLive()), 700, 70);
        g.drawImage(Utils.loadImage("resources/heart.png"), 730, 40, 35, 35, null);


    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public void destroy(){
        ExplosionController explosionController = new ExplosionController(new Model(PlaneController.instance.getModel().getX(), PlaneController.instance.getModel().getY(), 70, 70), new Animation(Utils.loadSpriteSheet("resources/explosion.png", 32, 32, 6 ,1)));
        ControllerManager.explosion.add(explosionController);
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletEnemyController){
            System.out.println("Oh Shit");
            this.model.setHp(this.model.getHp() -  1);
            Utils.playSound("resources/Hit_Hurt33.wav", false);
            if(this.model.getHp() < 1){
                this.model.setAlive(false);
                BodyManager.instance.remove(this);
                Utils.playSound("resources/Explosion30.wav", false);
                this.setLive(this.getLive() - 1);
                this.destroy();
            }
        }
    }
}
