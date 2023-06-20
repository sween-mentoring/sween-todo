package com.example.todo.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Todo {
  private String title;
  private String content;
  private String owner;
  private boolean isComplete;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public Todo(String title, String content, String owner) {
    this.title = title;
    this.content = content;
    this.owner = owner;
    isComplete = false;
    LocalDateTime now = LocalDateTime.now();
    createdAt = now;
    updatedAt = now;
  }

  public void modify(Todo modifiedTodo) {
    this.title = modifiedTodo.getTitle();
    this.content = modifiedTodo.getContent();
    this.owner = modifiedTodo.getOwner();
    updatedAt = modifiedTodo.getUpdatedAt();
  }
}
