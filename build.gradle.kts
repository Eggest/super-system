plugins {
    id("java")
}

version = "1.0-RELEASES"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
buildscript {
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/repository/jcenter")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
        }
        // 其他你可能需要的仓库
    }
}

allprojects {
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/repository/jcenter")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
        }
        // 其他你可能需要的仓库
    }
}
tasks.jar {
    // enabled = true
    manifest {
        attributes(mapOf("Main-Class" to "Main"))
        attributes(mapOf("Created-By" to "17.0.11 (Oracle Corporation)"))
    }
}

//tasks.withType<JavaCompile> {
//    options.encoding = "UTF-8"
//}
defaultTasks("clean", "build")