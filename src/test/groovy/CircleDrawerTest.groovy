import org.junit.Test

import static org.junit.Assert.assertEquals

class CircleDrawerTest {

  @Test
  def void drawCircleOfRadius1() {
    def result = new CircleDrawer(radius : 1).draw()
    assertEquals(' * \n' +
                 '* *\n' +
                 ' * ', result)
  }

  @Test
  def void drawCircleOfRadius4() {
    def result = new CircleDrawer(radius : 4).draw()
    assertEquals(
        '   ***   \n' +
        ' **   ** \n' +
        ' *     * \n' +
        '*       *\n' +
        '*       *\n' +
        '*       *\n' +
        ' *     * \n' +
        ' **   ** \n' +
        '   ***   ', result)
  }
}
