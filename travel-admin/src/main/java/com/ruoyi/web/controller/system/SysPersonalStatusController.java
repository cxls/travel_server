package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysPersonalStatus;
import com.ruoyi.system.service.ISysPersonalStatusService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人动态Controller
 *
 * @author flight
 * @date 2024-05-25
 */
@RestController
@RequestMapping("/system/status")
public class SysPersonalStatusController extends BaseController
{
    @Autowired
    private ISysPersonalStatusService sysPersonalStatusService;

    /**
     * 查询个人动态列表
     */
//    @PreAuthorize("@ss.hasPermi('system:status:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPersonalStatus sysPersonalStatus)
    {
        startPage();
        List<SysPersonalStatus> list = sysPersonalStatusService.selectSysPersonalStatusList(sysPersonalStatus);
        return getDataTable(list);
    }

    /**
     * 导出个人动态列表
     */
    @PreAuthorize("@ss.hasPermi('system:status:export')")
    @Log(title = "个人动态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPersonalStatus sysPersonalStatus)
    {
        List<SysPersonalStatus> list = sysPersonalStatusService.selectSysPersonalStatusList(sysPersonalStatus);
        ExcelUtil<SysPersonalStatus> util = new ExcelUtil<SysPersonalStatus>(SysPersonalStatus.class);
        util.exportExcel(response, list, "个人动态数据");
    }

    /**
     * 获取个人动态详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:status:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysPersonalStatusService.selectSysPersonalStatusById(id));
    }

    /**
     * 新增个人动态
     */
//    @PreAuthorize("@ss.hasPermi('system:status:add')")
    @Log(title = "个人动态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPersonalStatus sysPersonalStatus)
    {
        return toAjax(sysPersonalStatusService.insertSysPersonalStatus(sysPersonalStatus));
    }

    /**
     * 修改个人动态
     */
//    @PreAuthorize("@ss.hasPermi('system:status:edit')")
    @Log(title = "个人动态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPersonalStatus sysPersonalStatus)
    {
        return toAjax(sysPersonalStatusService.updateSysPersonalStatus(sysPersonalStatus));
    }

    /**
     * 删除个人动态
     */
//    @PreAuthorize("@ss.hasPermi('system:status:remove')")
    @Log(title = "个人动态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysPersonalStatusService.deleteSysPersonalStatusByIds(ids));
    }
}
