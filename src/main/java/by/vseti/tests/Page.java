package by.vseti.tests;

import by.vseti.ui.Appendable;

import java.util.function.Consumer;

public abstract class Page<T> {

    public T appendAction(Consumer action){
        action.accept(action);
        return (T)this;
    }
}
