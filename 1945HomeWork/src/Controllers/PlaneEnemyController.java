package Controllers;

import Models.Model;
import Utils.Utils;
import Views.View;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class PlaneEnemyController extends Controller {
    public PlaneEnemyController() {
    }

    public PlaneEnemyController(Model model, View view) {
        super(model, view);
    }

    public void run(){
        this.model.move(0, 5);
    }

    public static PlaneEnemyController createPlaneE(int x, int y, String path){
        PlaneEnemyController planeEnemyController = new PlaneEnemyController(new Model(x, y, 70, 30), new View(Utils.loadImage(path)));
        return planeEnemyController;
    }
}
