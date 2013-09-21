package exsim;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginAcceptanceTest {

    private ExchangeSimulator simulator;
    private TestingFixClient client;

    @Before
    public void before() {
        simulator = new ExchangeSimulator();
        client = new TestingFixClient();
    }

    @Test
    public void loginSuccess() {
        client.login("registered_user", "correct_password");

        List<String> users = simulator.getLoggedOnUsers();
        Assert.assertThat(users, equalTo(asList("registered_user")));

        FixMessage response = client.getLastResponse();
        Assert.assertThat(response.getHeader("MsgType"), equalTo("A"));
        Assert.assertThat(response.getHeader("Username"), equalTo("registered_user"));
    }

    @Test
    public void loginFailedWhenPasswordIncorrect() {
        client.login("registered_user", "incorrect_password");

        List<String> users = simulator.getLoggedOnUsers();
        Assert.assertThat(users, equalTo(Collections.EMPTY_LIST));

        FixMessage response = client.getLastResponse();
        Assert.assertThat(response.getHeader("MsgType"), equalTo("5"));
    }
}
