package io.github.semenciuccosmin.androidcomposeprojecttemplateplugin

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import io.github.semenciuccosmin.androidcomposeprojecttemplateplugin.recipe.recipe
import java.io.File

class TemplateProvider : WizardTemplateProvider() {
    override fun getTemplates() = listOf(myComposeTemplate)
}

val myComposeTemplate = template {
    name = "Android Compose Project Template"
    description = "My personal Compose-first template"
    minApi = 24
    category = Category.Application
    formFactor = FormFactor.Mobile
    screens = listOf(WizardUiContext.NewProject)
    useGenericLocalTests = false
    useGenericAndroidTests = false
    thumb = {
        Thumb {
            val contextClass = TemplateProvider::class.java as Class<Any>
            val resourceFile = File("thumbnail.png")
            findResource(contextClass, resourceFile)
        }
    }

    val packageName = defaultPackageNameParameter

    recipe = { data: TemplateData ->
        recipe(data as ModuleTemplateData, packageName.value)
    }
}