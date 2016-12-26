package Controllers.Enemies;

import Controllers.BaseController;
import Controllers.Body;
import Controllers.Controller;
import Controllers.Manager.BodyManager;
import Controllers.PlaneController;
import Models.Model;
import Utils.Utils;
import Views.BaseView;
import Views.View;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class BulletEnemyController extends Controller implements Body, BaseController {
    private ShootBehavior shootBehavior;

    public BulletEnemyController(Model model, View baseView, ShootBehavior shootBehavior) {
        super(model, baseView);
        BodyManager.instance.register(this);
        this.shootBehavior = shootBehavior;
    }

    public void run(){
        if(shootBehavior!=null){
            shootBehavior.doShoot(this);
        }
    }

    public static BulletEnemyController createBulletE(int x, int y, ShootBehavior shootBehavior){
        BulletEnemyController bulletEnemyController = new BulletEnemyController(new Model(x, y, 20, 50), new View(Utils.loadImage("resources/enemy_bullet.png")), shootBehavior);
        return bulletEnemyController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController ) {
            System.out.println("Ah aaa");
            this.getModel().setAlive(false);
        }
    }
}
