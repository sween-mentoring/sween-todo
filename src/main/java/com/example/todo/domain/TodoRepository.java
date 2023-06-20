package com.example.todo.domain;

public interface TodoRepository{
  Todo save(Todo todo);
  Todo findById(Long id);
  void deleteById(Long id);
}
