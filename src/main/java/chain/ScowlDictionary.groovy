package chain


class ScowlDictionary implements Dictionary {

  def dictionaryDir = "src/main/resources/dictionary/scowl/final"
  def dictionaryFiles = ["english-words": 50]
  def validWords = []

  ScowlDictionary(int length) {
    initialize(length)
  }

  private void initialize(int length) {
    dictionaryFiles.each { filename, maxSuffix ->
      (10..maxSuffix).step(5) { suffix ->
        def file = new File("${dictionaryDir}/${filename}.${suffix}")
        if (file.exists()) {
          read(file, length)
        } else {
          def stream = this.class.classLoader.getResourceAsStream("${dictionaryDir}/${filename}.${suffix}")
          if (stream) {
            read(stream, length)
          }
        }
      }
    }
  }

  private read(toRead, int length) {
    toRead.withReader { r ->
      r.eachLine { read ->
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
    patterns.collectMany { String it -> find(it) }.unique()
  }

  List<String> find(String pattern) {
    validWords.findAll { it.matches(pattern) }
  }
}
