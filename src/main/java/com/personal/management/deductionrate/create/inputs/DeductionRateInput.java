package com.personal.management.deductionrate.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.backoffice.shared.inputs.CountryInputBase;

public class DeductionRateInput extends CountryInputBase {

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
        deductionRate.setCountry(this.getCountry());
        return deductionRate;
    }
}
