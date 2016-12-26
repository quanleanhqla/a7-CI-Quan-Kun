package Controllers.Enemies;

import Controllers.PlaneController;

/**
 * Created by QuanLA on 12/21/2016.
 */
public class ShootChaseBehavior implements ShootBehavior {
    @Override
    public void doShoot(BulletEnemyController bulletEnemyController) {
        int x = PlaneController.instance.getModel().getX();
        int y = PlaneController.instance.getModel().getY();
        if(x > bulletEnemyController.getModel().getX()) bulletEnemyController.getModel().move(5, 0);
        if(x < bulletEnemyController.getModel().getX()) bulletEnemyController.getModel().move(-5, 0);
        if(y > bulletEnemyController.getModel().getY()) bulletEnemyController.getModel().move(0, 5);
        if(y < bulletEnemyController.getModel().getY()) bulletEnemyController.getModel().move(0, -5);
    }


}
