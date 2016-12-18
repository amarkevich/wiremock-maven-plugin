package uk.co.deliverymind.wiremock.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

abstract public class ConfigurationMojo extends AbstractMojo {

    /**
     * Set the root directory (<i>--root-dir</i>), under which <i>mappings</i> and <i>__files</i> reside.
     * This defaults to: <i>target/classes</i>
     */
    @Parameter(property = "dir", defaultValue = "target/classes")
    private File dir;

    /**
     * Set all other parameters in command-line format, e.g.:
     * <i>--port=8081 --verbose</i>
     * Do <b>NOT</b> specify <i>--root-dir</i> here.
     */
    @Parameter(property = "params")
    private String params;

    protected String[] getAllParams() {
        String allParams = String.format("%s%s %s", "--root-dir=", dir, params);
        return allParams.split(" ");
    }
}