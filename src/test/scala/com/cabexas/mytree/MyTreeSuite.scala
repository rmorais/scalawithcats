package com.cabexas.mytree

import com.cabexas.mytree.MyTree.*

class MyTreeSuite extends munit.FunSuite {
  test("Tree#Leaf#size") {
    val tree: MyTree[Int] = Leaf(1)

    assertEquals(tree.size, 1)
    assertEquals(tree.size2, tree.size)
  }

  test("Tree#Node#size") {
    val tree: MyTree[Int] = Node(Leaf(1), Leaf(1))

    assertEquals(tree.size, 2)
    assertEquals(tree.size2, tree.size)
  }

  test("Tree#Nodes#size") {
    val tree: MyTree[Int] = Node(Node(Leaf(1), Leaf(2)), Node(Leaf(3), Leaf(4)))

    assertEquals(tree.size, 4)
    assertEquals(tree.size2, tree.size)
  }

  test("Tree#Leaf#map") {
    val tree: MyTree[Int] = Leaf(1)
    val expected: MyTree[Int] = Leaf(2)

    assertEquals(tree.map(_ * 2), expected)
    assertEquals(tree.map2(_ * 2), tree.map(_ * 2))
  }

  test("Tree#Node#map") {
    val tree: MyTree[Int] = Node(Leaf(1), Leaf(2))
    val expected: MyTree[Int] = Node(Leaf(2), Leaf(4))

    assertEquals(tree.map(_ * 2), expected)
    assertEquals(tree.map2(_ * 2), tree.map(_ * 2))
  }

  test("Tree#Nodes#map") {
    val tree: MyTree[Int] = Node(Node(Leaf(1), Leaf(2)), Node(Leaf(3), Leaf(4)))
    val expected: MyTree[Int] =
      Node(Node(Leaf(2), Leaf(4)), Node(Leaf(6), Leaf(8)))

    assertEquals(tree.map(_ * 2), expected)
    assertEquals(tree.map2(_ * 2), tree.map(_ * 2))
  }

}
