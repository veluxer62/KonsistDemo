package com.example.konsistdemo

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.jupiter.api.Test

class ArchitecturalTest {
    @Test
    fun `presentation 레이어는 application 레이어를, application 레이어는 data 레이어를 의존한다`() {
        Konsist.scopeFromProject()
            .assertArchitecture {
                val presentation = Layer("Presentation", "com.example.konsistdemo.presentation..")
                val application = Layer("Application", "com.example.konsistdemo.application..")
                val data = Layer("Data", "com.example.konsistdemo.data..")

                presentation.dependsOn(application, data)
                application.dependsOn(data)
                data.dependsOnNothing()
            }
    }
}
