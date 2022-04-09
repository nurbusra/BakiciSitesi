package Entity;


public class Kazanc {

    private int id;
    private int alisveris_id;
    private String config;
    private boolean referans;

    public Kazanc() {
    }

    public Kazanc(int id, int alisveris_id, String config, boolean referans) {
        this.id = id;
        this.alisveris_id = alisveris_id;
        this.config = config;
        this.referans = referans;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Kazanc{" + "id=" + id + ", alisveri_id=" + alisveris_id + ", config=" + config + ", referans=" +referans+'}';
    }

}
