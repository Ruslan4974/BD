package persist.gettingStarted;

public class EntityStore {
    public EntityStore(Environment environment, String entityStore, StoreConfig storeConfig) {
    }

    public PrimaryIndex<Integer, auto> getPrimaryIndex(Class<Integer> integerClass, Class<prodazhi> customerClass) {
    }

    public PrimaryIndex<Integer, auto> getPrimaryIndex(Class<Integer> integerClass, Class<auto> autoClass) {
    }

    public SecondaryIndex<Integer,Integer,prodazhi> getSecondaryIndex(PrimaryIndex<Integer, prodazhi> id, Class<Integer> integerClass, String customer) {
    }
}
