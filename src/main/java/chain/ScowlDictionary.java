package chain;


import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScowlDictionary implements Dictionary {

    String dictionaryDir = "src/main/resources/dictionary/scowl/final";
    Map<String, Integer> dictionaryFiles;
    List<String> validWords = Lists.newArrayList();

    public ScowlDictionary(int length) throws IOException {
        dictionaryFiles = Maps.newHashMap();
        dictionaryFiles.put("english-words", 50);
        initialize(length);
    }

    private void initialize(int length) throws IOException {
        for (Map.Entry<String, Integer> dictionaryFile : dictionaryFiles.entrySet()) {
            String filename = dictionaryFile.getKey();
            int maxSuffix = dictionaryFile.getValue();

            for (int i = 10; i <= maxSuffix; i += 5) {
                int suffix = i;
                String path = String.format("%s/%s.%s", dictionaryDir, filename, suffix);
                File file = new File(path);
                if (file.exists()) {
                    read(FileUtils.openInputStream(file), length);
                } else {
                    InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);
                    if (stream != null) {
                        read(stream, length);
                    }
                }
            }
        }
    }

    private void read(InputStream toRead, int length) throws IOException {
        LineIterator iterator = IOUtils.lineIterator(toRead, Charset.defaultCharset());

        while (iterator.hasNext()) {
            String read = iterator.next();
            if (read.length() == length && !read.contains("'")) {
                validWords.add(read);
            }
        }
    }

    public boolean isValid(String word) {
        return validWords.contains(word);
    }

    public List<String> find(List<String> patterns) {
        Set<String> results = Sets.newLinkedHashSet();
        for (String pattern : patterns) {
            results.addAll(find(pattern));
        }
        return Lists.newArrayList(results);
    }

    public List<String> find(final String pattern) {
        return Lists.newArrayList(Iterables.filter(validWords, new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return s.matches(pattern);
            }
        }));
    }
}
