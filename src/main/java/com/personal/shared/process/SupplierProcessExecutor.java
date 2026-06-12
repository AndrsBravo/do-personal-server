package com.personal.shared.process;

import java.util.function.Supplier;

public abstract class SupplierProcessExecutor<T extends SupplierProcess<E>, E> extends ProcessExecutor<T> {

    public SupplierProcessExecutor(T process, Supplier<IProcessRule<T>>... businessRules) {
        super(process, businessRules);
    }

    public SupplierProcessExecutor<T, E> onStateChanged(IOnStateChanged<T> listener) {
        this.listener = listener;
        return this;
    }

    public SupplierProcessExecutor<T, E> init(E initObject) {
        this.process.init(initObject);
        //System.out.println("--- Starting process... " + this.process.getCode());
        return this;
    }

}
