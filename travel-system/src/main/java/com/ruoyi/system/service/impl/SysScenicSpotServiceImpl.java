package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysScenicSpotMapper;
import com.ruoyi.system.domain.SysScenicSpot;
import com.ruoyi.system.service.ISysScenicSpotService;

/**
 * 景点信息Service业务层处理
 * 
 * @author flight
 * @date 2024-05-25
 */
@Service
public class SysScenicSpotServiceImpl implements ISysScenicSpotService 
{
    @Autowired
    private SysScenicSpotMapper sysScenicSpotMapper;

    /**
     * 查询景点信息
     * 
     * @param id 景点信息主键
     * @return 景点信息
     */
    @Override
    public SysScenicSpot selectSysScenicSpotById(Long id)
    {
        return sysScenicSpotMapper.selectSysScenicSpotById(id);
    }

    /**
     * 查询景点信息列表
     * 
     * @param sysScenicSpot 景点信息
     * @return 景点信息
     */
    @Override
    public List<SysScenicSpot> selectSysScenicSpotList(SysScenicSpot sysScenicSpot)
    {
        return sysScenicSpotMapper.selectSysScenicSpotList(sysScenicSpot);
    }

    /**
     * 新增景点信息
     * 
     * @param sysScenicSpot 景点信息
     * @return 结果
     */
    @Override
    public int insertSysScenicSpot(SysScenicSpot sysScenicSpot)
    {
        return sysScenicSpotMapper.insertSysScenicSpot(sysScenicSpot);
    }

    /**
     * 修改景点信息
     * 
     * @param sysScenicSpot 景点信息
     * @return 结果
     */
    @Override
    public int updateSysScenicSpot(SysScenicSpot sysScenicSpot)
    {
        return sysScenicSpotMapper.updateSysScenicSpot(sysScenicSpot);
    }

    /**
     * 批量删除景点信息
     * 
     * @param ids 需要删除的景点信息主键
     * @return 结果
     */
    @Override
    public int deleteSysScenicSpotByIds(Long[] ids)
    {
        return sysScenicSpotMapper.deleteSysScenicSpotByIds(ids);
    }

    /**
     * 删除景点信息信息
     * 
     * @param id 景点信息主键
     * @return 结果
     */
    @Override
    public int deleteSysScenicSpotById(Long id)
    {
        return sysScenicSpotMapper.deleteSysScenicSpotById(id);
    }
}
