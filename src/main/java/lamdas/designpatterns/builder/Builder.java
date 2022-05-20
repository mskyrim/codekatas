package lamdas.designpatterns.builder;

import lamdas.designpatterns.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
