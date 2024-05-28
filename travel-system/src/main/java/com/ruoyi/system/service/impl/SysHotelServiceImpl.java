package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysHotelMapper;
import com.ruoyi.system.domain.SysHotel;
import com.ruoyi.system.service.ISysHotelService;

/**
 * 酒店信息Service业务层处理
 * 
 * @author flight
 * @date 2024-05-25
 */
@Service
public class SysHotelServiceImpl implements ISysHotelService 
{
    @Autowired
    private SysHotelMapper sysHotelMapper;

    /**
     * 查询酒店信息
     * 
     * @param id 酒店信息主键
     * @return 酒店信息
     */
    @Override
    public SysHotel selectSysHotelById(Long id)
    {
        return sysHotelMapper.selectSysHotelById(id);
    }

    /**
     * 查询酒店信息列表
     * 
     * @param sysHotel 酒店信息
     * @return 酒店信息
     */
    @Override
    public List<SysHotel> selectSysHotelList(SysHotel sysHotel)
    {
        return sysHotelMapper.selectSysHotelList(sysHotel);
    }

    /**
     * 新增酒店信息
     * 
     * @param sysHotel 酒店信息
     * @return 结果
     */
    @Override
    public int insertSysHotel(SysHotel sysHotel)
    {
        return sysHotelMapper.insertSysHotel(sysHotel);
    }

    /**
     * 修改酒店信息
     * 
     * @param sysHotel 酒店信息
     * @return 结果
     */
    @Override
    public int updateSysHotel(SysHotel sysHotel)
    {
        return sysHotelMapper.updateSysHotel(sysHotel);
    }

    /**
     * 批量删除酒店信息
     * 
     * @param ids 需要删除的酒店信息主键
     * @return 结果
     */
    @Override
    public int deleteSysHotelByIds(Long[] ids)
    {
        return sysHotelMapper.deleteSysHotelByIds(ids);
    }

    /**
     * 删除酒店信息信息
     * 
     * @param id 酒店信息主键
     * @return 结果
     */
    @Override
    public int deleteSysHotelById(Long id)
    {
        return sysHotelMapper.deleteSysHotelById(id);
    }
}
