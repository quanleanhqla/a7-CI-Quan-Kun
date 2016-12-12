package Controllers.Manager;

import Controllers.Controller;
import Controllers.PlaneEnemyController;

import java.util.Vector;

/**
 * Created by QuanLA on 12/11/2016.
 */
public class PlaneEnemyControllerManager extends ControllerManager {

    int timeCounter = 0;

    public void run(){
        timeCounter++;
        super.run();
        if(timeCounter > 90) {
            spawn();
            timeCounter = 0;
        }
        destroy();
    }

    public void spawn(){
        PlaneEnemyController planeEnemyController = PlaneEnemyController.createPlaneE(800, 0, "resources/enemy-green-2.png");
        this.controllers.add(planeEnemyController);
    }

    public void destroy(){
        for(Controller controller : this.controllers){
            if(controller.getModel().getX() < 0 || controller.getModel().getY() > 600){
                this.controllers.remove(controller);
            }
        }
    }

}
