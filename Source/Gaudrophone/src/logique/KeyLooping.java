package logique;

public class KeyLooping {

    private Key key;
    private long offset;
    private long currentTime;

    public KeyLooping(Key key, long offset, long currentTime) {
        this.key = key;
        this.offset = offset;
        this.currentTime = currentTime;
    }

    public KeyLooping(long offset) {
        this.key = null;
        this.offset = offset;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

}
