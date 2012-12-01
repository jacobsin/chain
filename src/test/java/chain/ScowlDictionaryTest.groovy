package chain

import org.junit.Test


class ScowlDictionaryTest {
  def dictionary = new ScowlDictionary(2)

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
    assert dictionary.find('.o').containsAll(['do', 'so', 'to'])
  }

  @Test
  def void findWithOnePatternNoResult() {
    assert dictionary.find('.z') == []
  }

  @Test
  def void findWithMultiplePatterns() {
    assert dictionary.find(['.o', 'd.']).containsAll(['do', 'so', 'to'])
  }

  @Test
  def void findWithMultiplePatternsNoResult() {
    assert dictionary.find(['.z', 'z.']) == []
  }
}
