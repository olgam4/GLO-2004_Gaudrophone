package logique;

public interface Playable  {

    void playOnce();
    
    void start();    
    
    void stop();
    
    String getInstrumentName();
    
    long getPersistance();
    
    void setPersistance(long persistance);
}
