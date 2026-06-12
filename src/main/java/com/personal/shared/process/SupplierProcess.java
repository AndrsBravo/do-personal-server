package com.personal.shared.process;

import java.util.List;

public abstract class SupplierProcess<E> extends Process<E> implements IProcessResult<E> {

    private List<E> processResult;

    public SupplierProcess(String code) {
        super(code);
    }

    @Override
    public void setResult(List<E> result) {
        this.processResult = result;
    }

    @Override
    public List<E> getResult() {
        return processResult;
    }

}
