package com.example.konsistdemo

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.ext.list.withAllAnnotationsOf
import com.lemonappdev.konsist.api.verify.assertTrue
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.junit.jupiter.api.Test
import org.springframework.web.bind.annotation.RestController

class DeclarationTest {
    @Test
    fun `Router 클래스명은 'Controller' 접미사를 가진다`() {
        Konsist.scopeFromProject()
            .classes()
            .withAllAnnotationsOf(RestController::class)
            .assertTrue { it.name.endsWith("Controller") }
    }

    @Test
    fun `함수 파라미터는 3개 이상 선언할 수 없다`() {
        Konsist.scopeFromProject()
            .functions()
            .assertTrue {
                it.parameters.size <= 3
            }
    }

    @Test
    fun `Entity 클래스의 Column 프로퍼티가 non-nullable 타입이라면 '@Column(nullable=false)'가 선언되어야 한다`() {
        Konsist.scopeFromProject()
            .classes()
            .withAllAnnotationsOf(Entity::class)
            .properties()
            .withAllAnnotationsOf(Column::class)
            .filter { it.type?.isNullable == false }
            .assertTrue {
                it.hasAnnotation { annotation ->
                    annotation.hasArgument { arg ->
                        arg.name == "nullable" && arg.value == "false"
                    }
                }
            }
    }
}
