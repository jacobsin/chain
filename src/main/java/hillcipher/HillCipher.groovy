package hillcipher

import org.math.array.Matrix

class HillCipher {

  private static final org.math.array.Matrix DEFAULT_KEY = new Matrix([
      [6, 24, 1],
      [13, 16, 10],
      [20, 17, 15]
  ])
  private static final org.math.array.Matrix INVERSED_KEY = new Matrix([
      [8, 5, 10],
      [21, 8, 21],
      [21, 12, 8]
  ])

  private static final char A_CHAR = ('A' as char).charValue()

  def decrypt(String encrypted) {
    fromMod26(INVERSED_KEY * toMod26(encrypted))
  }

  def encrypt(String decrypted) {
    fromMod26(DEFAULT_KEY * toMod26(decrypted))
  }

  def toMod26(String string) {
    Matrix.transpose(new Matrix(string.toCharArray().collect {
      (it.charValue() - A_CHAR) % 26
    } as double[]))
  }

  def fromMod26(Matrix mod26) {
    new String((Matrix.transpose(mod26).getRowRef(1)).collect {
      (it % 26 + A_CHAR) as char
    } as char[])
  }
}
