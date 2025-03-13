import java.util.ArrayList;
import java.util.List;

// 売上を管理するインターフェース
interface SalesManagement {
    void recordSale(double amount);
    double getTotalSales();
}

// 進捗を管理するインターフェース
interface ProgressTracking {
    void updateProgress(String status);
    String getProgress();
}

// 地域別メニューを管理するインターフェース
interface RegionalMenu {
    void addRegionalMenuItem(String item);
    List<String> getRegionalMenuItems();
}

// 全国メニューを管理するインターフェース
interface NationalMenu {
    void addNationalMenuItem(String item);
    List<String> getNationalMenuItems();
}

// チェーン店の店舗クラス
class Store implements SalesManagement, ProgressTracking, RegionalMenu, NationalMenu {
    private double totalSales;
    private String progress;
    private List<String> regionalMenuItems;
    private List<String> nationalMenuItems;

    public Store() {
        this.totalSales = 0.0;
        this.progress = "初期状態";
        this.regionalMenuItems = new ArrayList<>();
        this.nationalMenuItems = new ArrayList<>();
    }

    @Override
    public void recordSale(double amount) {
        totalSales += amount;
    }

    @Override
    public double getTotalSales() {
        return totalSales;
    }

    @Override
    public void updateProgress(String status) {
        this.progress = status;
    }

    @Override
    public String getProgress() {
        return progress;
    }

    @Override
    public void addRegionalMenuItem(String item) {
        regionalMenuItems.add(item);
    }

    @Override
    public List<String> getRegionalMenuItems() {
        return regionalMenuItems;
    }

    @Override
    public void addNationalMenuItem(String item) {
        nationalMenuItems.add(item);
    }

    @Override
    public List<String> getNationalMenuItems() {
        return nationalMenuItems;
    }
}
