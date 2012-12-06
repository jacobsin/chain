package chain


class WordChainIO {
  Map<String, String> parse(String input) {
    def inputs = input.split(/\s*\n\s*/)
    assert inputs.length == 2, "${inputs.length} words found, expecting exactly 2"
    [from:inputs[0], to:inputs.last()]
  }

  String format(List<String> outputs) {
    outputs.join("\n")
  }
}
