package com.wsjk.springpharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "NFZ", schema = "", catalog = "")
public class NfzEntity implements Serializable {
    private Integer id;
    private String nazwa;
    private String miasto;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAZWA")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "MIASTO")
    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NfzEntity nfzEntity = (NfzEntity) o;
        return Objects.equals(id, nfzEntity.id) &&
                Objects.equals(nazwa, nfzEntity.nazwa) &&
                Objects.equals(miasto, nfzEntity.miasto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nazwa, miasto);
    }
}
