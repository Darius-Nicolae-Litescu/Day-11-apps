package darius.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Document implements Serializable {
    @Column(name = "document_name")
    private String documentName;
    @Column(name = "document_number")
    private String documentNumber;

    public Document() {
    }

    public Document(String documentName, String documentNumber) {
        this.documentName = documentName;
        this.documentNumber = documentNumber;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(documentName, document.documentName) && Objects.equals(documentNumber, document.documentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentName, documentNumber);
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentName='" + documentName + '\'' +
                ", documentNumber=" + documentNumber +
                '}';
    }
}

