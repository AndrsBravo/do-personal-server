package com.personal.shared.process;

@FunctionalInterface
public interface IOnStateChanged<T extends Process> {

    void onStateHasChanged(ProcessState state, T process);
}
