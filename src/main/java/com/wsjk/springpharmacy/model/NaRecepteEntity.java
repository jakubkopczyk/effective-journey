package com.wsjk.springpharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "NA_RECEPTE", schema = "", catalog = "")
public class NaRecepteEntity implements Serializable {
    private Integer id;
    private String nazwa;
    private Boolean czyDlaDzieci;
    private BigDecimal cena;
    private BigDecimal procentRefundacji;
    private byte[] zdjecie;
    private String opis;
    private LekarzEntity lekarzByIdLekarza;

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

    @Basic
    @Column(name = "PROCENT_REFUNDACJI")
    public BigDecimal getProcentRefundacji() {
        return procentRefundacji;
    }

    public void setProcentRefundacji(BigDecimal procentRefundacji) {
        this.procentRefundacji = procentRefundacji;
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
        NaRecepteEntity that = (NaRecepteEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(czyDlaDzieci, that.czyDlaDzieci) &&
                Objects.equals(cena, that.cena) &&
                Objects.equals(procentRefundacji, that.procentRefundacji) &&
                Arrays.equals(zdjecie, that.zdjecie);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, nazwa, czyDlaDzieci, cena, procentRefundacji);
        result = 31 * result + Arrays.hashCode(zdjecie);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_LEKARZA", referencedColumnName = "ID")
    public LekarzEntity getLekarzByIdLekarza() {
        return lekarzByIdLekarza;
    }

    public void setLekarzByIdLekarza(LekarzEntity lekarzByIdLekarza) {
        this.lekarzByIdLekarza = lekarzByIdLekarza;
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
