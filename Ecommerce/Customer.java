/*
package Ecommerce;

import java.util.Date;
import java.util.List;

public class Customer {

    ProductCart productCart;
    Search searchObj; // Search Product based on pName, pCategory
    int customerId;

    public ProductCart getProductCart(customerId);
    public void addProductToCart(Item item);
    public void modifyProductToCart(Item item);
    public void deleteProductFromCart(Item item);
}

class GuestUser extends Customer {
    public Account addNewAccount();
}

class User extends Customer{
    Account accountDetail;
}

class Seller extends User {
    public void addProducts(Product product);
}

class Buyer extends User {

    Order orderObj;
    public OrderStatus placeOrder(ProductCart productCart);
    public void addReview(ProductReview review);
}

class Account {
    int userId;
    String userName;
    String password;
    String mobileNo;
    AccountType accountType;

    List<Address> address;
    boolean accountStatus;

}

enum AccountType{
    BUYER,SELLER;
}

class Address {
    int pincode;
    String street;
    String city;
    String state;
    String country;
}

class ProductCart {

    List<Item> itemDetails;
    double cartAmount;

    public void addItem(Item item);
    public void modifyItem(Item item);
    public void deleteItem(Item item);
    public List<Item> getItemDetails();
    public double getCartAmount();
    public void checkout();
}

class Item {
    Product product;
    double quantity;
}

class Product {
    int productId;
    String productDescription;
    Seller seller;
    List<ProductReview> review;
    ProductCategory productCategory;
    double amount;
}

enum ProductCategory{
    ELECTRONICS,APPLIANCE,SPORTS,CLOTHES;
}

class ProductReview {
    String reviewDetails;
    double rating;
    Buyer buyer;
}

class Search {
    public List<Product> getProductByName(String productName);
    public List<Product> getProductByCategory(ProductCategory category);
}

class Order {
    int orderId;
    List<Item> item;
    Buyer buyer;
    Date orderDate;
    NotificationService notificationService;
    double orderAmount;

    public OrderStatus placeOrder();
    public OrderStatus trackOrder();
    public void cancelOrder();
    public PaymentStatus makePayment(PaymentType type);
}

enum OrderStatus {
    ORDERED,PACKED,SHIPPED,OUT_FOR_DELIVERY,DELIVERED;
}

enum PaymentStatus {
    SUCCESS,ERROR,PAID,REFUND_INITIATED,REFUNDED;
}

enum PaymentType {
    CASH_ON_DELIVERY,CREDIT_CARD,DEBIT_CARD,UPI,NETBANKING;
}

class NotificationService {
    Noticiation noticiation;
    MessageAttribute message;
    public boolean sendNotification(NotificationDomain domain) {
        switch(domain.getNotificationType()) {
            case EMAIL : {
                noticiation = new EmailNotification();
                message = new MessageAttribute("abc@domain.com",domain.getUser().getAddress().getEmail(),"message content...");
                break;
            }
            case SMS : {
                noticiation = new SMSNotification();
                message = new MessageAttribute("8002257120",domain.getUser().getAddress().getPhone(),"message content...");
                break;
            }
            default: {
                noticiation = new WhatsappNotification();
                message = new MessageAttribute("8002257120",domain.getUser().getAddress().getPhone(),"message content...");
                break;
            }
        }
        return noticiation.sendNotification(message);
    }
}

interface Notification {
    boolean sendNotification(MessageAttribute attribute);
}

class EmailNotification implements Notification{
    boolean sendNotification(MessageAttribute attribute);
}
class SMSNotification implements Notification{
    boolean sendNotification(MessageAttribute attribute);
}
class WhatsappNotification implements Notification{
    boolean sendNotification(MessageAttribute attribute);
}

class MessageAttribute {
    String to;
    String from;
    String message;
}

class NotificationDomain{
    int notificationId;
    NotificationType type;
    User user;
}

enum NotificationType{
    WHATSAPP,EMAIL,SMS;
}
*/
