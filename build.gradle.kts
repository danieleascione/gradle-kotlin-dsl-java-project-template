apply(from = "versions.gradle.kts")
val junitVersion: String by extra
val jetBrainsAnnotationsVersion: String by extra
val assertjVersion: String by extra
val mockitoVersion: String by extra

plugins {
    java
    application
    idea
}

group = "com.my-group"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains:annotations:$jetBrainsAnnotationsVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.mockito:mockito-inline:$mockitoVersion")
    testImplementation("mockito-junit-jupiter:$mockitoVersion")
}

sourceSets {
    create("integrationTest") {
        java.srcDir("src/integrationTest/java")
        resources.srcDir("src/integrationTest/resources")
        compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
        runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
    }
}

val integrationTest = task<Test>("integrationTest") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath
    shouldRunAfter("test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.check {
    dependsOn(integrationTest)
}
