package com.reliant.value.test.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DepreciationPK implements Serializable {
    private String depreciationCode;
    private int age;

    @Column(name = "\"DEPRECIATION_CODE\"", nullable = false, length = 2)
    @Id
    public String getDepreciationCode() {
        return depreciationCode;
    }

    public void setDepreciationCode(String depreciationCode) {
        this.depreciationCode = depreciationCode;
    }

    @Column(name = "\"AGE\"", nullable = false)
    @Id
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepreciationPK that = (DepreciationPK) o;

        if (age != that.age) return false;
        if (depreciationCode != null ? !depreciationCode.equals(that.depreciationCode) : that.depreciationCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depreciationCode != null ? depreciationCode.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
