package chain


class NaiveDictionary {

  def validWords = [
      "do",
      "it",
      "so",
      "to",
      "ran",
      "raw",
      "run",
      "saw",
      "you"
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
