package com.personal.shared.process.logs;

import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.Process;

public class LogFactory {

    private final Class<? extends Process> processClass;
    private final Class<? extends IProcessRule> ruleClass;
    private String shouldDo;
    private String result;
    private LogType type;

    public LogFactory(Class<? extends Process> processClass, Class<? extends IProcessRule> ruleClass) {
        this.processClass = processClass;
        this.ruleClass = ruleClass;
    }

    private Log build(LogType type, String should, String result) {
        this.type = type;
        this.shouldDo = should;
        this.result = result;
        return build();
    }

    public static LogFactory builder(Class<? extends Process> processClass, Class<? extends IProcessRule> ruleClass) {
        return new LogFactory(processClass, ruleClass);
    }

    public LogFactory shouldDo(String text) {
        this.shouldDo = text;
        return this;
    }

    public LogFactory result(String text) {
        this.result = text;
        return this;
    }

    public LogFactory type(LogType type) {
        this.type = type;
        return this;
    }

    public Log INFO(String should, String result) {
        this.type = LogType.INFO;
        this.shouldDo = should;
        this.result = result;
        return this.build();
    }

    public Log SUCCESS(String should, String result) {

        return this.build(LogType.SUCCESS, should, result);
    }

    public Log WARNING(String should, String result) {

        return this.build(LogType.WARNING, should, result);
    }

    public Log ERROR(String should, String result) {
        return this.build(LogType.ERROR, should, result);
    }

    public Log build() {

        return new Log(ruleClass.getName(), type, processClass.getName(), ruleClass.getName(), shouldDo, result);
    }

}
