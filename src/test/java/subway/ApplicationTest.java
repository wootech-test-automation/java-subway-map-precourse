package subway;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 짝수_인원_페어_매칭() {
        run("3", "1", "2호선", "잠실역", "2", "3", "2", "2호선", "잠실역","4");
        assertThat(output()).contains(
                "[INFO] 구간이 등록되었습니다",
                "[INFO] 구간이 삭제되었습니다.",
                "[INFO] 2호선",
                "[INFO] ---",
                "[INFO] 교대역",
                "[INFO] 강남역",
                "[INFO] 역삼역",
                "[INFO] 3호선",
                "[INFO] ---",
                "[INFO] 교대역",
                "[INFO] 남부터미널역",
                "[INFO] 양재역",
                "[INFO] 매봉역",
                "[INFO] 신분당선",
                "[INFO] ---",
                "[INFO] 강남역",
                "[INFO] 양재역",
                "[INFO] 양재시민의숲역");
    }

    @Test
    void 없는_미션에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨1, 오징어게임");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
