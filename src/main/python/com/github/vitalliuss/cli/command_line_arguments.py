import argparse

class CommandLineArguments:
    def __init__(self):
        self.parser = argparse.ArgumentParser(description='Process some integers.')
        self.parser.add_argument('-i', '--input', required=True, help='Directory to scan')
        self.parser.add_argument('-o', '--output', default='output', help='Excel output file name')
        self.args = None
    
    def parse_args(self, arguments):
        self.args = self.parser.parse_args(arguments)
        
    @property
    def directory_to_scan(self):
        return self.args.input
    
    @property
    def output_file_name(self):
        return self.args.output