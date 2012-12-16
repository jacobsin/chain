package hillcipher

import org.math.array.Matrix

class KeyGen {
  def validValues = (0..5)
  def maxDimension = 4

  def generate() {
    (1..maxDimension).collectMany{
      def a = []
      (0..<it).each {x->
        a << []
        (0..<it).each {y->
          a[-1] << 0
        }
      }
      [new Matrix(a)]
    }
  }
}
