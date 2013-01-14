package chain;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.*;
import java.util.*;

public class WordChainSolver {

  WordChainIO io = new WordChainIO();
  Dictionary dictionary;
  Set<String> visited = Sets.newHashSet();

  static void main(String[] args) throws IOException {
    new WordChainSolver().solveMany(System.in, System.out);
  }

  public void solveMany(InputStream input, OutputStream output) throws IOException {
      BufferedReader reader = IOUtils.toBufferedReader(new InputStreamReader(input));
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
      int cases = Integer.parseInt(reader.readLine());
      for (int i = 1; i <= cases; i++) {
          writer.write(solve(reader.readLine()));
          writer.write("\n");
      }
      writer.flush();
  }

  String solve(String input) throws IOException {
    Map<String, String> parsed = io.parse(input);
    return io.format(solve(parsed.get("from"), parsed.get("to")));
  }

  List<String> solve(String from, String to) throws IOException {
    initialise(from.length());
    validate(from, to);
    WordChain solved = doSolve(new WordChain(from, to));
    if (solved != null) {
      solved.optimize();
      return solved.toList();
    }
    throw new NoSolutionFoundException(from, to);
  }

  void initialise(int length) throws IOException {
    dictionary = new ScowlDictionary(length);
  }

  WordChain doSolve(WordChain chain) {
    visited.add(chain.from);
    if (chain.differenceCount < 2) {
      return chain;
    } else {
      List<WordChain> nextSteps = findNextSteps(chain);
      for (WordChain nextStep : nextSteps) {
        WordChain solved = doSolve(nextStep);
        if (solved != null) {
          return solved.leftShift(chain.from);
        }
      }
      return null;
    }
  }

  List<WordChain> findNextSteps(final WordChain chain) {
    List<WordChain> nextSteps = Lists.newArrayList(Iterables.transform(Iterables.filter(dictionary.find(chain.nextStepPatterns), new Predicate<String>() {
      @Override
      public boolean apply(String it) {
        return !visited.contains(it);
      }
    }), new Function<String, WordChain>() {
      @Override
      public WordChain apply(String it) {
        return new WordChain(it, chain.to);
      }
    }));

    Collections.sort(nextSteps, new Comparator<WordChain>() {
        @Override
        public int compare(WordChain chain1, WordChain chain2) {
            return Integer.valueOf(chain1.differenceCount).compareTo(chain2.differenceCount);
        }
    });
    return nextSteps;
  }

  void validate(String from, String to) {
    Assert.assertEquals(String.format("invalid to word length (%s), should be same length as from word (%s)", to.length(), from.length()), from.length(), to.length());
    Assert.assertTrue(String.format("invalid from word (%s)", from), dictionary.isValid(from));
    Assert.assertTrue(String.format("invalid to word (%s)", to), dictionary.isValid(to));
  }

}

