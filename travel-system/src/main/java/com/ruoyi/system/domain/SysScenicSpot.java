package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景点信息对象 sys_scenic_spot
 * 
 * @author flight
 * @date 2024-05-25
 */
public class SysScenicSpot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 景点名称 */
    @Excel(name = "景点名称")
    private String name;

    /** 景点坐标 */
    @Excel(name = "景点坐标")
    private String location;

    /** 景点的描述 */
    @Excel(name = "景点的描述")
    private String description;

    /** 地区信息 */
    @Excel(name = "地区信息")
    private String region;

    /** 门票价格 */
    @Excel(name = "门票价格")
    private BigDecimal ticketPrice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setTicketPrice(BigDecimal ticketPrice) 
    {
        this.ticketPrice = ticketPrice;
    }

    public BigDecimal getTicketPrice() 
    {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("location", getLocation())
            .append("description", getDescription())
            .append("region", getRegion())
            .append("ticketPrice", getTicketPrice())
            .toString();
    }
}
