package Controllers;

import Models.Model;
import Views.View;

import java.awt.*;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class BulletController extends Controller {
    public BulletController() {
    }

    public BulletController(Model model, View view) {
        super(model, view);
    }

    public void run(){
        this.model.move(0, -5);
    }


}
