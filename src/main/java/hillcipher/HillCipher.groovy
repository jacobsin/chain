package hillcipher

import org.math.array.Matrix

class HillCipher {

  static final Matrix DEFAULT_KEY = new Matrix([
      [6, 24, 1],
      [13, 16, 10],
      [20, 17, 15]
  ])

  private static final char A_CHAR = ('A' as char).charValue()

  def decrypt(String encrypted) {
    def inversedKey = inverseMod26(DEFAULT_KEY)
    fromMod26(inversedKey * toMod26(encrypted))
  }

  def encrypt(String decrypted) {
    fromMod26(DEFAULT_KEY * toMod26(decrypted))
  }

  def inverseMod26(Matrix key) {
    int det = Matrix.det(key).round()
    def inversedDet = inverseDetMod26(det)
    adjucate(key) * inversedDet
  }

  def adjucate(Matrix matrix) {
    def a = []
    def rows = matrix.rowsNumber
    def columns = matrix.columnsNumber
    for (int i = 1; i <= rows; i++) {
      a << []
      for (int j = 1; j <= columns; j++) {
        a[-1] << cofactor(matrix,i,j)
      }
    }
    Matrix.transpose(new Matrix(a))
  }

  double cofactor(Matrix matrix, int i, int j) {
    Matrix m = subMatrix(matrix, i, j)
    return (-1)**(i+j) * Matrix.det(m).round()
  }

  Matrix subMatrix(Matrix matrix, int i, int j) {
    def a = []
    def rows = matrix.rowsNumber
    def columns = matrix.columnsNumber
    for (int y = 1; y <= rows; y++) {
      if (y == i) continue;
      a << []
      for (int x = 1; x <= columns; x++) {
        if (x == j) continue;
        a[-1] << matrix[y][x]
      }
    }
    new Matrix(a)
  }

  def inverseDetMod26(int det) {
    (1..25).find {
      (it * det) % 26 == 1
    }
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
