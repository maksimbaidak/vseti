package by.vseti.ui;

import java.util.function.Consumer;

/**
 * Class that implement this interface are able
 * to add some actions right in chain of method calls
 * @param <T>
 */
public interface Appendable<T> {

    public default T appendAction(Consumer action){
        action.accept(action);
        return (T)this;
    }
}
