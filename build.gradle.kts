plugins {
    kotlin("jvm") apply false
}

group = "ru.otus.otuskotlin.blog"
version = "0.0.1"

allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }
}