plugins {
    kotlin("multiplatform")
}

group = rootProject.group
version = rootProject.version

kotlin {
    js {
        browser()
        nodejs()
    }
    jvm {
        withJava()
    }

    sourceSets {
        val coroutinesVersion: String by project
        val kotestVersion: String by project
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            val isSortedVersion: String by project
            dependencies {
                implementation(npm("is-sorted", isSortedVersion))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${coroutinesVersion}")
                implementation("io.kotest:kotest-assertions-core-js:${kotestVersion}")
                implementation("io.kotest:kotest-framework-api-js:${kotestVersion}")
                implementation("io.kotest:kotest-framework-engine-js:${kotestVersion}")
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("io.kotest:kotest-runner-junit5:${kotestVersion}")
                implementation("io.kotest:kotest-assertions-core:${kotestVersion}")
            }
        }
    }
}