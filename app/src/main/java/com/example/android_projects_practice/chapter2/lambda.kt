package com.example.android_projects_practice.chapter2

fun main() {
    val a = fun() {
        println("hello")
    }
    val b: (Int) -> Int = { it ->
        it * 10
    }
    val d = { i: Int, j: Int -> i * j}
    val f: (Int, String, Boolean) -> String = { _, b, _ -> b}

    println( b(10) ) // 100
    println( d(1, 2) ) // 2

    hello(10, b) // 10\n200

}

fun hello(a: Int, b: (Int) -> Int): (Int) -> Int {
    println(a)
    println(b(20))
    return b // return으로 람다함수가 올 수도 있음
}