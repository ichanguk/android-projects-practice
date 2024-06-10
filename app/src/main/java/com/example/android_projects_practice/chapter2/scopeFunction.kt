package com.example.android_projects_practice.chapter2

fun main() {
    // let, run, apply, also, with
    // let
    val a = 3
    a.let {  }
    val user: User? = User("홍길동", 10, true)

    // 수신객체.let {
    //
    // 마지막 줄 // return
    // }
    val age = user.let {
        it?.age
    }
    println(age) // 10

    // nullable을 변수에 할당하고 싶을 때 사용하면 좋음
    val gender = user?.let {
        it.gender
    }

    // run : let과 다르게 this만 사용할 수 있음
    // 수신객체.run { this ->
    //
    // 마지막 줄 // return
    // }
    val kid = User("아이", 4, false)
    val kidAge = kid.run {
        age
    }
    println(kidAge) // 4

    // apply
    // 수신객체.apply {
    //     ...
    // }
    // return 값이 수신객체
    val kidName = kid.apply {
        name
    }
    println(kidName) // com.example.android_projects_practice.chapter2.User@7cc355be
                     // 객체가 반환

    val femail = User("슬기", 20, true, true)
    val femailValue = femail.apply {
        hasGlasses = false
    }
    println(femail.hasGlasses) // false
    println(femailValue.hasGlasses) // false

    // also : apply와 다르게 it 사용 가능
    // 수신객체.also { it ->
    //
    //
    // } return 수신객체
    val male = User("민수", 17, false, true)
    val maleValue = male.also {
        it.name
        it.hasGlasses = false
    }
    println(maleValue.hasGlasses)
    println(maleValue.age)

    // 보통 also 문 안에서 뭘 변화시키진 않음
//    val maleValue = male.also {
//        println(it.name)
//    }

    // with
    // with(수신객체) {
    //
    // 마지막줄 return
    // }
    val result = with(male) {
        hasGlasses = false
        hasGlasses
    }
    println(result) // false

}

class User(
    val name: String,
    val age: Int,
    val gender: Boolean,
    var hasGlasses : Boolean = true
)