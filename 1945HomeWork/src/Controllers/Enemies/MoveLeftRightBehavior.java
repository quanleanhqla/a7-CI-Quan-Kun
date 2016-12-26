package Controllers.Enemies;

/**
 * Created by QuanLA on 12/21/2016.
 */
public class MoveLeftRightBehavior implements MoveBehavevior {
    @Override
    public void doMove(PlaneEnemyController planeEnemyController) {
        planeEnemyController.getModel().move(2, 2);
    }
}
