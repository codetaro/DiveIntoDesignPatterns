package creational.singleton;

/**
 * 采用延迟加载的线程安全单例
 */
public class Singleton {

    /**
     * the value of a volatile field becomes visible to all readers (other threads in particular)
     * after a write operation completes on it. Without volatile, readers could see some non-updated value.
     */
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    /**
     * double-checked locking (DCL) exists to prevent race condition between multiple threads
     * that may attempt to get singleton instance at the same time, creating separate instances as a result.
     */
    public static Singleton getInstance(String value) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
