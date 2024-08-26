import sys
from com.github.vitalliuss.cli import CommandLineArguments
from com.github.vitalliuss.runner import Runner

if __name__ == '__main__':
    commandLineArguments = CommandLineArguments()
    try:
        commandLineArguments.parse_arguments(sys.argv[1:])
    except Exception as e:
        print('Something went wrong when parsing arguments')
        commandLineArguments.print_usage()

    runner = Runner()
    runner.run(commandLineArguments.directory_to_scan, commandLineArguments.output_file_name)