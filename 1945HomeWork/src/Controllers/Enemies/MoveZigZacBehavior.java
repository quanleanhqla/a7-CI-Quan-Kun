package Controllers.Enemies;

import Utils.Utils;

/**
 * Created by QuanLA on 12/22/2016.
 */
public class MoveZigZacBehavior implements MoveBehavevior {
    int speedx = 4;
    int speedy = 2;
    @Override
    public void doMove(PlaneEnemyController planeEnemyController) {
        planeEnemyController.getModel().move(speedx, speedy);
        if(planeEnemyController.getModel().getX() > 600){
            speedx = - speedx;
            planeEnemyController.getBaseView().setImage(Utils.loadImage("resources/enemy-green-2.png"));
        }
        else if( planeEnemyController.getModel().getX() < 300){
            speedx = -speedx;
            planeEnemyController.getBaseView().setImage((Utils.loadImage("resources/enemy-green-1.png")));
        }
    }
}
