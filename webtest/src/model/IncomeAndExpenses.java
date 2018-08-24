package model;

import javax.persistence.*;

@Entity
@Table(name = "year_income_expenses")
public class IncomeAndExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "income")
    private Float income;
    @Column(name = "expenses")
    private Float expenses;

    public Integer getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Float getIncome() {
        return income;
    }

    public Float getExpenses() {
        return expenses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public void setExpenses(Float expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "IncomeAndExpenses{" +
                "id=" + id +
                ", year=" + year +
                ", income=" + income +
                ", expenses=" + expenses +
                '}';
    }
}
