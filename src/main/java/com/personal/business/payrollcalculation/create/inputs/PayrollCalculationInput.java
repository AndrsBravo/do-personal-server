package com.personal.business.payrollcalculation.create.inputs;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollCalculationInput extends BusinessInputBase {

    private String title;
    private String payrollId;
    private String description;

    public PayrollCalculationInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPayrollCalculation(String payrollId) {
        this.payrollId = payrollId;
    }

    public PayrollCalculation getPayrollCalculation() {
        var _payrollCalculation = this.id == null || this.id.isEmpty() ? new PayrollCalculation() : new PayrollCalculation(this.id);
        _payrollCalculation.setTitle(title);
        _payrollCalculation.setPayroll(new Payroll(payrollId));
        _payrollCalculation.setDescription(description);
        _payrollCalculation.setCreatedBy(sessionUser);
        _payrollCalculation.setBusiness(getBusiness());

        return _payrollCalculation;
    }
}
