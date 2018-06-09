package com.wsjk.springpharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "BEZ_RECEPTY", schema = "", catalog = "")
public class BezReceptyEntity implements Serializable {
    private Integer id;
    private String nazwa;
    private Boolean czyDlaDzieci;
    private BigDecimal cena;
    private String opis;
    private byte[] zdjecie;

    @Id
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
    @Column(name = "CZY_DLA_DZIECI")
    public Boolean getCzyDlaDzieci() {
        return czyDlaDzieci;
    }

    public void setCzyDlaDzieci(Boolean czyDlaDzieci) {
        this.czyDlaDzieci = czyDlaDzieci;
    }

    @Basic
    @Column(name = "CENA")
    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    @Lob
    @Basic(fetch=LAZY)
    @Column(name="ZDJECIE", columnDefinition="BLOB NOT NULL")
    public byte[] getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(byte[] zdjecie) {
        this.zdjecie = zdjecie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BezReceptyEntity that = (BezReceptyEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(czyDlaDzieci, that.czyDlaDzieci) &&
                Objects.equals(cena, that.cena) &&
                Arrays.equals(zdjecie, that.zdjecie);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, nazwa, czyDlaDzieci, cena);
        result = 31 * result + Arrays.hashCode(zdjecie);
        return result;
    }

    @Lob
    @Basic
    @Column(name = "OPIS")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
