package persist.gettingStarted;



@Entity
public class auto extends BaseClass{
    private static final Object ONE_TO_MANY = null;
    @PrimaryKey(sequence="kodAuto")

    private int kodAuto;
    private String marka;
    private String model;
    private String strana;
    private String cvet;
    private float cenaOpt;
    private float cenaRoz;

    @SecondaryKey(relate=ONE_TO_MANY, relatedEntity=prodazhi.class, name="kodAuto")
    private int prodazhi_kodAuto;
    auto() {  }
    public auto(int prodazhi_kodkodAuto,int kodAuto, String marka, String model, String strana, String cvet, float cenaOpt, float cenaRoz) {
        this.kodAuto = kodAuto;
        this.marka = marka;
        this.model = model;
        this.strana = strana;
        this.cvet = cvet;
        this.cenaOpt = cenaOpt;
        this.cenaRoz = cenaRoz;
        this.prodazhi_kodAuto = prodazhi_kodAuto;
    }}