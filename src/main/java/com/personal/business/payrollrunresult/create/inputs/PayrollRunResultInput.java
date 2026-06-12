package com.personal.business.payrollrunresult.create.inputs;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollRunResultInput extends BusinessInputBase {

    private String title;
    private String payrollId;
    private String description;

    private String referenceId;
    private String referenceTitle;
    private Double quantity;

    public PayrollRunResultInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPayrollRunResult(String payrollId) {
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

    public PayrollRunResult getPayrollRunResult() {
        var _payrollRunResult = this.id == null || this.id.isEmpty() ? new PayrollRunResult() : new PayrollRunResult(this.id);
        _payrollRunResult.setTitle(title);
        _payrollRunResult.setPayroll(new Payroll(payrollId));
        _payrollRunResult.setDescription(description);
        _payrollRunResult.setReference(referenceId);
        _payrollRunResult.setReferenceTitle(referenceTitle);
        _payrollRunResult.setQuantity(quantity);
        _payrollRunResult.setCreatedBy(sessionUser);
        _payrollRunResult.setBusiness(getBusiness());

        return _payrollRunResult;
    }
}
