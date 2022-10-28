package persist.gettingStarted;


@Entity
public class clients {
    private static final Object ONE_TO_MANY = null;
    @PrimaryKey(sequence="kodProdazhi")

    private int kodClient;
    private String familia;
    private String imya;
    private String otchestvo;
    private String adr;
    private String telephone;


    @SecondaryKey(relate=ONE_TO_MANY, relatedEntity=prodazhi.class, name="client")
    private int prodazhi_client;
    private clients() {  }
    public clients(int kodClient,String familia, String imya,
                   String otchestvo, String adr,
                   String telephone, int prodazhi_client) {
        this.kodClient = kodClient;
        this.familia = familia;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.adr = adr;
        this.telephone = telephone;
        this.prodazhi_client = prodazhi_client;
    }
}
