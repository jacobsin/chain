package hillcipher

import org.junit.Test

class KeyGenTest {

  def kegGen = new KeyGen()

  @Test
  def void generate() {
    def generated = kegGen.generate()
    println "${generated.size()} keys"
    println generated.join('\n----\n')
  }
}
