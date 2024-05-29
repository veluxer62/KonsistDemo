package com.example.konsistdemo.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Suppress("konsist.Router 클래스명은 'Controller' 접미사를 가진다")
class FooRouter {
    @GetMapping("/foo")
    fun foo() {}
}
