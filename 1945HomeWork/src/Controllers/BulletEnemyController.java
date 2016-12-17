package Controllers;

import Controllers.Manager.BodyManager;
import Models.Model;
import Utils.Utils;
import Views.View;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class BulletEnemyController extends Controller implements Body {
    public BulletEnemyController() {
    }

    public BulletEnemyController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run(){
        this.model.move(0, 5);
    }

    public static BulletEnemyController createBulletE(int x, int y){
        BulletEnemyController bulletEnemyController = new BulletEnemyController(new Model(x, y, 20, 50), new View(Utils.loadImage("resources/enemy_bullet.png")));
        return bulletEnemyController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController) {
            System.out.println("Ah aaa");
            this.getModel().setAlive(false);
            BodyManager.instance.remove(this);
        }
    }
}
