package com.xiushang.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * marketing客户端
 */
@Entity
@Table(name = "t_marketing_client")
public class MarketingClientEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JSONField(serialize = false, deserialize = false)
    @ApiModelProperty(hidden = true)
    private ShopEntity belongShop;
    /**
     * 用户
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JSONField(serialize = false, deserialize = false)
    @ApiModelProperty(hidden = true)
    private UserEntity user;

    @ApiModelProperty(value = "渠道 （kuaishou,vivo,tencent,ocean_engine）",required = true)
    private String channel;

    @ApiModelProperty(value = "广告主ID",required = true)
    private String advertiserId;

    @ApiModelProperty(notes = "客户端名称")
    private String clientName;
    @ApiModelProperty(value = "客户端ID",required = true)
    private String clientId;
    @ApiModelProperty(value = "客户端秘钥",required = true)
    @JSONField(serialize = false, deserialize = false)
    private String secret;
    @ApiModelProperty(value = "回调地址",required = true)
    private String callbackUrl;

    @ApiModelProperty(notes = "授权token")
    private String accessToken;
    @ApiModelProperty(notes = "刷新token")
    private String refreshToken;
    @ApiModelProperty(notes = "创建时间")
    private Date createTime;
    @ApiModelProperty(notes = "刷新时间")
    private Date refreshTime;

    public ShopEntity getBelongShop() {
        return belongShop;
    }

    public void setBelongShop(ShopEntity belongShop) {
        this.belongShop = belongShop;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }
}
