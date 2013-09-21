package exsim;

public class FixLogonMessage extends FixMessage {

    public FixLogonMessage(String username, String password) {
        headers.put("MsgType", "A");
        headers.put("Username", username);
        headers.put("Password", password);
    }
}
