package Controllers.Enemies;

import Controllers.PlaneController;

/**
 * Created by QuanLA on 12/21/2016.
 */
public class ShootStraightDownBehavior implements ShootBehavior {
    @Override
    public void doShoot(BulletEnemyController bulletEnemyController) {
        bulletEnemyController.getModel().move(0, 5);
    }


}
