package cn.jun.income.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import cn.jun.income.model.InvestOperation;

/**
 * Created on 2022-10-29
 */
public interface IncomeCalcService {
    BigDecimal calcIncomeRate(List<InvestOperation> operationHistory, LocalDate lastDay, BigDecimal lastAmount);
}
