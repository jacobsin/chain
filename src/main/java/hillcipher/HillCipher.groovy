package hillcipher

class HillCipher {

//  private static final org.math.array.Matrix DEFAULT_KEY = new org.math.array.Matrix([
//      [6, 24, 1],
//      [13, 16, 10],
//      [20, 17, 15]
//  ])
  private static final char A_CHAR = ('A' as char).charValue()

  def decrypt(String encrypted) {

  }

  def encrypt(String decrypted) {
    decrypted
  }

  def toMod26(String string) {
    string.toCharArray().collect {
      (it.charValue() - A_CHAR) % 26
    }
  }

  def fromMod26(mod26) {
    new String(mod26.collect {
      (it + A_CHAR) as char
    } as char[])
  }
}
