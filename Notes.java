package Notes.com.example.Notesdemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity(name="Notes")
public class Notes {


    @Id
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="Content")
    private String content;

    @Column(name="important")
    private Boolean important;
    @Column(name="User_id")
    private  int userId;
    @Column(name="Created_Date")
    private Date created_date;

    @Column(name="Updated_Date")
    private  Date updated_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public int getUserId() {
        return userId;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Notes() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notes notes = (Notes) o;
        return id == notes.id && userId == notes.userId && Objects.equals(title, notes.title) && Objects.equals(content, notes.content) && Objects.equals(important, notes.important) && Objects.equals(created_date, notes.created_date) && Objects.equals(updated_date, notes.updated_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, important, userId, created_date, updated_date);
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", important=" + important +
                ", user_id=" + userId +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                '}';
    }
}
