plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.demo.mylibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
//    publishing {
//        singleVariant("release") {
//            withSourcesJar()
//            withJavadocJar()
//        }
//    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")

    // 第三方依赖
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("org.greenrobot:eventbus:3.2.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.squareup.okio:okio:3.6.0")
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.a1s2d333"
                artifactId = "my-library-toast"
                version = "2.0.0"

                // 添加源码和 Javadoc 包
                val sourcesJar by tasks.creating(Jar::class) {
                    archiveClassifier.set("sources")
                    from(android.sourceSets["main"].java.srcDirs)
                }

                val javadocJar by tasks.creating(Jar::class) {
                    archiveClassifier.set("javadoc")
                    from("$buildDir/docs/javadoc")
                }

                artifact(sourcesJar)
                artifact(javadocJar)

                pom {
                    name.set("My Library")
                    description.set("A library for displaying toasts")
                    url.set("https://github.com/a1s2d333/repo-library")
                    licenses {
                        license {
                            name.set("MIT")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }
                    developers {
                        developer {
                            id.set("a1s2d333")
                            name.set("dsr")
                            email.set("1261903053@qq.com")
                        }
                    }
                    scm {
                        url.set("https://github.com/a1s2d333/repo-library")
                    }
                }
            }
        }
    }
}

//afterEvaluate {
//    publishing {
//        publications {
//            create<MavenPublication>("release") {
//                from(components["release"])
//                groupId = "com.github.a1s2d333"
//                artifactId = "my-library-toast"
//                version = "2.0.0"
//
//                pom {
//                    name.set("My Library Toast")
//                    description.set("An Android library that uses EventBus.")
//                    url.set("https://github.com/a1s2d333/repo-library")
//
//                    licenses {
//                        license {
//                            name.set("MIT License")
//                            url.set("https://opensource.org/licenses/MIT")
//                        }
//                    }
//
//                    developers {
//                        developer {
//                            id.set("a1s2d333")
//                            name.set("dsr")
//                            email.set("1261903053@qq.com")
//                        }
//                    }
//
//                    scm {
//                        url.set("https://github.com/a1s2d333/repo-library")
//                    }
//                }
//            }
//        }
//    }
//}
