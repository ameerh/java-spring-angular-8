package com.reliant.value.test.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "\"ASSETS\"")
public class Assets {
    private long id;
    private int num;
    private String description;
    private int lifeYears;
    private int rangeMin;
    private int rangeMax;
    private String depreciationCode;
    private BigDecimal olv;
    private BigDecimal flv;

    @Id
    @Column(name = "\"ID\"", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"NUM\"", nullable = false)
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "\"DESCRIPTION\"", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "\"LIFE_YEARS\"", nullable = false)
    public int getLifeYears() {
        return lifeYears;
    }

    public void setLifeYears(int lifeYears) {
        this.lifeYears = lifeYears;
    }

    @Basic
    @Column(name = "\"RANGE_MIN\"", nullable = false)
    public int getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(int rangeMin) {
        this.rangeMin = rangeMin;
    }

    @Basic
    @Column(name = "\"RANGE_MAX\"", nullable = false)
    public int getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(int rangeMax) {
        this.rangeMax = rangeMax;
    }

    @Basic
    @Column(name = "\"DEPRECIATION_CODE\"", nullable = false, length = 2)
    public String getDepreciationCode() {
        return depreciationCode;
    }

    public void setDepreciationCode(String depreciationCode) {
        this.depreciationCode = depreciationCode;
    }

    @Basic
    @Column(name = "\"OLV\"", nullable = true, precision = 2)
    public BigDecimal getOlv() {
        return olv;
    }

    public void setOlv(BigDecimal olv) {
        this.olv = olv;
    }

    @Basic
    @Column(name = "\"FLV\"", nullable = true, precision = 2)
    public BigDecimal getFlv() {
        return flv;
    }

    public void setFlv(BigDecimal flv) {
        this.flv = flv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assets assets = (Assets) o;

        if (id != assets.id) return false;
        if (num != assets.num) return false;
        if (lifeYears != assets.lifeYears) return false;
        if (rangeMin != assets.rangeMin) return false;
        if (rangeMax != assets.rangeMax) return false;
        if (description != null ? !description.equals(assets.description) : assets.description != null) return false;
        if (depreciationCode != null ? !depreciationCode.equals(assets.depreciationCode) : assets.depreciationCode != null)
            return false;
        if (olv != null ? !olv.equals(assets.olv) : assets.olv != null) return false;
        if (flv != null ? !flv.equals(assets.flv) : assets.flv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + num;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + lifeYears;
        result = 31 * result + rangeMin;
        result = 31 * result + rangeMax;
        result = 31 * result + (depreciationCode != null ? depreciationCode.hashCode() : 0);
        result = 31 * result + (olv != null ? olv.hashCode() : 0);
        result = 31 * result + (flv != null ? flv.hashCode() : 0);
        return result;
    }
}
