package nz.gabe.backtester.example;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        ExampleAlgorithm algo = new ExampleAlgorithm(URI.create("ws://localhost:1338"), 420);
        algo.start();
    }
}
