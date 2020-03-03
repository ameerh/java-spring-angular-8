package com.reliant.value.test.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="\"DEPRECIATION\"")
@IdClass(DepreciationPK.class)
public class Depreciation {
    private String depreciationCode;
    private int age;
    private BigDecimal depreciation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"DEPRECIATION_CODE\"", nullable = false, length = 2)
    public String getDepreciationCode() {
        return depreciationCode;
    }

    public void setDepreciationCode(String depreciationCode) {
        this.depreciationCode = depreciationCode;
    }

    @Id
    @Column(name = "\"AGE\"", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "\"DEPRECIATION\"", nullable = false, precision = 2)
    public BigDecimal getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(BigDecimal depreciation) {
        this.depreciation = depreciation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Depreciation that = (Depreciation) o;

        if (age != that.age) return false;
        if (depreciationCode != null ? !depreciationCode.equals(that.depreciationCode) : that.depreciationCode != null)
            return false;
        if (depreciation != null ? !depreciation.equals(that.depreciation) : that.depreciation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depreciationCode != null ? depreciationCode.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (depreciation != null ? depreciation.hashCode() : 0);
        return result;
    }
}
