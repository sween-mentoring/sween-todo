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
    //given
    Todo todo = new Todo(title, content , owner);
    //when
    //then
    Assertions.assertEquals(todo.getTitle(), "title");
    Assertions.assertEquals(todo.getContent(), "content");
    Assertions.assertEquals(todo.getOwner(), "owner");
    Assertions.assertEquals(todo.isComplete(), isComplete);
    Assertions.assertNotNull(todo.getCreatedAt());
    Assertions.assertNotNull(todo.getUpdatedAt());
  }
  //    TODO    생성, 수정, 삭제, 완료, 미완료, 정렬
  @Test
  @DisplayName("Todo 수정 테스트")
  public void modify() {
    //given
    Todo todo = new Todo(title, content , owner);
    Todo modifiedTodo = new Todo("modifiedTitle", "modifiedContent", "other");
    //when
    todo.modify(modifiedTodo);
    //then
    Assertions.assertEquals(todo.getTitle(), "modifiedTitle");
    Assertions.assertEquals(todo.getContent(), "modifiedContent");
    Assertions.assertEquals(todo.getOwner(), "other");
    Assertions.assertNotEquals(todo.getCreatedAt(), todo.getUpdatedAt());
  }

  @Test
  @DisplayName("Todo 완료 테스트")
  public void complete() {
    //given
    Todo todo = new Todo(title, content , owner);
    //when
    todo.changeState();
    //then
    Assertions.assertTrue(todo.isComplete());
  }

//  @Test
//  @DisplayName("Todo 삭제 테스트")
//  public void delete() {
//    Todo todo = new Todo(title, content, owner);
//    Todo modifiedTodo = new Todo("modifiedTitle", "modifiedContent", "other");
//    todo.modify(modifiedTodo);
//    Assertions.assertEquals(todo.getTitle(), "modifiedTitle");
//    Assertions.assertEquals(todo.getContent(), "modifiedContent");
//    Assertions.assertEquals(todo.getOwner(), "other");
//    Assertions.assertNotEquals(todo.getCreatedAt(), todo.getUpdatedAt());
//  }


}