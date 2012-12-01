package chain

import org.junit.Test


class NaiveDictionaryTest {
  def dictionary = new NaiveDictionary()

  @Test
  def void isValid() {
    assert dictionary.isValid('do')
  }

  @Test
  def void isNotValid() {
    assert !dictionary.isValid('moo')
  }

  @Test
  def void findWithOnePattern() {
    assert dictionary.find('.o') == ['do', 'so', 'to']
  }

  @Test
  def void findWithOnePatternNoResult() {
    assert dictionary.find('.y') == []
  }

  @Test
  def void findWithMultiplePatterns() {
    assert dictionary.find(['.o', 'd.']) == ['do', 'so', 'to']
  }

  @Test
  def void findWithMultiplePatternsNoResult() {
    assert dictionary.find(['.y', 'z.']) == []
  }
}
