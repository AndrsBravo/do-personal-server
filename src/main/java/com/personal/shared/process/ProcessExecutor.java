package com.personal.shared.process;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class ProcessExecutor<T extends Process> {

    protected T process;

    protected IOnStateChanged<T> listener;
    private final Iterator<Supplier<IProcessRule<T>>> businessRules;

    public ProcessExecutor(T process, Supplier<IProcessRule<T>>... businessRules) {
        Objects.requireNonNull(process);
        Objects.requireNonNull(businessRules);
        this.process = process;
        this.process.onStateChanged(this::processStateChanged);
        this.businessRules = Arrays.asList(businessRules).iterator();
    }

    private void processStateChanged(ProcessState previousState, ProcessState newState) {
        if (this.listener == null) {
            return;
        }

        this.listener.onStateHasChanged(newState, this.process);

    }

    public T execute() {
        //System.out.println("--- Executing process... " + this.process.getCode());
        while (businessRules.hasNext() && this.process.isActive()) {
            businessRules.next().get().apply(this.process);
        }
        //System.out.println("--- Process Executed " + this.process.getCode());

        if (this.process.state() == ProcessState.RUNNING) {
            this.process.terminate();
        }

        return this.process;
    }

}
