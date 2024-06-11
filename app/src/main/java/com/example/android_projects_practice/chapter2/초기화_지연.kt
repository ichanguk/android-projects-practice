package com.example.android_projects_practice.chapter2

//var text: String? = null
lateinit var text: String // nullable 타입 보다 lateinit을 사용하면 좋음
// lateinit var age: Int // primitive는 사용 불가

val test: Int by lazy {
    println("초기화 중")
    100
} // 호출 시점에 초기화 됨

fun main() {
    text = "main"

    println(text)

    println("초기화 한 값 $test") // 처음 사용됐기 때문에 초기화 중이 print 되고 초기화 한 값 100이 출력
    println("두 번째 호출 $test") // 두 번째부터는 초기화 중이 print 안됨
}