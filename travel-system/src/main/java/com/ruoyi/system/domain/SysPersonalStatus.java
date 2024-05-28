package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人动态对象 sys_personal_status
 * 
 * @author flight
 * @date 2024-05-25
 */
public class SysPersonalStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 个人动态的唯一标识符 */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 动态内容 */
    @Excel(name = "动态内容")
    private String content;

    /** 图片的URL或路径，多张用英文,分隔 */
    @Excel(name = "图片的URL或路径，多张用英文,分隔")
    private String imageUrls;

    /** 动态的创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "动态的创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setImageUrls(String imageUrls) 
    {
        this.imageUrls = imageUrls;
    }

    public String getImageUrls() 
    {
        return imageUrls;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("imageUrls", getImageUrls())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
