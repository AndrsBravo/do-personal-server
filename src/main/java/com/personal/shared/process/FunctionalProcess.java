package com.personal.shared.process;

import java.util.List;

public abstract class FunctionalProcess<E, R> extends Process<E> implements IProcessInit<E>, IProcessResult<R> {

    private List<R> processResult;

    public FunctionalProcess(String code) {
        super(code);
    }

    @Override
    public void setResult(List<R> result) {
        this.processResult = result;
    }

    @Override
    public List<R> getResult() {
        return processResult;
    }

}
