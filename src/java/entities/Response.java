/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul Frinchaboy
 */
@Entity
@Table(name = "response")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Response.findAll", query = "SELECT r FROM Response r"),
    @NamedQuery(name = "Response.findById", query = "SELECT r FROM Response r WHERE r.id = :id"),
    @NamedQuery(name = "Response.findByMail", query = "SELECT r FROM Response r WHERE r.mail = :mail")})
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "value")
    private String value;
    @Size(max = 255)
    @Column(name = "mail")
    private String mail;
    @JoinColumn(name = "Choice_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Choice choiceid;
    @JoinColumn(name = "Question_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Question questionid;

    public Response() {
    }

    public Response(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Choice getChoiceid() {
        return choiceid;
    }

    public void setChoiceid(Choice choiceid) {
        this.choiceid = choiceid;
    }

    public Question getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Question questionid) {
        this.questionid = questionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Response)) {
            return false;
        }
        Response other = (Response) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Response[ id=" + id + " ]";
    }
    
}
