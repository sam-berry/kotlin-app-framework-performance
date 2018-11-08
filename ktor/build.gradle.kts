import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.samberry"
version = "1.0"

val ktorVersion = "1.0.0-beta-3"

plugins {
    application
    kotlin("jvm") version "1.3.0"
}

kotlin.experimental.coroutines = Coroutines.ENABLE

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.ktor:ktor-server-netty:$ktorVersion")
    compile("ch.qos.logback:logback-classic:1.2.3")
    testCompile(group = "junit", name = "junit", version = "4.12")
}