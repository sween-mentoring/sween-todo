package com.example.todo.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Todo {
  private Long id;
  private String title;
  private String content;
  private String owner;
  private boolean isComplete;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @Builder
  public Todo(String title, String content, String owner, Long id, boolean isComplete) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.owner = owner;
    this.isComplete = isComplete;
    LocalDateTime now = LocalDateTime.now();
    createdAt = now;
    updatedAt = now;
  }

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

  public void changeState() {
    isComplete = !isComplete;
  }

  public Long getId() {
    return id;
  }
}
