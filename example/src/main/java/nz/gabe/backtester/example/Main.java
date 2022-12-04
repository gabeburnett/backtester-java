package nz.gabe.backtester.example;

import java.net.URI;
import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2)
            throw new InvalidParameterException("Invalid arguments. Expected two arguments, 'host bot-id'.");

        ExampleAlgorithm algo = new ExampleAlgorithm(URI.create(args[0]), Long.parseLong(args[1]));
        algo.start();
    }
}
