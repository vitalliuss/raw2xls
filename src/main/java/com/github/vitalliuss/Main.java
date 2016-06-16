package com.github.vitalliuss;

import com.github.vitalliuss.cli.CommandLineArguments;
import com.github.vitalliuss.runner.Runner;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import java.net.URISyntaxException;

public class Main
{
    public static void main( String[] args ) throws URISyntaxException {
        CommandLineArguments commandLineArguments = new CommandLineArguments();
        CmdLineParser parser = new CmdLineParser(commandLineArguments);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.out.println("Something went wrong when parsing arguments");
            parser.printUsage(System.out);
        }

        Runner runner = new Runner();
        runner.run(commandLineArguments.getDirectoryToScan(), commandLineArguments.getOutputFileName());
    }
}
