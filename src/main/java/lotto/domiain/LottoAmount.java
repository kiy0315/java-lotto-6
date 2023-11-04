package lotto.domiain;

import lotto.View.ExceptionMessage;
import lotto.View.InputView;

import static lotto.View.ExceptionMessage.*;

public class LottoAmount {
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;

    private final int lottoAmount;


    public LottoAmount(int lottoAmount) {
        validate(lottoAmount);
        this.lottoAmount = lottoAmount;
    }

    private void validate(int lottoAmount) {
        validateDivide(lottoAmount);
    }

    private void validateDivide(int lottoAmount) {
        if (lottoAmount % LOTTO_AMOUNT != ZERO) {
            System.out.println(amountDivideException());
            throw new IllegalArgumentException();
        }
    }

    public int getTicketCount() {
        return lottoAmount / LOTTO_AMOUNT;
    }

}
