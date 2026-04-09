package org.example.modules.purchase.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pur_receipt")
public class PurReceipt extends BaseEntity {

    private String receiptNo;
    private LocalDate receiptDate;
    private Long supplierId;
    private Long warehouseId;
    private Long orderId;
    private String status;
    private String approveStatus;
}