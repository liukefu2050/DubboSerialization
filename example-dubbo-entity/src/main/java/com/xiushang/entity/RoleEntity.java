package com.xiushang.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sys_role")
public class RoleEntity extends BaseEntity  {

    public RoleEntity() {
    }

    public RoleEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**角色名称 */
    @ApiModelProperty(notes = "角色CODE")
    private String code;
    /**角色名称 */
    @ApiModelProperty(notes = "角色名称")
    private String name;

    @ApiModelProperty(notes = "相册")
    @ElementCollection
    @CollectionTable(name="rel_images_role", joinColumns=@JoinColumn(name="role_id"))
    @Column(name="images")
    private List<String> images = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
