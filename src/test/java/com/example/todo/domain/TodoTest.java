package com.example.todo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TodoTest {

  String title = "title";
  String content = "content";
  String owner = "owner";
  boolean isComplete = false;
  LocalDateTime createdAt = LocalDateTime.now();
  LocalDateTime updatedAt = LocalDateTime.now();
  @Test
  @DisplayName("Todo 생성 테스트")
  public void create() {
    Todo todo = new Todo(title, content , owner, isComplete, LocalDateTime.now());
    Assertions.assertThat(todo.getTitle(), "title");
    Assertions.assertThat(todo.getContent(), "content");
    Assertions.assertThat(todo.getTitle(), "title");
    Assertions.assertThat(todo.getContent(), "content");
    Assertions.assertThat(todo.isComplete(), isComplete);
    Assertions.assertThat(todo.getCreatedAt(), createdAt);
    Assertions.assertThat(todo.getUpdatedAt(), updatedAt);
  }
  //    TODO    생성, 수정, 삭제, 완료, 미완료, 정렬
  @Test
  @DisplayName("Todo 수정 테스트")
  public void modify() {

  }

}