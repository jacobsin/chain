class CombinedDrawer {
  ShapeDrawer drawer1
  ShapeDrawer drawer2

  def draw() {
    if (size() <= 0) return ''

    (0..size()).collect{i->
      (0..size()).collect {j->
        def edgeDrawer = [drawer1, drawer2].find{ it.isEdge(i, j)}
        if (!edgeDrawer) return ' '
        edgeDrawer.drawEdge()
      }.join('')
    }.join('\n')
  }

  def size() {
    return [drawer1.size(), drawer2.size()].max();
  }
}
