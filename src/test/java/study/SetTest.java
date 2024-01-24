package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1 : set 크기 확인 테스트")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항2 : set contains 확인 테스트")
    void containsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항3 - 1 : parameterized value source 테스트")
    void containsTestWithParameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "4:false"}, delimiter = ':')
    @DisplayName("요구사항3 - 2 : parameterized csv source 테스트")
    void containsTestWithParameterizedTest(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }


}
