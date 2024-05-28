package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysHotel;

/**
 * 酒店信息Service接口
 * 
 * @author flight
 * @date 2024-05-25
 */
public interface ISysHotelService 
{
    /**
     * 查询酒店信息
     * 
     * @param id 酒店信息主键
     * @return 酒店信息
     */
    public SysHotel selectSysHotelById(Long id);

    /**
     * 查询酒店信息列表
     * 
     * @param sysHotel 酒店信息
     * @return 酒店信息集合
     */
    public List<SysHotel> selectSysHotelList(SysHotel sysHotel);

    /**
     * 新增酒店信息
     * 
     * @param sysHotel 酒店信息
     * @return 结果
     */
    public int insertSysHotel(SysHotel sysHotel);

    /**
     * 修改酒店信息
     * 
     * @param sysHotel 酒店信息
     * @return 结果
     */
    public int updateSysHotel(SysHotel sysHotel);

    /**
     * 批量删除酒店信息
     * 
     * @param ids 需要删除的酒店信息主键集合
     * @return 结果
     */
    public int deleteSysHotelByIds(Long[] ids);

    /**
     * 删除酒店信息信息
     * 
     * @param id 酒店信息主键
     * @return 结果
     */
    public int deleteSysHotelById(Long id);
}
