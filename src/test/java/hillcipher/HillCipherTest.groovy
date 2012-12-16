package hillcipher

import org.junit.Test
import org.math.array.Matrix

class HillCipherTest {
  def cipher = new HillCipher()

  @Test
  void encrypt() {
    assert cipher.encrypt("ACT") == "POH"
    assert cipher.encrypt("CAT") == "FIN"
  }

  @Test
  void decrypt() {
    assert cipher.decrypt("POH") == "ACT"
    assert cipher.decrypt("FIN") == "CAT"
  }

  @Test
  def void toMod26() {
    assert cipher.toMod26("ACT") == Matrix.transpose(new Matrix([0, 2, 19]))
  }

  @Test
  def void fromMod26() {
    assert cipher.fromMod26(Matrix.transpose(new Matrix([0, 2, 19]))) == "ACT"
  }

  @Test
  def void inverse() {
    assert cipher.inverseMod26(cipher.DEFAULT_KEY) == cipher.INVERSED_KEY
  }
}
