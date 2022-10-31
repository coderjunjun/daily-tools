package cn.jun.income.service.impl;

import static cn.jun.util.DecimalUtils.formatPercent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import cn.jun.income.model.InvestOperation;
import cn.jun.income.service.IncomeCalcService;

/**
 * Created on 2022-10-29
 */
@SuppressWarnings("NonAsciiCharacters")
public class IncomeCalcServiceImplTest {

    private final IncomeCalcService incomeCalcService = new IncomeCalcServiceImpl();

    @Test
    public void 半年宝() {
        Object[][] history = {
                {"2022-10-19", +500000},
        };
        run(history, "2022-10-29", 500096);
    }

    @Test
    public void 招睿日开14天滚动() {
        Object[][] history = {
                {"2022-04-06", +50000},
                {"2022-04-26", +50000},
                {"2022-05-13", +50000},
                {"2022-07-19", +50000},
                {"2022-07-25", +100000},
                {"2022-08-02", +100000},
                {"2022-09-02", +50000},
                {"2022-09-14", +50000},
        };
        run(history, "2022-10-29", 504234.17);
    }

    private void run(Object[][] history, String lastDay, double lastAmount) {
        List<InvestOperation> historyList = parseHistory(history);
        BigDecimal rate = incomeCalcService.calcIncomeRate(historyList, parseDate(lastDay), new BigDecimal(lastAmount));
        System.out.printf("最终年化收益率为: %s%% \n", formatPercent(rate));
    }

    private List<InvestOperation> parseHistory(Object[][] history) {
        return Arrays.stream(history)
                .map(item -> new InvestOperation(parseDate(item[0].toString()),
                        new BigDecimal(item[1].toString())))
                .collect(Collectors.toList());
    }

    private LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}