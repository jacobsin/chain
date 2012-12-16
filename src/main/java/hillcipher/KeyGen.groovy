package hillcipher

import org.math.array.Matrix

class KeyGen {
  def maxValid = 6
  def dimensions = [1, 2]

  def generate() {
    dimensions.collectMany {
      generate(it)
    }
  }

  def generate(dimension) {
    def generated = []

    def permutations = maxValid ** (dimension ** 2)
    (0..<permutations).each {p ->
      def a = []
      (0..<dimension).each {i ->
        a << []
        (0..<dimension).each {j ->
          a[-1] << (Math.floor(p / (maxValid ** (dimension * i + j)))) % maxValid
        }
      }
      def matrix = new Matrix(a)
      if (inversible(matrix)) {
        generated << matrix
      }
    }
    generated
  }

  def inversible(Matrix matrix) {
    def determinant = Matrix.det(matrix)
    determinant != 0 && determinant % 2 != 0 && determinant % 13 != 0
  }

}
