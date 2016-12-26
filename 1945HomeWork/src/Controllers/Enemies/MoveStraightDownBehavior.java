package Controllers.Enemies;

/**
 * Created by QuanLA on 12/21/2016.
 */
public class MoveStraightDownBehavior implements MoveBehavevior {
    @Override
    public void doMove(PlaneEnemyController planeEnemyController) {
        planeEnemyController.getModel().move(0, 2);
    }
}
