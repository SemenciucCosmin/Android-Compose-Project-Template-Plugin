package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.createUiCoreModule(
    moduleData: ModuleTemplateData,
    packageName: String
) {
    val uiModule = moduleData.rootDir.parentFile.resolve("ui").also { createDirectory(it) }
    val uiCoreModule = uiModule.resolve("core").also { createDirectory(it) }

    save(
        loadTemplate(
            path = "ui/core/src/main/kotlin/com/example/ui/core/components/EventHandler.kt.ftl",
            packageName = packageName
        ),
        uiCoreModule.resolve("src/main/kotlin/com/example/ui/core/components/EventHandler.kt")
    )

    save(
        loadTemplate(
            path = "ui/core/src/main/kotlin/com/example/ui/core/viewmodel/model/Event.kt.ftl",
            packageName = packageName
        ),
        uiCoreModule.resolve("src/main/kotlin/com/example/ui/core/viewmodel/model/Event.kt")
    )

    save(
        loadTemplate(
            path = "ui/core/src/main/kotlin/com/example/ui/core/viewmodel/EventViewModel.kt.ftl",
            packageName = packageName
        ),
        uiCoreModule.resolve("src/main/kotlin/com/example/ui/core/viewmodel/EventViewModel.kt")
    )

    createBasicModule(
        rootPath = "ui/core",
        module = uiCoreModule,
        packageName = packageName
    )
}
