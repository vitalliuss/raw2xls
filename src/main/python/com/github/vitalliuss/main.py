import sys
from com.github.vitalliuss.cli import CommandLineArguments
from com.github.vitalliuss.runner import Runner

def main():
    command_line_arguments = CommandLineArguments()
    try:
        command_line_arguments.parse_args(sys.argv[1:])
    except Exception as e:
        print('Something went wrong when parsing arguments')
        print(e)
    
    runner = Runner()
    runner.run(command_line_arguments.directory_to_scan, command_line_arguments.output_file_name)

if __name__ == '__main__':
    main()