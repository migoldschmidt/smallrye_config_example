package de.doubleslash.microprofileconfig.test.smallrye_config_example;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public final class DotEnvFile {

    public static void writeDotEnvFile(String host) {
        Path path = Paths.get(System.getProperty("user.dir"), ".env");
        System.out.println("Writing .env config to " + path);

        List<String> lines = List.of(
                "SMALLRYE_TEST_HOSTOVERWRITE=" + host
        );

        try {
            Files.write(path, lines, CREATE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void clearDotEnvFile() {
        Path path = Paths.get(System.getProperty("user.dir"), ".env");
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
