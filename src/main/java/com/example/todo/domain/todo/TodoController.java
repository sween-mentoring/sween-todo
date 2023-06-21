package com.example.todo.domain.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/todos")
public class TodoController {
  private final TodoService todoService;
  @PutMapping("/{id}")
  public Todo modify(@PathVariable Long id, @RequestBody Todo modified) {
    Todo source = todoService.find(id);
    Todo result = todoService.modify(source, modified);
    return result;
  }

}
