package com.personal.business.payrollcalculationresult.create.inputs;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollCalculationResultInput extends BusinessInputBase {

    private String title;
    private String payrollId;
    private String description;

    private String referenceId;
    private String referenceTitle;
    private Double quantity;

    public PayrollCalculationResultInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPayrollCalculationResult(String payrollId) {
        this.payrollId = payrollId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public void setReferenceTitle(String referenceTitle) {
        this.referenceTitle = referenceTitle;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public PayrollCalculationResult getPayrollCalculationResult() {
        var _payrollCalculationResult = this.id == null || this.id.isEmpty() ? new PayrollCalculationResult() : new PayrollCalculationResult(this.id);
        _payrollCalculationResult.setTitle(title);
        _payrollCalculationResult.setPayroll(new Payroll(payrollId));
        _payrollCalculationResult.setDescription(description);
        _payrollCalculationResult.setReference(referenceId);
        _payrollCalculationResult.setReferenceTitle(referenceTitle);
        _payrollCalculationResult.setQuantity(quantity);
        _payrollCalculationResult.setCreatedBy(sessionUser);
        _payrollCalculationResult.setBusiness(getBusiness());

        return _payrollCalculationResult;
    }
}
