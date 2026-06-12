package com.personal.management.payrollrun.create.inputs;

import com.personal.management.country.entities.Country;
import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.management.shared.inputs.CountryInputBase;
import com.personal.shared.entities.TypeEntityBase;

public class PayrollRunInput extends CountryInputBase {

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
        _payrollRun.setCountry(new Country(this.getCountryId()));
        return _payrollRun;
    }
}
