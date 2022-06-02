package Controller;

/**
 *
 * @author Merve
 */
import DAO.DocDAO;
import Entity.Doc;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

@Named(value = "documentBean")
@SessionScoped
public class DocumentBean implements Serializable {

    private Doc entity;
    private List<Doc> documentList;
    private DocDAO documentDao;
    private Part doc;

    private final String uploadTo = "/Users/" + System.getProperty("user.name") + "/Desktop/upload/";

    public DocumentBean() {
    }

    public void upload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            
            this.getEntity().setDoc_path(this.uploadTo + doc.getSubmittedFileName());
            this.createEntity();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Doc getEntity() {
        if (this.entity == null) {
            this.entity = new Doc();
        }
        return entity;
    }

    public void setEntity(Doc entity) {
        this.entity = entity;
    }

    public List<Doc> getDocumentList() {
        this.documentList = this.getDocumetDao().getList();
        return documentList;
    }

    public void setDocumentList(List<Doc> documentList) {
        this.documentList = documentList;
    }

    public DocDAO getDocumetDao() {
        if (this.documentDao == null) {
            this.documentDao = new DocDAO();
        }
        return documentDao;
    }

    public void setDocumetDao(DocDAO documetDao) {
        this.documentDao = documetDao;
    }

    public DocDAO getDocumentDao() {
        if(documentDao == null) documentDao = new DocDAO();
        return documentDao;
    }

    public void setDocumentDao(DocDAO documentDao) {
        this.documentDao = documentDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
    public void createEntity() {
        this.getDocumentDao().create(entity);
    }
    
    public void deleteEntity() {
        this.getDocumentDao().delete(entity);
    }
    
    public void clear() {
        this.entity = new Doc();
    }

}