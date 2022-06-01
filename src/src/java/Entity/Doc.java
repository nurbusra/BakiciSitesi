package Entity;

/**
 *
 * @author Merve
 */
public class Doc {

    private int doc_id;
    private String doc_path;
    
    //Controller
    public Doc() {
        
    }
    
    //Create
    public Doc(String doc_path) {
        this.doc_path = doc_path;
    }
    
    //Retrieve
    public Doc(int doc_id, String doc_path) {
        this.doc_id = doc_id;
        this.doc_path = doc_path;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getDoc_path() {
        return doc_path;
    }

    public void setDoc_path(String doc_path) {
        this.doc_path = doc_path;
    }   
}
