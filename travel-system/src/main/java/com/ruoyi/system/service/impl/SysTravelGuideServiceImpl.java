package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTravelGuideMapper;
import com.ruoyi.system.domain.SysTravelGuide;
import com.ruoyi.system.service.ISysTravelGuideService;

/**
 * 旅游攻略信息Service业务层处理
 *
 * @author flight
 * @date 2024-05-25
 */
@Service
public class SysTravelGuideServiceImpl implements ISysTravelGuideService
{
    @Autowired
    private SysTravelGuideMapper sysTravelGuideMapper;

    /**
     * 查询旅游攻略信息
     *
     * @param id 旅游攻略信息主键
     * @return 旅游攻略信息
     */
    @Override
    public SysTravelGuide selectSysTravelGuideById(Long id)
    {
        return sysTravelGuideMapper.selectSysTravelGuideById(id);
    }

    /**
     * 查询旅游攻略信息列表
     *
     * @param sysTravelGuide 旅游攻略信息
     * @return 旅游攻略信息
     */
    @Override
    public List<SysTravelGuide> selectSysTravelGuideList(SysTravelGuide sysTravelGuide)
    {
        return sysTravelGuideMapper.selectSysTravelGuideList(sysTravelGuide);
    }

    /**
     * 新增旅游攻略信息
     *
     * @param sysTravelGuide 旅游攻略信息
     * @return 结果
     */
    @Override
    public int insertSysTravelGuide(SysTravelGuide sysTravelGuide)
    {
        SysUser sysUser = SecurityUtils.getLoginUser().getUser();
        sysTravelGuide.setCreatedAt(new Date());
        sysTravelGuide.setUserId(sysUser.getUserId());
        sysTravelGuide.setCreateUser(sysUser.getUserName());
        return sysTravelGuideMapper.insertSysTravelGuide(sysTravelGuide);
    }

    /**
     * 修改旅游攻略信息
     *
     * @param sysTravelGuide 旅游攻略信息
     * @return 结果
     */
    @Override
    public int updateSysTravelGuide(SysTravelGuide sysTravelGuide)
    {
        sysTravelGuide.setUpdatedAt(new Date());
        return sysTravelGuideMapper.updateSysTravelGuide(sysTravelGuide);
    }

    /**
     * 批量删除旅游攻略信息
     *
     * @param ids 需要删除的旅游攻略信息主键
     * @return 结果
     */
    @Override
    public int deleteSysTravelGuideByIds(Long[] ids)
    {
        return sysTravelGuideMapper.deleteSysTravelGuideByIds(ids);
    }

    /**
     * 删除旅游攻略信息信息
     *
     * @param id 旅游攻略信息主键
     * @return 结果
     */
    @Override
    public int deleteSysTravelGuideById(Long id)
    {
        return sysTravelGuideMapper.deleteSysTravelGuideById(id);
    }
}
