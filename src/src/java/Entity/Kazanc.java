package Entity;


public class Kazanc {

    private int kazanc_id;
    private int alisveris_id;
    private String config;
    private boolean referans;

    public Kazanc() {
    }

    public Kazanc(int kazanc_id, int alisveris_id, String config, boolean referans) {
        this.kazanc_id = kazanc_id;
        this.alisveris_id = alisveris_id;
        this.config = config;
        this.referans = referans;
       
    }

    public int getKazanc_id() {
        return kazanc_id;
    }

    public void setKazanc_id(int kazanc_id) {
        this.kazanc_id = kazanc_id;
    }

    

    public int getAlisveris_id() {
        return alisveris_id;
    }

    public void setAlisveris_id(int alisveris_id) {
        this.alisveris_id = alisveris_id;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }


    public boolean isReferans() {
        return referans;
    }

    public void setReferans(boolean referans) {
        this.referans = referans;
    }

    @Override
    public String toString() {
        return "Kazanc{" + "kazanc_id=" + kazanc_id + ", alisveri_id=" + alisveris_id + ", config=" + config + ", referans=" +referans+'}';
    }

}
