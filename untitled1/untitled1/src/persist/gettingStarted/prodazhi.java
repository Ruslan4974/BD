package persist.gettingStarted;


import javax.xml.crypto.Data;
import java.util.ArrayList;

@Entity
public class prodazhi extends auto {
    private static final Object MANY_TO_ONE = null;
    private final int Sotrudnika_kodSotrudnika;
    @PrimaryKey(sequence="kodProdazhi")

    private int kodProdazhi;
    private int kodAuto;
    private int client;
    private Data dataProdazhi;
    private int kodSotrudnika;


    @SecondaryKey(relate=MANY_TO_ONE, relatedEntity=clients.class, name="kodClients")

    private int prodazhi_kodMashini;
    prodazhi() {  }
    public prodazhi(int kodProdazhi,int kodAuto, int client,
                   Data dataProdazhi, int kodSotrudnika, int Sotrudnika_kodSotrudnika) {
        this.kodProdazhi = kodProdazhi;
        this.kodAuto = kodAuto;
        this.client = client;
        this.dataProdazhi = dataProdazhi;
        this.kodSotrudnika = kodSotrudnika;
        this.Sotrudnika_kodSotrudnika = Sotrudnika_kodSotrudnika;
    }

    public <E> prodazhi(int i, ArrayList<E> es, int i1, boolean nextBoolean) {
    }

    public int getId() {
    }
}