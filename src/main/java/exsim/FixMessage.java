package exsim;

import com.google.common.collect.Maps;

import java.util.Map;

public class FixMessage {
    protected Map<String, String> headers = Maps.newHashMap();

    public String getHeader(String key) {
        return headers.get(key);
    }
}
