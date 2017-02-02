import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rudolf on 1.02.2017.
 */
public class Kuluarvestaja {
    int palk;
    int suurimaKuluIndeks = 0;
    int suurimKulu = 0;
    int kuludKokku = 0;

    ArrayList<String> kulunimi = new ArrayList<>();
    ArrayList<String> kulusuurus = new ArrayList<>();

    Kuluarvestaja(){}

    void setPalk(int palk){
        this.palk = palk;
    }
    String sisestaKulu(String nimi, String suurus) {
        if (Integer.parseInt(suurus) > palk) {
            return "Kulu on suurem kui allesjäänud palk!";
        } else {
            kulunimi.add(nimi);
            kulusuurus.add(suurus);
            palk -= Integer.parseInt(suurus);
            return "Kulu sisestatud!";
        }
    }

    String kulu() {
        kuludKokku = 0;
        suurimaKuluIndeks = 0;
        for (int i = 0; i < kulunimi.size(); i++) {
            kuludKokku += Integer.parseInt(kulusuurus.get(i));
            if (Integer.parseInt(kulusuurus.get(i)) > suurimKulu) {
                suurimaKuluIndeks = i;
                suurimKulu = Integer.parseInt(kulusuurus.get(i));
            }
        }
        String suurimKuluString = ("Suurim kulu seni: " + kulunimi.get(suurimaKuluIndeks) + " " + Integer.toString(suurimKulu) + ". Kulud kokku: " + kuludKokku);
        System.out.println(kulunimi);
        return suurimKuluString;

    }
    void nulliAndmed(){
        kulunimi.clear();
        kulusuurus.clear();
    }
    String pakuLoobumist(){
        int indeks = ThreadLocalRandom.current().nextInt(0, kulunimi.size());
        return "Kas äkki saaks loobuda: " + kulunimi.get(indeks) + kulusuurus.get(indeks);
    }
    }

