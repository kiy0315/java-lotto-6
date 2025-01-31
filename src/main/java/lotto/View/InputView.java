package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.domiain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.View.ExceptionMessage.*;

public class InputView {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "\n보너스 번호를 입력해 주세요";
    private static final String DELIMITER = ",";

    private static List<Integer> lottoNumbers = new ArrayList<>();


    public static int setPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        return Integer.parseInt(amount);
    }


    public static List<Integer> setLottoNumber() {

        lottoNumbers = new ArrayList<>();
        System.out.println(LOTTO_NUMBER_MESSAGE);
        stringToList(Console.readLine(), lottoNumbers);
        return lottoNumbers;

    }

    private static void validate(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateRange(lottoNumbers);
        validateDuplicateCheck(lottoNumbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(sizeException() + numbers.size());
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                System.out.println(rangeException());
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateDuplicateCheck(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        for (int number : numbers) {
            duplicateCheck.add(number);
        }
        duplicateChecking(duplicateCheck);
    }

    private static void duplicateChecking(Set<Integer> duplicateCheck) {
        if (duplicateCheck.size() != LOTTO_SIZE) {
            System.out.println(duplicateException());
            throw new IllegalArgumentException();
        }
    }

    private static void stringToList(String number, List<Integer> lottoNumbers) {
        for (String lotto : number.split(DELIMITER)) {
            lottoNumbers.add(Integer.parseInt(lotto));
        }
    }


    public static int setBonusBall() {
        System.out.println(BONUS_BALL_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}
