import argparse


class CommandLineArguments:
    def __init__(self):
        self.parser = argparse.ArgumentParser(description='Process command-line arguments.')
        self.parser.add_argument('-i', '--input', type=str, required=True, help='Directory to scan')
        self.parser.add_argument('-o', '--output', type=str, default='output', help='Excel output file name')
        self.args = self.parser.parse_args()

    @property
    def directory_to_scan(self):
        return self.args.input

    @property
    def output_file_name(self):
        return self.args.output

if __name__ == '__main__':
    cmd_args = CommandLineArguments()
    print(f'Directory to scan: {cmd_args.directory_to_scan}')
    print(f'Output file name: {cmd_args.output_file_name}')