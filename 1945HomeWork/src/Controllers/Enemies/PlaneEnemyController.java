package Controllers.Enemies;

import Controllers.*;
import Controllers.Gifts.Bomb;
import Controllers.Manager.BodyManager;
import Controllers.Manager.ControllerManager;
import Controllers.Notifications.EventSubcriber;
import Controllers.Notifications.EventType;
import Controllers.Notifications.NotificationCenter;
import Models.Model;
import Utils.Utils;
import Views.Animation;
import Views.BaseView;
import Views.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by QuanLA on 12/8/2016.
 */



public class PlaneEnemyController extends Controller implements Body, BaseController, EventSubcriber {
    private Vector<BulletEnemyController> bulletE;
    private MoveBehavevior moveBehavevior;
    private ShootBehavior shootBehavior;
    private int timeCounter = 0;

    public PlaneEnemyController(Model model, BaseView baseView, MoveBehavevior moveBehavevior, ShootBehavior shootBehavior) {
        super(model, baseView);
        bulletE = new Vector<>();
        BodyManager.instance.register(this);
        this.moveBehavevior = moveBehavevior;
        this.shootBehavior = shootBehavior;
        NotificationCenter.instance.register(this);
    }

    public void draw(Graphics g){
        super.draw(g);
        for(int i = 0; i< bulletE.size(); i++){
            bulletE.get(i).draw(g);
        }
    }

    public void shoot(){
        BulletEnemyController bulletEnemyController = BulletEnemyController.createBulletE(this.getModel().getX() + this.model.getWidth()/2 - 10, this.model.getY()+ this.model.getHeight(), shootBehavior);
        this.bulletE.add(bulletEnemyController);
    }


    public void run(){
        if(moveBehavevior!=null){
            moveBehavevior.doMove(this);
        }
        super.run();
        timeCounter++;
        if(timeCounter > 30) {
            shoot();
            timeCounter = 0;
        }

        for(int i=0; i<bulletE.size(); i++){
            bulletE.get(i).run();
            if(!bulletE.get(i).getModel().isAlive() || bulletE.get(i).getModel().getY() > 600){
                bulletE.remove(i);
            }
        }
    }

    public static PlaneEnemyController createPlaneE(int x, int y, String path, PlaneEnemyType type){
        switch (type){
            case BROWN:
                return new PlaneEnemyController(new Model(x, y, 70, 30), new View(Utils.loadImage(path)), new MoveStraightDownBehavior(), new ShootStraightDownBehavior());
            case GREEN:
                return new PlaneEnemyController(new Model(x, y, 70, 30), new View(Utils.loadImage(path)), new MoveLeftRightBehavior(), new ShootStraightDownBehavior());
            case WHITE:
                return new PlaneEnemyController(new Model(x, y, 70, 30), new View(Utils.loadImage(path)), new MoveZigZacBehavior(), new ShootStraightDownBehavior());
            case BLACK:
                Vector<BufferedImage> bufferedImages = new Vector<>();
                bufferedImages.add(Utils.loadImage("resources/enemy_plane_white_1.png"));
                bufferedImages.add(Utils.loadImage("resources/enemy_plane_white_2.png"));
                bufferedImages.add(Utils.loadImage("resources/enemy_plane_white_3.png"));
                return new PlaneEnemyController(new Model(x, y, 70, 30), new Animation(bufferedImages), new MoveStraightDownBehavior(), new ShootStraightDownBehavior());
            default:
                return null;
        }
    }


    @Override
    public void onContact(Body other) {
        if(other instanceof BulletController ) {
            System.out.println("Hu hu");
           this.model.setHp(this.model.getHp() - 1);
            Utils.playSound("resources/Hit_Hurt31.wav", false);
           if(this.model.getHp()  < 1) {
               this.model.setAlive(false);
               Utils.playSound("resources/Explosion33.wav", false);
               this.destroy();
               Bomb bomb = Bomb.create(model.getX(), model.getY());
               ControllerManager.explosion.add(bomb);
           }
        }
    }

    public void destroy(){
        ExplosionController explosionController = new ExplosionController(new Model(this.getModel().getX(), this.getModel().getY(), 70, 70), new Animation(Utils.loadSpriteSheet("resources/explosion.png", 32, 32, 6 ,1)));
        ControllerManager.explosion.add(explosionController);
        this.model.setAlive(false);
    }

    @Override
    public void onEvent(EventType eventType, Object params) {
        switch (eventType){
            case BOMB_EXPLOSION:
                this.destroy();
                break;
        }
    }
}
