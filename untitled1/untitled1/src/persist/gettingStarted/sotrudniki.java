package persist.gettingStarted;

public class sotrudniki extends prodazhi {
    private static final Object ONE_TO_MANY = null;
    private final int prodazhi_kodSotrudnika;
    @PrimaryKey(sequence="kodStrani")

    private int kodSotrudnuka;
    private String familia;
    private String imya;
    private String otchestvo;
    private String telephone;
    private String adr;


    @SecondaryKey(relate=ONE_TO_MANY, relatedEntity=prodazhi.class, name="kodSotrudnuka")
    private int prodazhi_client;
    private sotrudniki(int prodazhi_kodSotrudnika) {
        this.prodazhi_kodSotrudnika = prodazhi_kodSotrudnika;
    }
    public sotrudniki(int kodSotrudnuka,String familia, String imya,
                   String otchestvo, String adr,
                   String telephone, int prodazhi_kodSotrudnika) {
        super();
        this.kodSotrudnuka = kodSotrudnuka;
        this.familia = familia;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.adr = adr;
        this.telephone = telephone;
        this.prodazhi_kodSotrudnika = prodazhi_kodSotrudnika;
    }
}
