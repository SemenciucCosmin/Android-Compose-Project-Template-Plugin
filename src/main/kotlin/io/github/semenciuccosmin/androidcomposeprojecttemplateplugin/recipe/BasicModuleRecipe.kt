package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe

import com.android.tools.idea.wizard.template.RecipeExecutor
import java.io.File

fun RecipeExecutor.createBasicModule(
    rootPath: String,
    module: File,
    packageName: String
) {
    save(
        loadTemplate(
            path = "$rootPath/src/main/AndroidManifest.xml.ftl",
            packageName = packageName
        ),
        module.resolve("src/main/AndroidManifest.xml")
    )

    save(
        loadTemplate(
            path = "$rootPath/build.gradle.kts.ftl",
            packageName = packageName
        ),
        module.resolve("build.gradle.kts")
    )

    save(
        loadTemplate(
            path = "$rootPath/consumer-rules.pro.ftl",
            packageName = packageName
        ),
        module.resolve("consumer-rules.pro")
    )

    save(
        loadTemplate(
            path = "$rootPath/proguard-rules.pro.ftl",
            packageName = packageName
        ),
        module.resolve("proguard-rules.pro")
    )
}