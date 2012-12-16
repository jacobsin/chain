package hillcipher

import org.junit.Test
import org.math.array.Matrix

class HillCipherTest {
  def cipher = new HillCipher()

  @Test
  void encrypt() {
    assert cipher.encrypt("ACT") == "POH"
  }

  @Test
  void decrypt() {
    assert cipher.decrypt("POH") == "ACT"
  }

  @Test
  def void toMod26() {
    assert cipher.toMod26("ACT") == Matrix.transpose(new Matrix([0, 2, 19]))
  }

  @Test
  def void fromMod26() {
    assert cipher.fromMod26(Matrix.transpose(new Matrix([0, 2, 19]))) == "ACT"
  }
}
