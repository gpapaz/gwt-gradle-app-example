package github.gwt.gradle.example.shared;

public class ServerHealth {
    private String status;

    public ServerHealth() {
    }

    public ServerHealth(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
