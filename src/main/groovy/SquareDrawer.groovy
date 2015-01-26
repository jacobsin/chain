class SquareDrawer implements ShapeDrawer {

  def int size

  def draw() {
    if (size < 1) return ''

    (0..size-1).collect{i->
      (0..size-1).collect {j->
        isEdge(i, j) ? drawEdge() : ' '
      }.join('')
    }.join('\n')
  }

  def boolean isEdge(i, j) {
    if (i >= size || j >=size) return false
    i == 0 || j == 0 || i == (size - 1) || j == (size - 1)
  }

  @Override
  int size() {
    return size-1
  }

  @Override
  String drawEdge() {
    return 'x'
  }
}
