package com.scala.learn.trait_part
/**
 * 特质的学习
 * scala与Java一样不支持多继承机制，scala提供的是特质不是接口
 * 特质同时可以拥有抽象方法和具体方法，而类可以实现多个特质
 */
object TraitPart {
	def main(args: Array[String]): Unit = {
		func02()
	}

	def func02() {
		trait ConsoleLogger {
			def log(msg: String) { println(msg) }
		}
		class Account {
			var id: Int = 0
			var name: String = "default"
			var balance: Double = 0.0

			def this(id: Int, name: String) {
				this() //不可少这一句
				this.id = id
				this.name = name
			}
			def this(id: Int, name: String, balance: Double) {
				this(id, name)
				this.balance = balance
			}
			def deposit(amount: Double) {

			}
			override def toString(): String = {
				return "Account:[id:" + id + ",name:" + name + ",balance:" + balance + "]"
			}
		}
		/*
		 * 这里的SavingAccount从ConsoleLogger特质中获得了一个具体的log实现，
		 * 如果是Java中接口无法实现的
		 */
		class SavingAccount(id: Int, name: String, balance: Double) extends Account(id, name, balance) with ConsoleLogger {

			def withdraw(amount: Double) {
				if (amount > balance) {
					log("Insufficient funds")
				} else {
					balance_=(balance - amount)
				}
			}
		}
		val account = new SavingAccount(1, "linhd", 2000.0)
		println(account.toString())
		account.withdraw(1000)
		println(account.toString())
		account.withdraw(1000)
		println(account.toString())
		account.withdraw(1000)
		println(account.toString())
	}

	/*
	 * 不带具体实现的特质
	 */
	def func01() {
		/*
		 * 当做接口使用的特质
		 */
		trait Logger {
			def log(msg: String) //这是个抽象方法
		}
		/*
		 *  方法不需要声明为abstract，未实现的方法默认就是抽象的
		 *
		 *  如果实现多个特质，语法格式如下：
		 *  class ConsoleLogger extends Logger with Cloneable with Serializable
		 *  所有的Java接口都可以作为scala特质进行使用
		 */
		class ConsoleLogger extends Logger { //用extends不是Java中的implements
			def log(msg: String) { println(msg) } //不用写override关键字
		}
	}
}
