package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import java.io.File

fun RecipeExecutor.createAppModule(
    moduleData: ModuleTemplateData,
    packageName: String
) {
    val appModule = moduleData.rootDir
    createDetektDirectory(packageName, appModule)

    save(
        loadTemplate(
            path = "app/src/main/kotlin/com/example/androidcomposeprojecttemplate/app/MainActivity.kt.ftl",
            packageName = packageName
        ),
        appModule.resolve("src/main/kotlin/com/example/$packageName/app/MainActivity.kt")
    )

    save(
        loadTemplate(
            path = "app/src/main/AndroidManifest.xml.ftl",
            packageName = packageName
        ),
        appModule.resolve("src/main/AndroidManifest.xml")
    )

    save(
        loadTemplate(
            path = "app/build.gradle.kts.ftl",
            packageName = packageName
        ),
        appModule.resolve("build.gradle.kts.txt")
    )

    save(
        loadTemplate(
            path = "app/proguard-rules.pro.ftl",
            packageName = packageName
        ),
        appModule.resolve("proguard-rules.pro")
    )
}

private fun RecipeExecutor.createDetektDirectory(
    packageName: String,
    destinationDirectory: File
) {
    val detektDirectory = destinationDirectory.resolve("detekt").also { createDirectory(it) }

    save(
        loadTemplate("app/detekt/detekt-baseline.xml.ftl", packageName),
        detektDirectory.resolve("detekt-baseline.xml")
    )

    save(
        loadTemplate("app/detekt/detekt-config.yml.ftl", packageName),
        detektDirectory.resolve("detekt-config.yml")
    )
}
