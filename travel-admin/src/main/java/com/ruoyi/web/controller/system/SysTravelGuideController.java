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
import com.ruoyi.system.domain.SysTravelGuide;
import com.ruoyi.system.service.ISysTravelGuideService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 旅游攻略信息Controller
 *
 * @author flight
 * @date 2024-05-25
 */
@RestController
@RequestMapping("/system/guide")
public class SysTravelGuideController extends BaseController
{
    @Autowired
    private ISysTravelGuideService sysTravelGuideService;

    /**
     * 查询旅游攻略信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:guide:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTravelGuide sysTravelGuide)
    {
        startPage();
        List<SysTravelGuide> list = sysTravelGuideService.selectSysTravelGuideList(sysTravelGuide);
        return getDataTable(list);
    }

    /**
     * 导出旅游攻略信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:guide:export')")
    @Log(title = "旅游攻略信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTravelGuide sysTravelGuide)
    {
        List<SysTravelGuide> list = sysTravelGuideService.selectSysTravelGuideList(sysTravelGuide);
        ExcelUtil<SysTravelGuide> util = new ExcelUtil<SysTravelGuide>(SysTravelGuide.class);
        util.exportExcel(response, list, "旅游攻略信息数据");
    }

    /**
     * 获取旅游攻略信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:guide:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysTravelGuideService.selectSysTravelGuideById(id));
    }

    /**
     * 新增旅游攻略信息
     */
//    @PreAuthorize("@ss.hasPermi('system:guide:add')")
    @Log(title = "旅游攻略信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTravelGuide sysTravelGuide)
    {
        return toAjax(sysTravelGuideService.insertSysTravelGuide(sysTravelGuide));
    }

    /**
     * 修改旅游攻略信息
     */
    @PreAuthorize("@ss.hasPermi('system:guide:edit')")
    @Log(title = "旅游攻略信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTravelGuide sysTravelGuide)
    {
        return toAjax(sysTravelGuideService.updateSysTravelGuide(sysTravelGuide));
    }

    /**
     * 删除旅游攻略信息
     */
    @PreAuthorize("@ss.hasPermi('system:guide:remove')")
    @Log(title = "旅游攻略信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysTravelGuideService.deleteSysTravelGuideByIds(ids));
    }
}
