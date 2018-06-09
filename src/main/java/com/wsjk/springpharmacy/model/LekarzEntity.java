package com.wsjk.springpharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "LEKARZ", schema = "", catalog = "")
public class LekarzEntity implements Serializable {
    private Integer id;
    private String imie;
    private String nazwisko;
    private String miasto;
    private NfzEntity nfzByIdNfz;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IMIE")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "NAZWISKO")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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
        LekarzEntity that = (LekarzEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(miasto, that.miasto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, imie, nazwisko, miasto);
    }

    @ManyToOne
    @JoinColumn(name = "ID_NFZ", referencedColumnName = "ID")
    public NfzEntity getNfzByIdNfz() {
        return nfzByIdNfz;
    }

    public void setNfzByIdNfz(NfzEntity nfzByIdNfz) {
        this.nfzByIdNfz = nfzByIdNfz;
    }

   }
