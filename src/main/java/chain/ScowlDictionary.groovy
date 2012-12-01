package chain


class ScowlDictionary implements Dictionary {

  def validWords = []

  ScowlDictionary(int length) {
    initialize(length)
  }

  private void initialize(int length) {
    new File('src/main/resources/dictionary/scowl/final/english-words.10').withReader {r ->
      r.eachLine {read->
        if (read.length() == length && !read.contains('\'')) {
          validWords.add(read)
        }
      }
    }
  }

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
