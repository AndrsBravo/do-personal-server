package com.personal.business.deductionrate.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.BusinessInputBase;

public class DeductionRateInput extends BusinessInputBase {

    private String deductionId;
    private String temporalFrequencyId;
    private Double rate;
    private Double amount;
    private Double base_amount;
    private Byte level;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public DeductionRateInput() {
        super();
    }

    public DeductionRate getDeductionRate() {
        var deductionRate = this.id == null || this.id.isEmpty() ? new DeductionRate() : new DeductionRate(this.id);
        deductionRate.setDeduction(new Deduction(deductionId));
        deductionRate.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        deductionRate.setRate(rate);
        deductionRate.setAmount(amount);
        deductionRate.setBaseAmount(base_amount);
        deductionRate.setLevel(level);
        deductionRate.setStartedAt(started_at);
        deductionRate.setEndedAt(ended_at);
        deductionRate.setCreatedBy(sessionUser);
        deductionRate.setBusiness(this.getBusiness());
        return deductionRate;
    }
}
