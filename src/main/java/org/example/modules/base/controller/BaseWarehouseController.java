package org.example.modules.base.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.base.entity.BaseWarehouse;
import org.example.modules.base.service.BaseWarehouseService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base/warehouse")
@RequiredArgsConstructor
public class BaseWarehouseController {

    private final BaseWarehouseService baseWarehouseService;

    @GetMapping("/page")
    public ApiResponse<IPage<BaseWarehouse>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String warehouseName,
            @RequestParam(required = false) String warehouseCode,
            @RequestParam(required = false) Boolean status) {
        Page<BaseWarehouse> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<BaseWarehouse> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(warehouseName != null, BaseWarehouse::getWarehouseName, warehouseName)
                .like(warehouseCode != null, BaseWarehouse::getWarehouseCode, warehouseCode)
                .eq(status != null, BaseWarehouse::getStatus, status)
                .orderByDesc(BaseWarehouse::getCreatedTime);
        return ApiResponse.success(baseWarehouseService.page(page, wrapper));
    }

    @GetMapping("/list")
    public ApiResponse<List<BaseWarehouse>> list() {
        return ApiResponse.success(baseWarehouseService.list());
    }

    @GetMapping("/{id}")
    public ApiResponse<BaseWarehouse> getById(@PathVariable Long id) {
        return ApiResponse.success(baseWarehouseService.getById(id));
    }

    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody BaseWarehouse baseWarehouse) {
        return ApiResponse.success(baseWarehouseService.save(baseWarehouse));
    }

    @PutMapping
    public ApiResponse<Boolean> update(@RequestBody BaseWarehouse baseWarehouse) {
        return ApiResponse.success(baseWarehouseService.updateById(baseWarehouse));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Long id) {
        return ApiResponse.success(baseWarehouseService.removeById(id));
    }
}