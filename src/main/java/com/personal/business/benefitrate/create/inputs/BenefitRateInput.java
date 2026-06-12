package com.personal.business.benefitrate.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.benefitrate.entities.BenefitRate;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.BusinessInputBase;

public class BenefitRateInput extends BusinessInputBase {

    private String benefitId;
    private String temporalFrequencyId;
    private Double rate;
    private Double amount;
    private Double base_amount;
    private Byte level;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public BenefitRateInput() {
        super();
    }

    public BenefitRate getBenefitRate() {
        var benefitRate = this.id == null || this.id.isEmpty() ? new BenefitRate() : new BenefitRate(this.id);
        benefitRate.setBenefit(new Benefit(benefitId));
        benefitRate.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        benefitRate.setRate(rate);
        benefitRate.setAmount(amount);
        benefitRate.setBaseAmount(base_amount);
        benefitRate.setLevel(level);
        benefitRate.setStartedAt(started_at);
        benefitRate.setEndedAt(ended_at);
        benefitRate.setCreatedBy(sessionUser);
        benefitRate.setBusiness(getBusiness());
        return benefitRate;
    }
}
