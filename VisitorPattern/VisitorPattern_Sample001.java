// Acceptorインターフェース
interface LogAcceptor {
    void accept(LogVisitor visitor);
}

// 具体的なAcceptorクラス
class InfoLog implements LogAcceptor {
    private String message;

    public InfoLog(String message) {
        this.message = message;
    }

    @Override
    public void accept(LogVisitor visitor) {
        visitor.visit(this);
    }

    public String getMessage() {
        return message;
    }
}

class WarningLog implements LogAcceptor {
    private String message;

    public WarningLog(String message) {
        this.message = message;
    }

    @Override
    public void accept(LogVisitor visitor) {
        visitor.visit(this);
    }

    public String getMessage() {
        return message;
    }
}

class ErrorLog implements LogAcceptor {
    private String message;

    public ErrorLog(String message) {
        this.message = message;
    }

    @Override
    public void accept(LogVisitor visitor) {
        visitor.visit(this);
    }

    public String getMessage() {
        return message;
    }
}

// Visitorインターフェース
interface LogVisitor {
    void visit(InfoLog infoLog);
    void visit(WarningLog warningLog);
    void visit(ErrorLog errorLog);
}

// 具体的なVisitorクラス
class ConsoleLogVisitor implements LogVisitor {
    @Override
    public void visit(InfoLog infoLog) {
        System.out.println("INFO: " + infoLog.getMessage());
    }

    @Override
    public void visit(WarningLog warningLog) {
        System.out.println("WARNING: " + warningLog.getMessage());
    }

    @Override
    public void visit(ErrorLog errorLog) {
        System.out.println("ERROR: " + errorLog.getMessage());
    }
}

// メインクラス
public class VisitorPatternLogExample {
    public static void main(String[] args) {
        LogAcceptor infoLog = new InfoLog("This is an info message.");
        LogAcceptor warningLog = new WarningLog("This is a warning message.");
        LogAcceptor errorLog = new ErrorLog("This is an error message.");

        LogVisitor consoleLogVisitor = new ConsoleLogVisitor();

        infoLog.accept(consoleLogVisitor);   // "INFO: This is an info message."
        warningLog.accept(consoleLogVisitor); // "WARNING: This is a warning message."
        errorLog.accept(consoleLogVisitor);   // "ERROR: This is an error message."
    }
}
