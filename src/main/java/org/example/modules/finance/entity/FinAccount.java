package org.example.modules.finance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fin_account")
public class FinAccount extends BaseEntity {

    private String accountCode;
    private String accountName;
    private String accountType;
    private String bankName;
    private String bankAccount;
    private java.math.BigDecimal balance;
    private Integer status;
}
