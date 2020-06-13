package com.ingconti;



// declare our news "type" (an interface)

@FunctionalInterface
public interface Callback {
    // we pass a string, ca be any type and also get back a result.
    void body(int n);
}
