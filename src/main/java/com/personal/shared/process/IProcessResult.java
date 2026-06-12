package com.personal.shared.process;

import java.util.List;

public interface IProcessResult<U> {

    public void setResult(List<U> result);

    public List<U> getResult();

}
