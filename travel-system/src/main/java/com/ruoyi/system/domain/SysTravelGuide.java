package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 旅游攻略信息对象 sys_travel_guide
 * 
 * @author flight
 * @date 2024-05-26
 */
public class SysTravelGuide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 旅游攻略的唯一标识符 */
    private Long id;

    /** 旅游攻略的标题 */
    @Excel(name = "旅游攻略的标题")
    private String title;

    /** 旅游攻略的内容 */
    @Excel(name = "旅游攻略的内容")
    private String content;

    /** 标识发布攻略的用户 */
    @Excel(name = "标识发布攻略的用户")
    private Long userId;

    /** 标识相关景点 */
    @Excel(name = "标识相关景点")
    private Long scenicSpotId;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String imageUrl;

    /** 攻略的创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "攻略的创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 攻略的更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "攻略的更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 地点名称 */
    @Excel(name = "地点名称")
    private String locationName;

    /** 发布人 */
    @Excel(name = "发布人")
    private String createUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setScenicSpotId(Long scenicSpotId) 
    {
        this.scenicSpotId = scenicSpotId;
    }

    public Long getScenicSpotId() 
    {
        return scenicSpotId;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }
    public void setLocationName(String locationName) 
    {
        this.locationName = locationName;
    }

    public String getLocationName() 
    {
        return locationName;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("userId", getUserId())
            .append("scenicSpotId", getScenicSpotId())
            .append("imageUrl", getImageUrl())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("locationName", getLocationName())
            .append("createUser", getCreateUser())
            .toString();
    }
}
