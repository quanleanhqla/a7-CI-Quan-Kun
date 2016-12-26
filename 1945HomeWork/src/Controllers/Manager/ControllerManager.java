package Controllers.Manager;

import Controllers.BaseController;
import Controllers.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by QuanLA on 12/11/2016.
 */
public class ControllerManager implements BaseController {
    protected Vector<Controller> controllers;

    public static final ControllerManager explosion = new ControllerManager();


    public ControllerManager() {
        this.controllers = new Vector<>();
    }

    public void draw(Graphics g){
        for(Controller controller : this.controllers){
            controller.draw(g);
        }
    }

    public void run(){
        for(Controller controller : this.controllers){
            controller.run();
        }
        Iterator<Controller> iterator = this.controllers.iterator();
        while(iterator.hasNext()){
            Controller controller = iterator.next();
            if(!controller.getModel().isAlive() || controller.getModel().getY() > 600 || controller.getModel().getX() < 0){
                iterator.remove();
            }
        }
    }

    public void add(Controller c){
        this.controllers.add(c);
    }

    public void remove(Controller c){
        this.controllers.remove(c);
    }
}
