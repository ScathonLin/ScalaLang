package com.scala.learn.technique
/**
 * Scala一些技巧性的语法积累
 */
object ScalaTechnique {
}
object RangeTrans extends App {
  def sum(nums: Int*): Int = {
    var result: Int = 0
    for (num <- nums) {
      result += num
    }
    result
  }

  //  递归方式求解变长数组的和值
  def sum2(nums: Int*): Int = {
    if (nums.length == 0) 0
    else nums.head + sum2(nums.tail: _*)
  }
  // 报错，因为类型不匹配
  //  sum(1 to 5)
  //  解决办法：这一点在spark源码中有很多
  println(sum(1 to 5: _*))
  println(sum2(1 to 5: _*))
}
