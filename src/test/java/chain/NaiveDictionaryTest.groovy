package chain

import org.junit.Test


class NaiveDictionaryTest {
  def dictionary = new NaiveDictionary()

  @Test
  def void isValid() {
    assert dictionary.isValid('do')
  }
}
