package com.personal.business.payrollrun.create.inputs;

import com.personal.business.country.entities.Country;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollRunInput extends BusinessInputBase {

    private String title;
    private String payrollId;
    private String description;
    private String payrollRunTypeId;

    public PayrollRunInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemporalFrequencyId(String payrollRunTypeId) {
        this.payrollRunTypeId = payrollRunTypeId;
    }

    public void setPayrollRun(String payrollId) {
        this.payrollId = payrollId;
    }

    public PayrollRun getPayrollRun() {
        var _payrollRun = this.id == null || this.id.isEmpty() ? new PayrollRun() : new PayrollRun(this.id);
        _payrollRun.setTitle(title);
        _payrollRun.setPayroll(new Payroll(payrollId));
        _payrollRun.setDescription(description);
        _payrollRun.setPayrollRunType(new TypeEntityBase(payrollRunTypeId));
        _payrollRun.setCreatedBy(sessionUser);
        _payrollRun.setBusiness(getBusiness());

        return _payrollRun;
    }
}
