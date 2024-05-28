package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysScenicSpot;

/**
 * 景点信息Service接口
 * 
 * @author flight
 * @date 2024-05-25
 */
public interface ISysScenicSpotService 
{
    /**
     * 查询景点信息
     * 
     * @param id 景点信息主键
     * @return 景点信息
     */
    public SysScenicSpot selectSysScenicSpotById(Long id);

    /**
     * 查询景点信息列表
     * 
     * @param sysScenicSpot 景点信息
     * @return 景点信息集合
     */
    public List<SysScenicSpot> selectSysScenicSpotList(SysScenicSpot sysScenicSpot);

    /**
     * 新增景点信息
     * 
     * @param sysScenicSpot 景点信息
     * @return 结果
     */
    public int insertSysScenicSpot(SysScenicSpot sysScenicSpot);

    /**
     * 修改景点信息
     * 
     * @param sysScenicSpot 景点信息
     * @return 结果
     */
    public int updateSysScenicSpot(SysScenicSpot sysScenicSpot);

    /**
     * 批量删除景点信息
     * 
     * @param ids 需要删除的景点信息主键集合
     * @return 结果
     */
    public int deleteSysScenicSpotByIds(Long[] ids);

    /**
     * 删除景点信息信息
     * 
     * @param id 景点信息主键
     * @return 结果
     */
    public int deleteSysScenicSpotById(Long id);
}
