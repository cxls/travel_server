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
import com.ruoyi.system.domain.SysScenicSpot;
import com.ruoyi.system.service.ISysScenicSpotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景点信息Controller
 *
 * @author flight
 * @date 2024-05-25
 */
@RestController
@RequestMapping("/system/spot")
public class SysScenicSpotController extends BaseController
{
    @Autowired
    private ISysScenicSpotService sysScenicSpotService;

    /**
     * 查询景点信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:spot:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysScenicSpot sysScenicSpot)
    {
        startPage();
        List<SysScenicSpot> list = sysScenicSpotService.selectSysScenicSpotList(sysScenicSpot);
        return getDataTable(list);
    }

    /**
     * 导出景点信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:spot:export')")
    @Log(title = "景点信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysScenicSpot sysScenicSpot)
    {
        List<SysScenicSpot> list = sysScenicSpotService.selectSysScenicSpotList(sysScenicSpot);
        ExcelUtil<SysScenicSpot> util = new ExcelUtil<SysScenicSpot>(SysScenicSpot.class);
        util.exportExcel(response, list, "景点信息数据");
    }

    /**
     * 获取景点信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:spot:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysScenicSpotService.selectSysScenicSpotById(id));
    }

    /**
     * 新增景点信息
     */
    @PreAuthorize("@ss.hasPermi('system:spot:add')")
    @Log(title = "景点信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysScenicSpot sysScenicSpot)
    {
        return toAjax(sysScenicSpotService.insertSysScenicSpot(sysScenicSpot));
    }

    /**
     * 修改景点信息
     */
    @PreAuthorize("@ss.hasPermi('system:spot:edit')")
    @Log(title = "景点信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysScenicSpot sysScenicSpot)
    {
        return toAjax(sysScenicSpotService.updateSysScenicSpot(sysScenicSpot));
    }

    /**
     * 删除景点信息
     */
    @PreAuthorize("@ss.hasPermi('system:spot:remove')")
    @Log(title = "景点信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysScenicSpotService.deleteSysScenicSpotByIds(ids));
    }
}
