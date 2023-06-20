package com.example.todo.domain;

import java.util.HashMap;
import java.util.Map;

public class TodoMemoryRepository implements TodoRepository {
  Long id = 0L;
  Map<Long, Todo> todos = new HashMap<>();

  @Override
  public Todo save(Todo todo) {
    Todo saved = new Todo(todo.getTitle(), todo.getContent(), todo.getOwner(), id++, todo.isComplete());
    todos.put(saved.getId(), saved);
    return saved;
  }

  @Override
  public Todo findById(Long id) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }
}
