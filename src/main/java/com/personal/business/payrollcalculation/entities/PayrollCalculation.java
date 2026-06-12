package com.personal.business.payrollcalculation.entities;

import com.personal.business.payroll.entities.Payroll;
import com.personal.shared.entities.BusinessEntity;

public class PayrollCalculation extends BusinessEntity {

    private String title;
    private Payroll payroll;
    private String description;

    public PayrollCalculation() {
        super();
    }

    public PayrollCalculation(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
