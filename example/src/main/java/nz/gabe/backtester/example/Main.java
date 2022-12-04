package nz.gabe.backtester.example;

import java.net.URI;
import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2)
            throw new InvalidParameterException("Invalid arguments. Expected two arguments, 'host bot-id'.");

        long botId = Long.parseLong(args[1].trim());
        String wsUrl = args[0].trim();
        System.out.printf("[Bot %d]: Connecting to %s%n", botId, wsUrl);

        ExampleAlgorithm algo = new ExampleAlgorithm(URI.create(wsUrl), botId);
        algo.start();
    }
}
