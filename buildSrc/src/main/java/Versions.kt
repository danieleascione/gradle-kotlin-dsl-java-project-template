object Versions {

    val jetBrainsAnnotationsVersion = "20.1.0"
    val java = JavaVersion.VERSION_17
    val kotlinVersion = "1.5.31"

    object Release {
        val group = "com.my-group"
        val version = "1.0-SNAPSHOT"
    }

    object ClassPaths {
        val kotlinGradlePluginClasspath = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        val jetBrainsAnnotation = "org.jetbrains:annotations:${Versions.jetBrainsAnnotationsVersion}"
    }

    object Tests {
        val junit = "5.7.0"
        val assertjVersion = "3.11.1"
        val mockitoVersion = "3.7.7"
    }

    object TestLibraries {
        val junitVersion = "5.7.0"
        val assertjVersion = "3.11.1"
        val mockitoVersion = "3.7.7"

        val junitEngine = "org.junit.jupiter:junit-jupiter-engine:${junitVersion}"
        val junitApi = "org.junit.jupiter:junit-jupiter-api:${junitVersion}"
        val junitParam = "org.junit.jupiter:junit-jupiter-params:$junitVersion"
        val assertj = "org.assertj:assertj-core:$assertjVersion"
        val mockito = "org.mockito:mockito-core:$mockitoVersion"
    }
}
