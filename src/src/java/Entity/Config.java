package Entity;

import java.sql.Timestamp;

public class Config {

    private String _option;
    private String _value;
    private Timestamp created;
    private Timestamp updated;

    // Controller Sınıfının Kullanacağı Constructor
    public Config() {
    }

    public Config(String _option, String _value,Timestamp created,Timestamp updated) {
        this._option = _option;
        this._value = _value;
        this.created=created;
        this.updated=updated;
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
        return "Config{" + "_option=" + this._getOption() + "_value=" + this._getValue() + '}';
    }

}
