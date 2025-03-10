interface MyDelegate {
    void doSomething();
}

class MyClass {
    private MyDelegate delegate;

    public void setDelegate(MyDelegate delegate) {
        this.delegate = delegate;
    }

    public void performAction() {
        if (delegate != null) {
            delegate.doSomething(); 
        }
    }
}

class MyConcreteDelegate implements MyDelegate { 
    @Override
    public void doSomething() {
        System.out.println("具体的な処理を実行します！"); 
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        myObject.setDelegate(new MyConcreteDelegate()); 
        myObject.performAction(); // 出力: 具体的な処理を実行。
    }
}
