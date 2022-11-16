package persist.gettingStarted;

public @interface SecondaryKey {
    String name();

    Class<prodazhi> relatedEntity();
}
