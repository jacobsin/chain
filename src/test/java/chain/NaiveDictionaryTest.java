package chain;

import org.junit.Assert;
import org.junit.Test;


public class NaiveDictionaryTest {
  NaiveDictionary dictionary = new NaiveDictionary();

  @Test
  public void isValid() {
    Assert.assertTrue(dictionary.isValid("do"));
  }
}
