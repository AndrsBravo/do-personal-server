package com.personal.management.payroll.create.inputs;

import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.payroll.entities.Payroll;
import com.personal.backoffice.shared.inputs.CountryInputBase;

public class PayrollInput extends CountryInputBase {

    private String title;
    private String payroll;
    private String description;
    private String temporalFrequencyId;

    public PayrollInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemporalFrequencyId(String temporalFrequencyId) {
        this.temporalFrequencyId = temporalFrequencyId;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public Payroll getPayroll() {
        var _payroll = this.id == null || this.id.isEmpty() ? new Payroll() : new Payroll(this.id);
        _payroll.setTitle(title);
        _payroll.setPayroll(payroll);
        _payroll.setDescription(description);
        _payroll.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        _payroll.setCreatedBy(sessionUser);
        _payroll.setCountry(this.getCountry());
        return _payroll;
    }
}
