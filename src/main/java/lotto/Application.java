package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoNumberGenerator());
        lottoController.run();
    }
}