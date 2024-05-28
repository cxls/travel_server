package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPersonalStatus;

/**
 * 个人动态Mapper接口
 * 
 * @author flight
 * @date 2024-05-25
 */
public interface SysPersonalStatusMapper 
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
     * 删除个人动态
     * 
     * @param id 个人动态主键
     * @return 结果
     */
    public int deleteSysPersonalStatusById(Long id);

    /**
     * 批量删除个人动态
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPersonalStatusByIds(Long[] ids);
}
