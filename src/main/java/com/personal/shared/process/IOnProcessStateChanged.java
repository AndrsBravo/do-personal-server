package com.personal.shared.process;

@FunctionalInterface
public interface IOnProcessStateChanged {

    void stateHasChange(ProcessState previousState, ProcessState newState);
}
