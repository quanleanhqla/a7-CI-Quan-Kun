package Controllers;

import Models.Model;

/**
 * Created by QuanLA on 12/14/2016.
 */
public interface Body { //Pure abstract
    Model getModel();
    void onContact(Body other);
}
