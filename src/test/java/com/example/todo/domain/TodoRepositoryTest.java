package com.example.todo.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TodoRepositoryTest {
  private TodoRepository todoRepository;

  String title = "title";
  String content = "content";
  String owner = "owner";
  boolean isComplete = false;
  @BeforeEach
  public void initRepository() {
    todoRepository = new TodoMemoryRepository();
  }

  @Test
  @DisplayName("Todo 삽입 테스트")
  public void insert() {
    //given
    Todo todo = new Todo(title, content, owner);
    //when
    Todo saved = todoRepository.save(todo);
    Todo twiceSaved = todoRepository.save(todo);
    //then
    Assertions.assertNull(todo.getId());
    Assertions.assertNotNull(saved.getId());
    Assertions.assertEquals(saved.getId()+1, twiceSaved.getId());
  }
  @Test
  @DisplayName("Todo 삭제 테스트")
  public void delete() {
    Todo todo = new Todo(title, content, owner);
    Todo modifiedTodo = new Todo("modifiedTitle", "modifiedContent", "other");
    todo.modify(modifiedTodo);
    Assertions.assertEquals(todo.getTitle(), "modifiedTitle");
    Assertions.assertEquals(todo.getContent(), "modifiedContent");
    Assertions.assertEquals(todo.getOwner(), "other");
    Assertions.assertNotEquals(todo.getCreatedAt(), todo.getUpdatedAt());
  }
}