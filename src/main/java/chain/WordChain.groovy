package chain


class WordChain {
  def differenceCount = 0
  def nextStepPatterns = []
  String from
  String to
  WordChain next

  WordChain(String from, String to) {
    this.from = from
    this.to = to
    compare()
  }

  WordChain(String from, WordChain next) {
    this.from = from
    this.to = next.from
    this.next = next
  }

  def compare() {
    [from.toCharArray(), to.toCharArray()].transpose().eachWithIndex{it, i->
      if (it[0] != it[1]) {
        differenceCount++

        def nextStepPattern = new StringBuilder(from)
        nextStepPattern.setCharAt(i, '.' as char)
        nextStepPatterns << nextStepPattern.toString()
      }
    }
  }

  def static differenceCount(String from, String to) {
    [from.toCharArray(), to.toCharArray()].transpose().sum{it[0] != it[1] ? 1: 0}
  }

  WordChain leftShift(String from) {
    new WordChain(from, this)
  }

  List<String> toList() {
    if (next) return [from, *next.toList()]
    [from, to]
  }

  WordChain optimize() {
    def next = this.next
    while(next) {
      if (differenceCount(this.from, next.to) == 1) {
        this.next = next.next
      }
      next = next.next
    }
    this.next?.optimize()
  }

  String toString() {
    toList().join(" > ")
  }
}
