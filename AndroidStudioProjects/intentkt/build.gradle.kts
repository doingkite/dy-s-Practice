import org.apache.tools.ant.util.JavaEnvUtils.VERSION_1_8

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
// 프로젝트 루트의 build.gradle.kts 파일
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0") // AGP 버전 8.1.0 이상으로 수정
    }
}
val sourceCompatibility by extra(VERSION_1_8)
