package chain;


import com.google.common.collect.Maps;
import org.codehaus.plexus.util.StringUtils;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

class WordChainIO {
    Map<String, String> parse(String input) {
        String[] inputs = input.split("\\s* \\s*");
        Assert.assertEquals(String.format("%s words found, expecting exactly 2", inputs.length), 2, inputs.length);

        Map<String, String> parsed = Maps.newHashMap();
        parsed.put("from", inputs[0]);
        parsed.put("to", inputs[1]);
        return parsed;
    }

    String format(List<String> outputs) {
        return StringUtils.join(outputs.iterator(), "->");
    }
}
