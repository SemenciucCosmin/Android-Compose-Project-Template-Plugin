package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.createUiThemeModule(
    moduleData: ModuleTemplateData,
    packageName: String
) {
    val uiModule = moduleData.rootDir.parentFile.resolve("ui").also { createDirectory(it) }
    val uiThemeModule = uiModule.resolve("theme").also { createDirectory(it) }

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/color/Color.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/color/Color.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/design/Pds.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/design/Pds.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/dimension/DefaultIcon.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/dimension/DefaultIcon.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/dimension/DefaultSpacing.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/dimension/DefaultSpacing.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/dimension/DefaultStroke.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/dimension/DefaultStroke.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/dimension/Icon.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/dimension/Icon.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/dimension/Spacing.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/dimension/Spacing.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/dimension/Stroke.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/dimension/Stroke.kt")
    )

    save(
        loadTemplate(
            path = "ui/theme/src/main/kotlin/com/example/ui/theme/theme/Theme.kt.ftl",
            packageName = packageName
        ),
        uiThemeModule.resolve("src/main/kotlin/com/example/ui/theme/theme/Theme.kt")
    )

    createBasicModule(
        rootPath = "ui/theme",
        module = uiThemeModule,
        packageName = packageName
    )
}
