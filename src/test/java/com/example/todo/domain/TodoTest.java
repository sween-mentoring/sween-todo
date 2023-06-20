package com.example.todo.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TodoTest {

  String title = "title";
  String content = "content";
  String owner = "owner";
  boolean isComplete = false;
  @Test
  @DisplayName("Todo 생성 테스트")
  public void create() {
    Todo todo = new Todo(title, content , owner);
    Assertions.assertEquals(todo.getTitle(), "title");
    Assertions.assertEquals(todo.getContent(), "content");
    Assertions.assertEquals(todo.getTitle(), "title");
    Assertions.assertEquals(todo.getOwner(), "owner");
    Assertions.assertEquals(todo.isComplete(), isComplete);
    Assertions.assertNotNull(todo.getCreatedAt());
    Assertions.assertNotNull(todo.getUpdatedAt());
  }
  //    TODO    생성, 수정, 삭제, 완료, 미완료, 정렬
  @Test
  @DisplayName("Todo 수정 테스트")
  public void modify() {
    Todo todo = new Todo(title, content , owner);
    Todo modifiedTodo = new Todo("modifiedTitle", "modifiedContent", "other");
    todo.modify(modifiedTodo);
    Assertions.assertEquals(todo.getTitle(), "modifiedTitle");
    Assertions.assertEquals(todo.getContent(), "modifiedContent");
    Assertions.assertEquals(todo.getTitle(), "title");
    Assertions.assertEquals(todo.getOwner(), "other");
    Assertions.assertNotEquals(todo.getCreatedAt(), todo.getUpdatedAt());
  }

}