package net.outmoded.fastListenerRegistration;

public class EventListenerRegister {
    
    private static EventListenerRegister instance;
    
    private EventListenerRegister() {}
    
    public static synchronized EventListenerRegister getInstance() {
        if (instance == null) {
            instance = new EventListenerRegister();
        }
        return instance;
    }
}
