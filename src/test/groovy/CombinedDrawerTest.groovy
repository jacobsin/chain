import org.junit.Test

import static org.junit.Assert.assertEquals

class CombinedDrawerTest {

  @Test
  def void drawSquareOfSize3OnTopOfSquareOfSize6() {
    def drawer = new CombinedDrawer(drawer1: new SquareDrawer(size: 3),
                                    drawer2: new SquareDrawer(size: 6))
    def result = drawer.draw()

    assertEquals('xxxxxx\n' +
                 'x x  x\n' +
                 'xxx  x\n' +
                 'x    x\n' +
                 'x    x\n' +
                 'xxxxxx', result)
  }


  @Test
  def void drawSquareOfSize4OnTopOfSquareOfRadius4() {
    def drawer = new CombinedDrawer(drawer1: new SquareDrawer(size: 4),
                                    drawer2: new CircleDrawer(radius: 4))
    def result = drawer.draw()

    assertEquals(
            'xxxx**   \n' +
            'x**x  ** \n' +
            'x* x   * \n' +
            'xxxx    *\n' +
            '*       *\n' +
            '*       *\n' +
            ' *     * \n' +
            ' **   ** \n' +
            '   ***   ', result)
  }
}
