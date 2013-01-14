package chain


class ScowlDictionary implements Dictionary {

  def dictionaryDir = "src/main/resources/dictionary/scowl/final"
  def dictionaryFiles = ["english-words": 50]
  def validWords = []

  ScowlDictionary(int length) {
    initialize(length)
  }

  private void initialize(int length) {
    dictionaryFiles.each {filename, maxSuffix ->
      (10..maxSuffix).step(5) {suffix ->
        def file = new File("${dictionaryDir}/${filename}.${suffix}")
        if (file.exists()) {
          loadFile(file, length)
        }
      }
    }

  }

  private void loadFile(File file, int length) {
    file.withReader {r ->
      r.eachLine {read ->
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
    patterns.collectMany {String it -> find(it)}.unique()
  }

  List<String> find(String pattern) {
    validWords.findAll {it.matches(pattern)}
  }
}
