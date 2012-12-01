package chain


class NaiveDictionary {

  def validWords = [
      "do",
      "it",
      "so",
      "to",
      "ran",
      "raw",
      "saw",
      "you"
  ]

  boolean isValid(String word) {
    validWords.contains(word)
  }
}
