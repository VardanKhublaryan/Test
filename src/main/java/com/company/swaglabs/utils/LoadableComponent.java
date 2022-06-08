package com.company.swaglabs.utils;


public abstract class LoadableComponent<T extends LoadableComponent<T>> {
    public T get() {
        try {
            isLoaded();
            return (T) this;
        } catch (Error e) {
            load();
        }
        isLoaded();
        return (T) this;
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;
}
