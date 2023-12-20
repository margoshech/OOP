class Product:
    def __init__(self, name, price):
        self.name = name
        self.price = price

    def __str__(self):
        return f"{self.name} - ${self.price:.2f}"


class HotDrink(Product):
    def __init__(self, name, price, temperature):
        super().__init__(name, price)
        self.temperature = temperature

    def __str__(self):
        return f"{super().__str__()}, Temperature: {self.temperature}°C"

hot_drink1 = HotDrink("Coffee", 2.5, 85)
hot_drink2 = HotDrink("Tea", 1.8, 75)
hot_drink3 = HotDrink("Cocoa", 3.0, 90)

vending_machine = [hot_drink1, hot_drink2, hot_drink3]

for drink in vending_machine:
    print(drink)
