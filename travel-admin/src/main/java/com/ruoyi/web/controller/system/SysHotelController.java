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
import com.ruoyi.system.domain.SysHotel;
import com.ruoyi.system.service.ISysHotelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 酒店信息Controller
 *
 * @author flight
 * @date 2024-05-25
 */
@RestController
@RequestMapping("/system/hotel")
public class SysHotelController extends BaseController
{
    @Autowired
    private ISysHotelService sysHotelService;

    /**
     * 查询酒店信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:hotel:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysHotel sysHotel)
    {
        startPage();
        List<SysHotel> list = sysHotelService.selectSysHotelList(sysHotel);
        return getDataTable(list);
    }

    /**
     * 导出酒店信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:hotel:export')")
    @Log(title = "酒店信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysHotel sysHotel)
    {
        List<SysHotel> list = sysHotelService.selectSysHotelList(sysHotel);
        ExcelUtil<SysHotel> util = new ExcelUtil<SysHotel>(SysHotel.class);
        util.exportExcel(response, list, "酒店信息数据");
    }

    /**
     * 获取酒店信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:hotel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysHotelService.selectSysHotelById(id));
    }

    /**
     * 新增酒店信息
     */
    @PreAuthorize("@ss.hasPermi('system:hotel:add')")
    @Log(title = "酒店信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysHotel sysHotel)
    {
        return toAjax(sysHotelService.insertSysHotel(sysHotel));
    }

    /**
     * 修改酒店信息
     */
    @PreAuthorize("@ss.hasPermi('system:hotel:edit')")
    @Log(title = "酒店信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysHotel sysHotel)
    {
        return toAjax(sysHotelService.updateSysHotel(sysHotel));
    }

    /**
     * 删除酒店信息
     */
    @PreAuthorize("@ss.hasPermi('system:hotel:remove')")
    @Log(title = "酒店信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysHotelService.deleteSysHotelByIds(ids));
    }
}
