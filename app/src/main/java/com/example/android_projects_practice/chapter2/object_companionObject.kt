package com.example.android_projects_practice.chapter2

fun main() {
    Counter // Counter가 초기화 됨
    println(Counter.count) // 0
    Counter.countUp()
    Counter.countUp()

    println(Counter.count) // 2

    Counter.hello() // hello

    println(Book.NAME) // Book을 선언하지 않아도 NAME 사용 가능
    Book.create()

}

object Counter: Hello() { // Counter()처럼 생성자는 쓸 수 없음
    init {
        println("카운터 초기화")
    }
    var count = 0
    fun countUp() {
        count++
    }
}

open class Hello() {
    fun hello() = println("Hello")
}

class Book {
    companion object Novel { // Novel처럼 이름을 붙일 수도 있다.
        val NAME = "hello"
        fun create() = Book()
    }

    val k = "1"
}