class CircleDrawer implements ShapeDrawer {
  int radius

  def draw() {
    (0..radius*2).collect{i->
      (0..radius*2).collect {j->
        isEdge(i, j) ? drawEdge() : ' '
      }.join('')
    }.join('\n')
  }

  def boolean isEdge(i, j) {
    (((i-radius).power(2) + (j-radius).power(2)) - radius.power(2)).abs() < radius
  }

  @Override
  int size() {
    return radius * 2
  }

  @Override
  String drawEdge() {
    '*'
  }
}
