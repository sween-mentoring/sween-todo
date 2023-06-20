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
  @DisplayName("Todo 조회 테스트")
  public void find() {
    //given
    Todo todo = new Todo(title, content, owner);
    //when
    Todo saved = todoRepository.save(todo);
    Todo twiceSaved = todoRepository.save(todo);
    Todo found = todoRepository.findById(0L);
    Todo twiceFound = todoRepository.findById(1L);
    //then
    Assertions.assertEquals(saved, found);
    Assertions.assertEquals(twiceSaved, twiceFound);
  }

  @Test
  @DisplayName("Todo 삭제 테스트")
  public void delete() {
    //given
    Todo todo = new Todo(title, content, owner);
    //when
    Todo saved = todoRepository.save(todo);
    todoRepository.deleteById(saved.getId());
    Todo deleted = todoRepository.findById(saved.getId());
    //then
    Assertions.assertNull(deleted);
  }
}