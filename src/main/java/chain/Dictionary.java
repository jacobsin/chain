package chain;


import java.util.List;

interface Dictionary {
    boolean isValid(String word);

    List<String> find(List<String> patterns);

    List<String> find(String pattern);
}
