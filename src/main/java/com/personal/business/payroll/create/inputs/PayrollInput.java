package com.personal.business.payroll.create.inputs;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollInput extends BusinessInputBase {

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

    public void setPayroll(String relation) {
        this.payroll = relation;
    }

    public Payroll getPayroll() {
        var _payroll = this.id == null || this.id.isEmpty() ? new Payroll() : new Payroll(this.id);
        _payroll.setTitle(title);
        _payroll.setPayroll(payroll);
        _payroll.setDescription(description);
        _payroll.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        _payroll.setCreatedBy(sessionUser);
        return _payroll;
    }
}
