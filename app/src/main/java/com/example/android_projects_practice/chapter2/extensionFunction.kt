package com.example.android_projects_practice.chapter2

fun main() {
    val test = Test()
    Test().hello()
    Test().hi()
    test.hi()

}

fun Test.hi() = println("하이")

class Test() {
    fun hello() = println("안녕")
    fun bye() = println("잘가")
}