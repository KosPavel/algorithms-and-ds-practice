import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "me.pkostrygin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("script-runtime"))
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    implementation("org.jetbrains.kotlin:kotlin-test:1.5.31")
    implementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.31")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}