/* エンティティ: ユーザーや注文など、識別可能なオブジェクトです。 */
public class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // ゲッターとセッター
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}

/* 値オブジェクト: 不変の属性を持つオブジェクトで、識別子を持たないものです。 */
public class Address {
    private String street;
    private String city;
    private String zipCode;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    // ゲッター
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }
}

/* 集約: エンティティと値オブジェクトのグループで、一貫性を保つために一緒に管理されます。 */
import java.util.List;
public class Order {
    private String orderId;
    private User user;
    private List<Address> shippingAddresses;

    public Order(String orderId, User user, List<Address> shippingAddresses) {
        this.orderId = orderId;
        this.user = user;
        this.shippingAddresses = shippingAddresses;
    }

    // ゲッター
    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<Address> getShippingAddresses() {
        return shippingAddresses;
    }
}

/* リポジトリ: エンティティの永続化を管理するオブジェクトです。 */
public interface UserRepository {
    void save(User user);
    User findById(String userId);
}

