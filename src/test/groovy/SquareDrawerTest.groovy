import org.junit.Test

class SquareDrawerTest {
  @Test
  def void drawSquareOfSize4() {
    def drawer = new SquareDrawer(size: 4)
    def result = drawer.draw()

    assert result == '''xxxx
x  x
x  x
xxxx'''
  }

  @Test
  def void drawSquareOfSize3() {
    def drawer = new SquareDrawer(size: 3)
    def result = drawer.draw()

    assert result == '''xxx
x x
xxx'''
  }

  @Test
  def void drawSquareOfSize1() {
    def drawer = new SquareDrawer(size: 1)
    def result = drawer.draw()

    assert result == 'x'
  }

  @Test
  def void drawSquareOfSize0() {
    def drawer = new SquareDrawer(size: 0)
    def result = drawer.draw()

    assert result == ''
  }

  @Test
  def void drawSquareOfSizeMinus1() {
    def drawer = new SquareDrawer(size: -1)
    def result = drawer.draw()

    assert result == ''
  }
}
