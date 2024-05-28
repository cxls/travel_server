package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店信息对象 sys_hotel
 * 
 * @author flight
 * @date 2024-05-25
 */
public class SysHotel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 酒店的唯一标识符 */
    private Long id;

    /** 酒店名称 */
    @Excel(name = "酒店名称")
    private String name;

    /** 坐标 */
    @Excel(name = "坐标")
    private String location;

    /** 酒店地址 */
    @Excel(name = "酒店地址")
    private String region;

    /** 酒店的描述 */
    @Excel(name = "酒店的描述")
    private String description;

    /** 酒店价格 */
    @Excel(name = "酒店价格")
    private BigDecimal price;

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
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("location", getLocation())
            .append("region", getRegion())
            .append("description", getDescription())
            .append("price", getPrice())
            .toString();
    }
}
