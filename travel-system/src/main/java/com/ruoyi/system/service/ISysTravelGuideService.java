package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTravelGuide;

/**
 * 旅游攻略信息Service接口
 * 
 * @author flight
 * @date 2024-05-25
 */
public interface ISysTravelGuideService 
{
    /**
     * 查询旅游攻略信息
     * 
     * @param id 旅游攻略信息主键
     * @return 旅游攻略信息
     */
    public SysTravelGuide selectSysTravelGuideById(Long id);

    /**
     * 查询旅游攻略信息列表
     * 
     * @param sysTravelGuide 旅游攻略信息
     * @return 旅游攻略信息集合
     */
    public List<SysTravelGuide> selectSysTravelGuideList(SysTravelGuide sysTravelGuide);

    /**
     * 新增旅游攻略信息
     * 
     * @param sysTravelGuide 旅游攻略信息
     * @return 结果
     */
    public int insertSysTravelGuide(SysTravelGuide sysTravelGuide);

    /**
     * 修改旅游攻略信息
     * 
     * @param sysTravelGuide 旅游攻略信息
     * @return 结果
     */
    public int updateSysTravelGuide(SysTravelGuide sysTravelGuide);

    /**
     * 批量删除旅游攻略信息
     * 
     * @param ids 需要删除的旅游攻略信息主键集合
     * @return 结果
     */
    public int deleteSysTravelGuideByIds(Long[] ids);

    /**
     * 删除旅游攻略信息信息
     * 
     * @param id 旅游攻略信息主键
     * @return 结果
     */
    public int deleteSysTravelGuideById(Long id);
}
