/* 例２: ユーザー管理システム */

// ユーザーエンティティのインターフェース
interface UserEntity {
    String getId();
    String getName();
}

// ユーザーリポジトリのインターフェース
interface UserRepository {
    void save(UserEntity user);
    UserEntity findById(String id);
}

// ユーザーサービスのインターフェース
interface UserService {
    void registerUser(String name);
    UserEntity getUser(String id);
}

// 監査情報を提供するインターフェース
interface Auditable {
    String getCreatedAt();
    String getUpdatedAt();
}

// ユーザーエンティティの実装
class User implements UserEntity, Auditable {
    private String id;
    private String name;
    private String createdAt;
    private String updatedAt;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now().toString();
        this.updatedAt = LocalDateTime.now().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String getUpdatedAt() {
        return updatedAt;
    }
}

// ユーザーリポジトリの実装
class InMemoryUserRepository implements UserRepository {
    private Map<String, UserEntity> users = new HashMap<>();

    @Override
    public void save(UserEntity user) {
        users.put(user.getId(), user);
    }

    @Override
    public UserEntity findById(String id) {
        return users.get(id);
    }
}

// ユーザーサービスの実装
class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(String name) {
        String id = UUID.randomUUID().toString();
        UserEntity user = new User(id, name);
        userRepository.save(user);
    }

    @Override
    public UserEntity getUser(String id) {
        return userRepository.findById(id);
    }
}

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserServiceImpl(userRepository);

        // ユーザーを登録
        userService.registerUser("山田太郎");

        // ユーザーを取得
        UserEntity user = userService.getUser("1"); // IDは適切に設定する必要がある。
        System.out.println("ユーザー名: " + user.getName());
        System.out.println("作成日時: " + ((Auditable) user).getCreatedAt());
    }
}

