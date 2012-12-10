package chain


class NaiveDictionary {

  def validWords = [
      "at",
      "do",
      "it",
      "so",
      "to",
      "law",
      "ran",
      "raw",
      "row",
      "run",
      "saw",
      "you",
      "easy",
      "good",
      "test",
      "solution",
      "existing"
  ]

  boolean isValid(String word) {
    validWords.contains(word)
  }

  List<String> find(List<String> patterns) {
    patterns.collectMany {String it->find(it)}.unique()
  }

  List<String> find(String pattern) {
    validWords.findAll {it.matches(pattern)}
  }
}
