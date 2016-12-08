package Controllers;

import Models.Model;
import Views.View;

import java.awt.*;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class Controller {
    protected Model model;
    protected View view;

    public Controller() {
    }

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void draw(Graphics g){
        view.draw(g, model);
    }
}
