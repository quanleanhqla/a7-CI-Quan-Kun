package Controllers;

import Models.Model;
import Views.Animation;
import Views.BaseView;

import java.awt.*;

/**
 * Created by QuanLA on 12/24/2016.
 */
public class ExplosionController extends Controller{
    public ExplosionController(Model model, BaseView view) {
        super(model, view);
    }

    public void draw(Graphics g){
        super.draw(g);
        Animation animation = (Animation)this.baseView;
        if(animation.isAnimationReachEnd()){
            model.setAlive(false);
        }
    }
}
