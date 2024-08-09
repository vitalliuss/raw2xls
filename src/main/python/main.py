import argparse
from runner import Runner

def main():
    parser = argparse.ArgumentParser(description='Process command-line arguments.')
    parser.add_argument('--directoryToScan', required=True, help='Directory to scan')
    parser.add_argument('--outputFileName', required=True, help='Output file name')

    args = parser.parse_args()

    runner = Runner()
    runner.run(args.directoryToScan, args.outputFileName)

if __name__ == "__main__":
    main()
