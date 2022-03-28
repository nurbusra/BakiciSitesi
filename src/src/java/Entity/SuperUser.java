
package Entity;


public class SuperUser {
    private int id;

    public SuperUser(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "SuperUser{" + "id=" + id + '}';
    }
}
