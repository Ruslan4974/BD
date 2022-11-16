package persist.gettingStarted;

public class stranaProizvod extends auto {
    private static final Object MANY_TO_ONE = null;
    private final int auto_kodAuto;

    @PrimaryKey(sequence="kodStrani")

    private int kodStrani;
    private String strana;
    private String gorod;
    private String autoMarka;

    @SecondaryKey(relate=MANY_TO_ONE, relatedEntity=auto.class, name="kodAuto")
    private int prodazhi_client;
    private stranaProizvod(int prodazhi_kodSotrudnika, int auto_kodAuto) {
        super();
        this.auto_kodAuto = auto_kodAuto;
    }
    public stranaProizvod(int kodStrani,String strana, String gorod,
                      String autoMarka, int auto_kodAuto) {

        this.kodStrani = kodStrani;
        this.strana = strana;
        this.gorod = gorod;
        this.autoMarka = autoMarka;
        this.auto_kodAuto = auto_kodAuto;
    }
}
