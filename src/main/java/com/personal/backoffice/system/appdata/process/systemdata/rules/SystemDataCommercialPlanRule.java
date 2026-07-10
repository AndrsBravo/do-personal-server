package com.personal.backoffice.system.appdata.process.systemdata.rules;

import java.util.stream.Stream;

import com.personal.backoffice.commercial.plan.create.process.CreateCommercialPlanProcessExecutor;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcess;
import com.personal.server.mapper.JsonMapper;
import com.personal.shared.process.IProcessRule;

public class SystemDataCommercialPlanRule implements IProcessRule<SystemDataProcess> {

    @Override
    public void apply(SystemDataProcess process) {

        var data = process.getInitObject();
        if (data.isEmpty()) {
        }
        var plansJson = data.get("plans");

        if (plansJson == null) {
        }

        var plans = JsonMapper.fromJson(plansJson, CommercialPlan[].class);
        if (plans == null || plans.length < 1) {
        }

        Stream.of(plans).forEach(plan -> CreateCommercialPlanProcessExecutor.builder().init(plan).execute().getLogs().forEach(process::addLog));

    }

}
