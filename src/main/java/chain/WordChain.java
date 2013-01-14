package chain;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.codehaus.plexus.util.StringUtils;

import java.util.Arrays;
import java.util.List;


public class WordChain {
  int differenceCount = 0;
  List<String> nextStepPatterns = Lists.newArrayList();
  String from;
  String to;
  WordChain next;

  WordChain(String from, String to) {
    this.from = from;
    this.to = to;
    compare();
  }

  WordChain(String from, WordChain next) {
    this.from = from;
    this.to = next.from;
    this.next = next;
  }

  void compare() {
      int i = 0;
      char[] toChars = to.toCharArray();
      for (char fromChar  : from.toCharArray()) {
          char toChar = toChars[i];
          if (fromChar != toChar) {
              differenceCount++;

              StringBuilder nextStepPattern = new StringBuilder(from);
              nextStepPattern.setCharAt(i, '.');
              nextStepPatterns.add(nextStepPattern.toString());
          }
          i++;
      }
  }

  static int differenceCount(String from, String to) {
      int i = 0;
      int count = 0;
      char[] toChars = to.toCharArray();
      for (char fromChar  : from.toCharArray()) {
          char toChar = toChars[i];
          if (fromChar != toChar) {
              count++;
          }
          i++;
      }
      return count;
  }

  WordChain leftShift(String from) {
    return new WordChain(from, this);
  }

  List<String> toList() {
    if (next != null) return Lists.newArrayList(Iterables.concat(Arrays.asList(from), next.toList()));
    return Arrays.asList(from, to);
  }

  WordChain optimize() {
    WordChain next = this.next;
    while(next != null) {
      if (differenceCount(this.from, next.to) == 1) {
        this.next = next.next;
      }
      next = next.next;
    }
    return this.next != null ? this.next.optimize() : null;
  }

  public String toString() {
    return StringUtils.join(toList().iterator(), " > ");
  }
}
