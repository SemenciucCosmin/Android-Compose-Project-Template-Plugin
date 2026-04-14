package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.createGradle(
    moduleData: ModuleTemplateData,
    packageName: String
) {
    val projectDirectory = moduleData.rootDir.parentFile
    val gradleDirectory = moduleData.rootDir.parentFile.resolve("gradle").also { createDirectory(it) }

    save(
        loadTemplate(
            path = "gradle/libs.versions.toml.ftl",
            packageName = packageName
        ),
        gradleDirectory.resolve("libs.versions.toml.txt")
    )

    save(
        loadTemplate(
            path = "gradle/wrapper/gradle-wrapper.properties.ftl",
            packageName = packageName
        ),
        gradleDirectory.resolve("wrapper/gradle-wrapper.properties.txt")
    )

    save(
        loadTemplate(
            path = "build.gradle.kts.ftl",
            packageName = packageName
        ),
        projectDirectory.resolve("build.gradle.kts.txt")
    )

    save(
        loadTemplate(
            path = "gradle.properties.ftl",
            packageName = packageName
        ),
        projectDirectory.resolve("gradle.properties.txt")
    )

    save(
        loadTemplate(
            path = "local.properties.ftl",
            packageName = packageName
        ),
        projectDirectory.resolve("local.properties.txt")
    )

    save(
        loadTemplate(
            path = "settings.gradle.kts.ftl",
            packageName = packageName
        ),
        projectDirectory.resolve("settings.gradle.kts.txt")
    )

    save(
        """
            #!/bin/bash
            mv build.gradle.kts.txt build.gradle.kts
            mv settings.gradle.kts.txt settings.gradle.kts
            mv gradle/libs.versions.toml.txt gradle/libs.versions.toml
            mv gradle/wrapper/gradle-wrapper.properties.txt gradle/wrapper/gradle-wrapper.properties
            mv app/build.gradle.kts.txt app/build.gradle.kts
            echo "Done! Now sync Gradle in Android Studio."
        """.trimIndent(),
        projectDirectory.resolve("setup.sh")
    )
}
