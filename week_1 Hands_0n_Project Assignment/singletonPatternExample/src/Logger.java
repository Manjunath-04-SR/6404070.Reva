/**
 * Logger.java
 * Implements the Singleton Design Pattern.
 */
public class Logger {

    // Single private static instance
    private static Logger singleInstance = null;

    // Private constructor prevents external instantiation
    private Logger() {
        System.out.println("Logger Initialized");
    }

    // Public static method to get the single instance
    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    // Utility logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
