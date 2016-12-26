package Controllers;

import Controllers.Enemies.PlaneEnemyController;
import Controllers.Manager.BodyManager;
import Models.Model;
import Views.BaseView;
import Views.View;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class BulletController extends Controller implements Body, BaseController {

    public BulletController(Model model, View baseView) {
        super(model, baseView);
        BodyManager.instance.register(this);
    }

    public void run(){
        this.model.move(0, -5);
    }


    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneEnemyController || this.getModel().getY() < -50) {
            System.out.println("Oh year");
            this.model.setAlive(false);
            //((PlaneEnemyController)other).destroy();
        }
    }

}
