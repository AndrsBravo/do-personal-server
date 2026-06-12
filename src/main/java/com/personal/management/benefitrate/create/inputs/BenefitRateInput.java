package com.personal.management.benefitrate.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.country.entities.Country;
import com.personal.management.shared.inputs.CountryInputBase;

public class BenefitRateInput extends CountryInputBase {

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
        benefitRate.setCountry(new Country(this.getCountryId()));
        return benefitRate;
    }
}
