from datetime import datetime

class PromotionalClient:
    participants_count = 0

    def __init__(self, promotion_name, client_id, participants_count):
        self.promotion_name = promotion_name
        self.client_id = client_id
        PromotionalClient.participants_count = participants_count

class iReturnOrder:
    def process_return(self, order_id):
        pass

    def is_return_successful(self, order_id):
        pass

class Client(iReturnOrder):
    def __init__(self, client_id):
        self.client_id = client_id

    def process_return(self, order_id):
        pass

    def is_return_successful(self, order_id):
        pass

class PromotionalClient(Client):
    def __init__(self, promotion_name, client_id):
        super().__init__(client_id)
        self.promotion_name = promotion_name

    def process_return(self, order_id):
        if PromotionalClient.participants_count > 100:
            raise ValueError("Promotional client is not eligible for return.")
        # Логика обработки возврата товара

class StoreLogger:
    LOG_FILE_PATH = "store_log.txt"

    @staticmethod
    def log_action(action_description):
        with open(StoreLogger.LOG_FILE_PATH, "a") as file:
            file.write(f"{datetime.now()}: {action_description}\n")

    @staticmethod
    def log_return(order_id, returned_products):
        products_str = ", ".join(returned_products)
        log_message = f"Order {order_id} returned the following products: {products_str}"
        StoreLogger.log_action(log_message)

class Store:
    def process_return(self, order_id, returned_products):
        # Логика обработки возврата товара

        StoreLogger.log_return(order_id, returned_products)