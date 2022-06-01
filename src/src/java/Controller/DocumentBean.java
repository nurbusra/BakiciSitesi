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

    private Doc document;
    private List<Doc> documentList;
    private DocDAO documentDao;
    private Part doc;

    private final String uploadTo = "/admin/document/";

    public DocumentBean() {
    }

    public void upload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Doc getDocument() {
        if (this.document == null) {
            this.document = new Doc();
        }
        return document;
    }

    public void setDocument(Doc document) {
        this.document = document;
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

}
