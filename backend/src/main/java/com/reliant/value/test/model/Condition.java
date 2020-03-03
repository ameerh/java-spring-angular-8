package com.reliant.value.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="\"CONDITION\"")
public class Condition implements Serializable {
    private String condition;
    private BigDecimal value;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"CONDITION\"", nullable = false, length = 10)
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "\"VALUE\"", nullable = false, precision = 2)
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition1 = (Condition) o;

        if (condition != null ? !condition.equals(condition1.condition) : condition1.condition != null) return false;
        if (value != null ? !value.equals(condition1.value) : condition1.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = condition != null ? condition.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
