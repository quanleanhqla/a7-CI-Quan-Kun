package Controllers;

import Models.Model;
import Views.BaseView;
import Views.View;

import java.awt.*;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class Controller implements BaseController {
    protected Model model;
    protected BaseView baseView;


    public Controller(Model model, BaseView view) {
        this.model = model;
        this.baseView = view;
    }

    public void run(){};

    public Model getModel() {
        return model;
    }

    public BaseView getBaseView() {
        return baseView;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void draw(Graphics g){
        baseView.draw(g, model);
    }
}
