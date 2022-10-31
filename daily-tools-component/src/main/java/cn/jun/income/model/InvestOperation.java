package cn.jun.income.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on 2022-10-29
 */
@Data
@AllArgsConstructor
public class InvestOperation {
    private LocalDate date;
    private BigDecimal amount;
}
