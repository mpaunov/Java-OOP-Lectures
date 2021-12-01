package desingPatterns.singleton;


// This is Singleton object
public class DbInstance {

    private static volatile DbInstance instance = null;

    private DbInstance() {
        // Simulate DB connection (heavy work)

        if (instance != null) {
            throw new RuntimeException("To use DbInstance call getInstance()");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DbInstance getInstance() {
        if (instance == null) {
            synchronized (DbInstance.class) {
                if (instance == null) {
                    instance = new DbInstance();
                }
            }
        }
        return instance;
    }

    public int createTable() {
        System.out.println("Table users created");
        return 1;
    }

}
