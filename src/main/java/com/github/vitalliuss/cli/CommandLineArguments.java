package com.github.vitalliuss.cli;

import org.kohsuke.args4j.Option;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * Created by Vitali_Shulha on 16-Jun-16.
 */
public class CommandLineArguments {
    @Option(name="-i",aliases = {"--input"},usage="Directory to scan", required = true)
    private String input;

    @Option(name="-o",aliases = {"--output"},usage="Excel output file name",required = false)
    private String outputFileName = "output";

    public String getDirectoryToScan() {
        return input;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

}
