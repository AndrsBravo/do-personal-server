package com.personal.shared.process;

import java.util.function.Supplier;

public abstract class FunctionalProcessExecutor<T extends FunctionalProcess<E, R>, E, R> extends ProcessExecutor<T> {

    public FunctionalProcessExecutor(T process, Supplier<IProcessRule<T>>... businessRules) {
        super(process, businessRules);
    }

    public FunctionalProcessExecutor<T, E, R> onStateChanged(IOnStateChanged<T> listener) {
        this.listener = listener;
        return this;
    }

    public FunctionalProcessExecutor<T, E, R> init(E initObject) {
        this.process.init(initObject);
        //System.out.println("--- Starting process... " + this.process.getCode());
        return this;
    }

}
