package com.example.todo.domain.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final TodoRepository todoRepository;

  public Todo find(Long id) {
    return todoRepository.findById(id);
  }


  public Todo modify(Todo source, Todo modified) {
    source.modify(modified);
    return todoRepository.save(source);
  }
}
