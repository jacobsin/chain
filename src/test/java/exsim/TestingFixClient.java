package exsim;

public class TestingFixClient {

    private FixMessage lastResponse = null;
    private TestingFixTransport transport = new TestingFixTransport();

    public void login(String username, String password) {
        lastResponse = transport.send(new FixLogonMessage(username, password));
    }

    public FixMessage getLastResponse() {
        return lastResponse;
    }
}
