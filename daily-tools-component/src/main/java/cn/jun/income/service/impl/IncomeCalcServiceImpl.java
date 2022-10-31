package cn.jun.income.service.impl;

import static cn.jun.util.DecimalUtils.format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import cn.jun.income.model.InvestOperation;
import cn.jun.income.service.IncomeCalcService;

/**
 * Created on 2022-10-29
 */
public class IncomeCalcServiceImpl implements IncomeCalcService {

    private static final BigDecimal YEAR_DAY_COUNT = new BigDecimal(365);

    @Override
    public BigDecimal calcIncomeRate(List<InvestOperation> operationHistory, LocalDate lastDay, BigDecimal lastAmount) {
        BigDecimal totalYD = BigDecimal.ZERO; // 元·天，即投入金额与天数之积

        LocalDate startDate = null;
        BigDecimal startAmount = BigDecimal.ZERO;

        for (int i = 0; i < operationHistory.size(); i++) {
            InvestOperation cur = operationHistory.get(i);
            if (i > 0) {
                BigDecimal yd = startAmount.multiply(dayDiff(startDate, cur.getDate()));
                totalYD = totalYD.add(yd);
            }
            startDate = cur.getDate();
            startAmount = startAmount.add(cur.getAmount());
        }

        totalYD = totalYD.add(startAmount.multiply(dayDiff(startDate, lastDay)));
        BigDecimal totalIncome = lastAmount.subtract(startAmount);
        System.out.printf("totalYD = %s, totalIncome = %s \n", format(totalYD), format(totalIncome));

        // 计算年化
        return totalIncome.divide(totalYD, 10, RoundingMode.HALF_UP).multiply(YEAR_DAY_COUNT);
    }

    private BigDecimal dayDiff(LocalDate start, LocalDate end) {
        return new BigDecimal(ChronoUnit.DAYS.between(start, end));
    }
}
