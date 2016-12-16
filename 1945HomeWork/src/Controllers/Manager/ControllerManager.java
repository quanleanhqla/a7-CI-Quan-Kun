package Controllers.Manager;

import Controllers.Controller;
import Models.Model;
import Views.View;

import java.awt.*;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Created by QuanLA on 12/11/2016.
 */
public class ControllerManager  {
    protected Vector<Controller> controllers;


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
            if(!controller.getModel().isAlive()){
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
