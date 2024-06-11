package com.example.android_projects_practice.chapter2

fun main() {
    val person = Person("수지", 24)
    val dog = Dog("해피", 24)

    println(person.toString()) // com.example.android_projects_practice.chapter2.Person@6e8cf4c6
    println(dog.toString())   // Dog(name=해피, age=24)

    println(dog.copy(age = 3).toString()) // Dog(name=해피, age=3)

    val cat: Cat = BlueCat() // abstract class
    val result = when(cat) {
        is BlueCat -> {"blue"}
        is RedCat -> {"red"}
        is GreenCat -> {"green"}
        else -> "none"
    }

    val cat2: Cat2 = BlueCat2() // sealed class
    val result2 = when(cat2) { // 컴파일러가 sealed class의 자식들을 알기 때문에 else 필요없음
        is BlueCat2 -> {"blue"}
        is RedCat2 -> {"red"}
        is GreenCat2 -> {"green"}
    }
}

class Person(
    val name: String,
    val age: Int
)

data class Dog(       // 반드시 프로퍼티 한 개 이상 필요, 상속 불가
    val name: String,
    val age: Int
)

abstract class Cat
class BlueCat: Cat()
class RedCat: Cat()
class GreenCat: Cat()

sealed class Cat2
class BlueCat2: Cat2()
class RedCat2: Cat2()
class GreenCat2: Cat2()
