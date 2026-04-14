package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.recipe(
    moduleData: ModuleTemplateData,
    packageName: String
) {
    createAppModule(moduleData, packageName)
    createInitializerModule(moduleData, packageName)
    createUiCoreModule(moduleData, packageName)
    createUiThemeModule(moduleData, packageName)
    createGradle(moduleData, packageName)
}

fun loadTemplate(path: String, packageName: String): String {
    return object {}.javaClass
        .getResourceAsStream("/templates/AndroidComposeProjectTemplate/root/$path")!!
        .bufferedReader()
        .readText()
        .replace("\${packageName}", packageName)
}