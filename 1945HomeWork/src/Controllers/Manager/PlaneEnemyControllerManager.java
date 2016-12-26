package Controllers.Manager;

import Controllers.BaseController;
import Controllers.Enemies.PlaneEnemyController;
import Controllers.Enemies.PlaneEnemyType;
import Controllers.PlaneController;

/**
 * Created by QuanLA on 12/11/2016.
 */
public class PlaneEnemyControllerManager extends ControllerManager implements BaseController {

    int enemyCount =0;

    int timeCounter = 0;

    public void run(){
        super.run();
        timeCounter++;
        if(timeCounter > 90) {
            spawn();
            timeCounter = 0;
        }
    }

    public void spawn(){
        enemyCount++;
        if(enemyCount%4 == 0) {
            PlaneEnemyController planeEnemyController = PlaneEnemyController.createPlaneE(300, 0, "resources/enemy-green-1.png", PlaneEnemyType.GREEN);
            this.controllers.add(planeEnemyController);
        }
        else if(enemyCount%4 == 1){
            PlaneEnemyController planeEnemyController = PlaneEnemyController.createPlaneE(50, 0, "resources/enemy_plane_yellow_1.png", PlaneEnemyType.BROWN);
            this.controllers.add(planeEnemyController);
        }
        else if(enemyCount%4 == 2){
            PlaneEnemyController planeEnemyController = PlaneEnemyController.createPlaneE(500 , 10, "resources/enemy-green-1.png", PlaneEnemyType.BLACK );
            this.controllers.add(planeEnemyController);
        }
        else if(enemyCount%4 == 3){
            PlaneEnemyController planeEnemyController = PlaneEnemyController.createPlaneE(500 , 10, "resources/enemy-green-1.png", PlaneEnemyType.WHITE );
            this.controllers.add(planeEnemyController);
        }
    }



}
