import re

class Problem2DestinationMapper:
    def main(self):
        input_str = input()
        regex = r"([\/=])([A-Z][a-zA-Z]{2,})\1"
        pattern = re.compile(regex)
        matches = pattern.findall(input_str)
        destinations = []
        total_sum = 0

        for match in matches:
            destination = match[1]
            total_sum += len(destination)
            destinations.append(destination)

        print("Destinations:", ", ".join(destinations))
        print("Travel Points:", total_sum)


if __name__ == "__main__":
    destination_mapper = Problem2DestinationMapper()
    destination_mapper.main()
