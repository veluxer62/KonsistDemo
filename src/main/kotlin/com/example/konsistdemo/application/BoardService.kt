package com.example.konsistdemo.application

import com.example.konsistdemo.data.Board
import com.example.konsistdemo.data.BoardRepository
import com.example.konsistdemo.presentation.BoardCreationCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class BoardService(
    private val boardRepository: BoardRepository,
) {
    fun findAll(): List<Board> = boardRepository.findAll()

    @Transactional
    fun create(command: BoardCreationCommand) {
        val entity = command.toEntity()
        boardRepository.save(entity)
    }

    @Suppress("konsist.함수 파라미터는 3개 이상 선언할 수 없다")
    fun foo(
        p1: String,
        p2: String,
        p3: String,
        p4: String,
    ) {}
}
