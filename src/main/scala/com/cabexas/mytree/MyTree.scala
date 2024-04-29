package com.cabexas.mytree

enum MyTree[A] {
  case Leaf(value: A)
  case Node(left: MyTree[A], right: MyTree[A])

  def size: Int =
    this match
      case Leaf(value)       => 1
      case Node(left, right) => left.size + right.size

  def size2: Int = fold(_ => 1)(_ + _)

  def contains(a: A): Boolean =
    this match
      case Leaf(value)       => value == a
      case Node(left, right) => left.contains(a) || right.contains(a)

  def contains2(a: A): Boolean = fold(_ == a)(_ || _)

  def map[B](f: A => B): MyTree[B] =
    this match
      case Leaf(value)       => Leaf(f(value))
      case Node(left, right) => Node(left.map(f), right.map(f))

  // had issues coming up with the rigth solution
  def map2[B](f: A => B): MyTree[B] =
    this.fold(a => Leaf(f(a)))((left, right) => Node(left, right))

  def fold[B](leaf: A => B)(node: (B, B) => B): B =
    this match
      case Leaf(value) => leaf(value)
      case Node(left, right) =>
        node(left.fold(leaf)(node), right.fold(leaf)(node))

}
