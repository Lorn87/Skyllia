plugins {
    id("java")
    id("maven-publish")
}
group = "fr.euphyllia.skyllia.hytale"

dependencies {
    compileOnly(files("./libs/HytaleServer.jar"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

publishing {
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "Euphyllia-Repo"
            url = uri("https://repo.euphyllia.moe/repository/maven-releases/")
            credentials {
                username = System.getenv("NEXUS_USERNAME") ?: ""
                password = System.getenv("NEXUS_PASSWORD") ?: ""
            }
        }
    }
}