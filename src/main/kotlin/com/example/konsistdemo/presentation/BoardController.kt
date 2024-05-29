package com.example.konsistdemo.presentation

import com.example.konsistdemo.application.BoardService
import com.example.konsistdemo.data.Board
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    private val boardService: BoardService,
) {
    @GetMapping("/boards")
    fun findAll(): List<Board> = boardService.findAll()

    @PostMapping("/boards")
    fun create(
        @RequestBody command: BoardCreationCommand,
    ) {
        boardService.create(command)
    }
}

data class BoardCreationCommand(
    val title: String,
    val content: String,
) {
    fun toEntity() = Board(title, content)
}
