package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");


    }

    @Test
    @DisplayName("요구사항 1")
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");

        values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, value.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void charAt() {
        String abc = "abc";
        int index = 3;

        assertThatThrownBy(() -> {
           abc.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", index);


        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            abc.charAt(index);
        }).withMessageMatching(String.format("String index out of range: \\d+", index));
    }
}
