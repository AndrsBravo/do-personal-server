package com.personal.shared.process;

public interface IProcessInit<E> {

    public E getInitObject();

    public void init(E initObject);

}
