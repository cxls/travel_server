package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPersonalStatus;

/**
 * 个人动态Service接口
 * 
 * @author flight
 * @date 2024-05-25
 */
public interface ISysPersonalStatusService 
{
    /**
     * 查询个人动态
     * 
     * @param id 个人动态主键
     * @return 个人动态
     */
    public SysPersonalStatus selectSysPersonalStatusById(Long id);

    /**
     * 查询个人动态列表
     * 
     * @param sysPersonalStatus 个人动态
     * @return 个人动态集合
     */
    public List<SysPersonalStatus> selectSysPersonalStatusList(SysPersonalStatus sysPersonalStatus);

    /**
     * 新增个人动态
     * 
     * @param sysPersonalStatus 个人动态
     * @return 结果
     */
    public int insertSysPersonalStatus(SysPersonalStatus sysPersonalStatus);

    /**
     * 修改个人动态
     * 
     * @param sysPersonalStatus 个人动态
     * @return 结果
     */
    public int updateSysPersonalStatus(SysPersonalStatus sysPersonalStatus);

    /**
     * 批量删除个人动态
     * 
     * @param ids 需要删除的个人动态主键集合
     * @return 结果
     */
    public int deleteSysPersonalStatusByIds(Long[] ids);

    /**
     * 删除个人动态信息
     * 
     * @param id 个人动态主键
     * @return 结果
     */
    public int deleteSysPersonalStatusById(Long id);
}
