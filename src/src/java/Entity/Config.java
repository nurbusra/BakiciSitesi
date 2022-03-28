
package Entity;

public class Config {
    private String option;
    private String value;

    public Config(String option, String value) {
        this.option = option;
        this.value = value;
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
    @Override
     public String toString() {
        return "Config{" + "option=" + option + ", value=" + value + '}';
    }
    
}
