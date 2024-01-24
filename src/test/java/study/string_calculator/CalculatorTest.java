package study.string_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import string_calculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    @DisplayName("덧셈 연산 성공테스트")
    void twoStringOperands_returnStringPlusResult() {
        String operand1 = "1";
        String operand2 = "2";
        String result = StringCalculator.plus(operand1, operand2);
        assertThat(result).isEqualTo("3.0");
    }

    @Test
    @DisplayName("뺄셈 연산 성공테스트")
    void twoStringOperands_returnStringMinusResult() {
        String operand1 = "1";
        String operand2 = "2";
        String result = StringCalculator.minus(operand1, operand2);
        assertThat(result).isEqualTo("-1.0");
    }

    @Test
    @DisplayName("나눗셈 연산 성공테스트")
    void twoStringOperands_returnStringDivideResult() {
        String operand1 = "1";
        String operand2 = "2";
        String result = StringCalculator.divide(operand1, operand2);
        assertThat(result).isEqualTo("0.5");
    }

    @Test
    @DisplayName("0으로 나누면 예외 반환")
    void operand2IsZero_throwIllegalEx() {
        String operand1 = "1";
        String operand2 = "0";
        assertThatThrownBy(() -> StringCalculator.divide(operand1, operand2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("곱셈 연산 성공 테스트")
    void twoStringOperands_returnStringMultiplyResult() {
        String operand1 = "2";
        String operand2 = "3";
        String result = StringCalculator.multiply(operand1, operand2);
        assertThat(result).isEqualTo("6.0");
    }

    @Test
    @DisplayName("연산기 성공 테스트")
    void stringMathExpression_returnStringCalculatedResult() {
        String mathExpression = "2 + 3 * 4 / 2";
        String result = StringCalculator.calculateString(mathExpression);
        assertThat(result).isEqualTo("10.0");
    }
}