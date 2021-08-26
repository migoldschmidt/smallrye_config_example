package de.doubleslash.microprofileconfig.test.smallrye_config_example;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.assertj.core.api.Assertions.assertThat;
import static de.doubleslash.microprofileconfig.test.smallrye_config_example.DotEnvFile.writeDotEnvFile;
import static de.doubleslash.microprofileconfig.test.smallrye_config_example.DotEnvFile.clearDotEnvFile;

class PropertiesEnvFileTest {

    @AfterEach
    void teardown() {
        clearDotEnvFile();
    }

    @Test
    void readFromEnvFile() {
        writeDotEnvFile("NONE_LOCALHOST");
        Config config = ConfigProvider.getConfig();
        assertThat(config.getValue("smallrye.test.hostoverwrite", String.class)).isEqualTo("NONE_LOCALHOST");
        assertThat(config.getValue("smallrye.test.host", String.class)).isEqualTo("localhost");
    }

}
