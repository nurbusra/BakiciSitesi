package Entity;


public class Config {

    private String option;
    private String value;

    // Controller Sınıfının Kullanacağı Constructor
    public Config() {
    }

    public Config(String _option, String _value) {
        this.option = _option;
        this.value = _value;
    }

    public Config(String _value) {
        this.value = _value;
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
        return "Config{" + "_option=" + this.getOption() + "_value=" + this.getValue() + '}';
    }

}
