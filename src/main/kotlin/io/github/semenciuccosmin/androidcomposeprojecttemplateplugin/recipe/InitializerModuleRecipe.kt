package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.createInitializerModule(
    moduleData: ModuleTemplateData,
    packageName: String
) {
    val initializerModule = moduleData.rootDir.parentFile.resolve("initializer").also { createDirectory(it) }

    save(
        loadTemplate(
            path = "initializer/src/main/kotlin/com/example/initializer/AppInitializer.kt.ftl",
            packageName = packageName
        ),
        initializerModule.resolve("src/main/kotlin/com/example/initializer/app/AppInitializer.kt")
    )

    save(
        loadTemplate(
            path = "initializer/src/main/kotlin/com/example/initializer/KoinInitializer.kt.ftl",
            packageName = packageName
        ),
        initializerModule.resolve("src/main/kotlin/com/example/initializer/app/KoinInitializer.kt")
    )

    createBasicModule(
        rootPath = "initializer",
        module = initializerModule,
        packageName = packageName
    )
}
