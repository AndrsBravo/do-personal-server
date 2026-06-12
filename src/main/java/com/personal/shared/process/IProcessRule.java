package com.personal.shared.process;

@FunctionalInterface
public interface IProcessRule<T extends Process> {

    void apply(T process);
}
