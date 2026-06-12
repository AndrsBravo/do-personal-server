package com.personal.shared.process;

import java.util.ArrayList;
import java.util.List;

import com.personal.shared.process.logs.Log;
import com.personal.shared.query.Query;

import jakarta.json.JsonObject;

public abstract class Process<E> {

    protected E initObject;
    private JsonObject processResultJsonObject;

    private boolean active;
    private Log currentLog;
    private final Query query;
    private final String code;
    private final List<Log> logs;
    private ProcessState processState;
    private IOnProcessStateChanged onStateChanged;

    public Process(String code) {
        this.code = code;
        this.active = false;
        this.logs = new ArrayList<>();
        this.query = new Query();

    }

    public E getInitObject() {
        return initObject;
    }

    public void init(E initObject) {
        this.start();
        this.initObject = initObject;
    }

    protected void start() {
        this.active = true;
        this.processState = ProcessState.RUNNING;
    }

    public Query Query() {
        return query;
    }

    public void onStateChanged(IOnProcessStateChanged onStateChanged) {
        this.onStateChanged = onStateChanged;
    }

    public String getCode() {
        return this.code;
    }

    public void addLog(Log log) {
        this.currentLog = log;
        this.logs.add(log);
    }

    public void terminate() {
        this.stop(ProcessState.COMPLETED);
    }

    public void stop() {
        this.stop(ProcessState.STOPPED);
    }

    public void stopWithErrors() {
        this.stop(ProcessState.STOP_WITH_ERROR);
    }

    public void stop(ProcessState state) {

        if (this.onStateChanged != null) {
            this.onStateChanged.stateHasChange(this.processState, state);
        }
        this.processState = state;
        this.active = false;

    }

    public boolean isActive() {
        return this.active && ProcessState.RUNNING == this.processState;
    }

    public Log getCurrentLog() {
        return this.currentLog;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public ProcessState state() {
        return processState;
    }

    public void setResult(JsonObject result) {
        this.processResultJsonObject = result;
    }

    public JsonObject getJsonResult() {
        return processResultJsonObject;
    }

}
