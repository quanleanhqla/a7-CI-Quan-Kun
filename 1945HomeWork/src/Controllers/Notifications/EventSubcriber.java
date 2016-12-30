package Controllers.Notifications;


/**
 * Created by QuanLA on 12/28/2016.
 */
public interface EventSubcriber {
    void onEvent(EventType eventType, Object params);
}
