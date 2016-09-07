package org.osanchezhuerta.angularjs.web.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;


/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 *
 */

public class Post implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public enum Status {
        DRAFT,
        PUBLISHED
    }


    private Long id;
    private String title;
    private String content;
    
    private Status status = Status.DRAFT;

    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public void prePersist() {
        this.createdDate = new Date();
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", title=" + title + ", content=" + content + ", status=" + status + '}';
    }

}
