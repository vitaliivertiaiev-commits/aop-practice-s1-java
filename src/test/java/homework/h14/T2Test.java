package homework.h14;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T2Test {
  @Test
  void followsQueueOperationsFromExample() {
    T2 queue = new T2();
    queue.push(1);
    queue.push(2);

    assertThat(queue.peek()).isEqualTo(1);
    assertThat(queue.pop()).isEqualTo(1);
    assertThat(queue.empty()).isFalse();
  }

  @Test
  void preservesFifoOrderWhenValuesAreAddedBetweenPops() {
    T2 queue = new T2();
    queue.push(4);
    queue.push(5);
    assertThat(queue.pop()).isEqualTo(4);

    queue.push(6);

    assertThat(queue.pop()).isEqualTo(5);
    assertThat(queue.pop()).isEqualTo(6);
    assertThat(queue.empty()).isTrue();
  }

  @Test
  void peekDoesNotRemoveTheFrontElement() {
    T2 queue = new T2();
    queue.push(8);

    assertThat(queue.peek()).isEqualTo(8);
    assertThat(queue.peek()).isEqualTo(8);
    assertThat(queue.pop()).isEqualTo(8);
    assertThat(queue.empty()).isTrue();
  }

  @Test
  void handlesEmptyQueue() {
    assertThat(new T2().empty()).isTrue();
  }
}
