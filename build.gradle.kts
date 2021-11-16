import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    java
    application
    idea
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
//    implemen  ¡¡tation("org.jetbrains:annotations:$jetBrainsAnnotationsVersion")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
//
//    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
//    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
//    testImplementation("org.assertj:assertj-core:$assertjVersion")
//    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    // Testing
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
