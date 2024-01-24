package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        // assertThat(result).contains("2", "1"); contains method는 순서를 상관하지 않는다.
        assertThat(result).containsSequence("1", "2");
    }

    @Test
    void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void subString() {
        String result = "(1,2)".subSequence(1, 4).toString();
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt IndexOutOfBoundsException 익셉션 메시지 검증 테스트")
    void charAt() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("index out of range: 3");
    }

    @Test
    @DisplayName("charAt IndexOutOfBoundsException 익셉션 메시지 검증 테스트(정규표현식)")
    void charAt2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
