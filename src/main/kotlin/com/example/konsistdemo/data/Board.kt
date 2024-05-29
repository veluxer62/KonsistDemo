package com.example.konsistdemo.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Board(
    title: String,
    content: String,
) {
    @Id
    val id: UUID = UUID.randomUUID()

    @Column(nullable = false)
    val title: String = title

    @Column(nullable = false)
    val content: String = content

    @Column
    @Suppress("konsist.Entity 클래스의 Column 프로퍼티가 non-nullable 타입이라면 '@Column(nullable=false)'가 선언되어야 한다")
    val foo: String = ""
}
