class logger{
    private static logger instance;

    private logger() {
        // private constructor to prevent instantiation
    }

    public static logger getInstance() {
        if (instance == null) {
            instance = new logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
public class SingletonPatternExample {
    public static void main(String[] args){
        logger log1 = logger.getInstance();
        logger log2 = logger.getInstance();

        log1.log("This is a singleton pattern example.");
        log2.log("Both log1 and log2 are the same instance: " + (log1 == log2));
    }
}
