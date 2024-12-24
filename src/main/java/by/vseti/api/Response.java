package by.vseti.api;

import java.util.Optional;

public interface Response {

    Optional<String> getError();
    void setError(String string);
}
