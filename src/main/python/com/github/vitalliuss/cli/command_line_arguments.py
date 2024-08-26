import argparse

class CommandLineArguments:
    def __init__(self):
        self.parser = argparse.ArgumentParser(description='Process command line arguments.')
        self.parser.add_argument('-i', '--input', dest='directory_to_scan', required=True, help='Directory to scan')
        self.parser.add_argument('-o', '--output', dest='output_file_name', default='output', help='Excel output file name')
        self.args = None

    def parse_arguments(self, args):
        self.args = self.parser.parse_args(args)
        return self.args

    @property
    def directory_to_scan(self):
        return self.args.directory_to_scan

    @property
    def output_file_name(self):
        return self.args.output_file_name