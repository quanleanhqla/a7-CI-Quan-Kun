package Controllers.Notifications;

import java.util.Vector;

/**
 * Created by QuanLA on 12/28/2016.
 */
public class NotificationCenter {
    private Vector<EventSubcriber> subcribers;

    public final static NotificationCenter instance = new NotificationCenter();

    private NotificationCenter() {
        this.subcribers = new Vector<>();
    }

    public void register(EventSubcriber subcriber){
        this.subcribers.add(subcriber);
    }

    public void unregister(EventSubcriber subcriber){
        this.subcribers.remove(subcriber);
    }

    public void onEvent(EventType eventType, Object params){
        for(EventSubcriber subcriber : subcribers){
            subcriber.onEvent(eventType, params);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
