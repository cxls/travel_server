package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPersonalStatusMapper;
import com.ruoyi.system.domain.SysPersonalStatus;
import com.ruoyi.system.service.ISysPersonalStatusService;

/**
 * 个人动态Service业务层处理
 * 
 * @author flight
 * @date 2024-05-25
 */
@Service
public class SysPersonalStatusServiceImpl implements ISysPersonalStatusService 
{
    @Autowired
    private SysPersonalStatusMapper sysPersonalStatusMapper;

    /**
     * 查询个人动态
     * 
     * @param id 个人动态主键
     * @return 个人动态
     */
    @Override
    public SysPersonalStatus selectSysPersonalStatusById(Long id)
    {
        return sysPersonalStatusMapper.selectSysPersonalStatusById(id);
    }

    /**
     * 查询个人动态列表
     * 
     * @param sysPersonalStatus 个人动态
     * @return 个人动态
     */
    @Override
    public List<SysPersonalStatus> selectSysPersonalStatusList(SysPersonalStatus sysPersonalStatus)
    {
        return sysPersonalStatusMapper.selectSysPersonalStatusList(sysPersonalStatus);
    }

    /**
     * 新增个人动态
     * 
     * @param sysPersonalStatus 个人动态
     * @return 结果
     */
    @Override
    public int insertSysPersonalStatus(SysPersonalStatus sysPersonalStatus)
    {
        return sysPersonalStatusMapper.insertSysPersonalStatus(sysPersonalStatus);
    }

    /**
     * 修改个人动态
     * 
     * @param sysPersonalStatus 个人动态
     * @return 结果
     */
    @Override
    public int updateSysPersonalStatus(SysPersonalStatus sysPersonalStatus)
    {
        return sysPersonalStatusMapper.updateSysPersonalStatus(sysPersonalStatus);
    }

    /**
     * 批量删除个人动态
     * 
     * @param ids 需要删除的个人动态主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonalStatusByIds(Long[] ids)
    {
        return sysPersonalStatusMapper.deleteSysPersonalStatusByIds(ids);
    }

    /**
     * 删除个人动态信息
     * 
     * @param id 个人动态主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonalStatusById(Long id)
    {
        return sysPersonalStatusMapper.deleteSysPersonalStatusById(id);
    }
}
