class Problem3BakeryShop:
    def main(self):
        stocks = {}
        sum_sold = 0

        while True:
            input_str = input()
            if input_str == "Complete":
                break

            info = input_str.split()
            command = info[0]
            quantity = int(info[1])
            food = info[2]

            if command == "Receive":
                if quantity > 0:
                    if food not in stocks:
                        stocks[food] = quantity
                    else:
                        stocks[food] += quantity

            elif command == "Sell":
                if food not in stocks:
                    print(f"You do not have any {food}.")
                else:
                    current_quantity = stocks[food]
                    if quantity > current_quantity:
                        sum_sold += current_quantity
                        print(f"There aren't enough {food}. You sold the last {current_quantity} of them.")
                        del stocks[food]
                    else:
                        sum_sold += quantity
                        print(f"You sold {quantity} {food}.")
                        stocks[food] -= quantity
                        if stocks[food] <= 0:
                            del stocks[food]

        for food, amount in stocks.items():
            print(f"{food}: {amount}")
        print(f"All sold: {sum_sold} goods")


if __name__ == "__main__":
    bakery_shop = Problem3BakeryShop()
    bakery_shop.main()
