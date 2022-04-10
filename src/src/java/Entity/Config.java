package Entity;

public class Config {

    private String _option;
    private String _value;

    // Controller Sınıfının Kullanacağı Constructor
    public Config() {
    }

    public Config(String _option, String _value) {
        this._option = _option;
        this._value = _value;
    }

    public Config(String _value) {
        this._value = _value;
    }

    public String _getOption() {
        return _option;
    }

    public void _setOption(String option) {
        this._option = option;
    }

    public String _getValue() {
        return _value;
    }

    public void _setValue(String value) {
        this._value = value;
    }

    @Override
    public String toString() {
        return "Config{" + "_option=" + this._getOption() + "_value=" + this._getValue() + '}';
    }

}
