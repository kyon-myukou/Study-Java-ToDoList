package com.kyon.todolist.Database;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "todos")
public class DbTodo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String comment;
    private Boolean state;
    private Date creationDt;
    private Date deadlineDt;

    //getter and setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Boolean getState() {
        return state;
    }
    public void setState(Boolean state) {
        this.state = state;
    }
    public Date getCreationDt() {
        return creationDt;
    }
    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }
    public Date getDeadlineDt() {
        return deadlineDt;
    }
    public void setDeadlineDt(Date deadlineDt) {
        this.deadlineDt = deadlineDt;
    }
}
