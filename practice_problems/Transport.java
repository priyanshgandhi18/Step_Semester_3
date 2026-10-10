import sys

class Transport:
    def __init__(self, distance: float):
        self.distance = distance

    def calculate_fare(self) -> float:
        raise NotImplementedError

class BusTransport(Transport):
    def calculate_fare(self) -> float:
        fare = 2.0 + (0.10 * self.distance)
        return min(fare, 10.0)  # Max fare cap is $10

class TrainTransport(Transport):
    def calculate_fare(self) -> float:
        return 3.0 + (0.15 * self.distance)

class MetroTransport(Transport):
    def __init__(self, distance: float, peak_hour_factor: float):
        super().__init__(distance)
        self.peak_hour_factor = peak_hour_factor

    def calculate_fare(self) -> float:
        return (1.50 + (0.20 * self.distance)) * self.peak_hour_factor

def main():
    input_data = sys.stdin.read().splitlines()
    if not input_data:
        return

    n = int(input_data[0].strip())
    grand_total_fare = 0.0

    for i in range(1, n + 1):
        line = input_data[i].strip()
        if not line:
            continue

        parts = line.split()
        t_type = parts[0]

        if t_type == "BUS":
            distance = float(parts[1])
            journey = BusTransport(distance)
        elif t_type == "TRAIN":
            distance = float(parts[1])
            journey = TrainTransport(distance)
        elif t_type == "METRO":
            distance = float(parts[1])
            peak_factor = float(parts[2])
            journey = MetroTransport(distance, peak_factor)

        fare = journey.calculate_fare()
        grand_total_fare += fare

        print(f"{t_type}: {fare:.2f}")

    print(f"Total: {grand_total_fare:.2f}")

if __name__ == "__main__":
    main()