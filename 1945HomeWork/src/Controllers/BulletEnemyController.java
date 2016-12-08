package Controllers;

import Models.Model;
import Utils.Utils;
import Views.View;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class BulletEnemyController extends Controller {
    public BulletEnemyController() {
    }

    public BulletEnemyController(Model model, View view) {
        super(model, view);
    }

    public void run(){
        this.model.move(0, 5);
    }

    public static BulletEnemyController createBulletE(int x, int y){
        BulletEnemyController bulletEnemyController = new BulletEnemyController(new Model(x, y, 20, 50), new View(Utils.loadImage("resources/enemy_bullet.png")));
        return bulletEnemyController;
    }
}
