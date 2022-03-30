package Entity;

import java.sql.Timestamp;

public class Config {

    private String option;
    private String value;
    private Timestamp created;
    private Timestamp updated;

    public Config() {
    }

    public Config(String option, String value, Timestamp created, Timestamp updated) {
        this.option = option;
        this.value = value;
        this.created = created;
        this.updated = updated;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Config{" + "option=" + option + ", value=" + value + ",created= " + created + ",updated= " + '}';
    }

}
