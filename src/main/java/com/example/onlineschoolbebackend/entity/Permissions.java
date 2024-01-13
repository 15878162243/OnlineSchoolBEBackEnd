package com.example.onlineschoolbebackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName permissions
 */
@TableName(value ="permissions")
public class Permissions implements Serializable {
    /**
     * 权限id
     */
    @TableId(type = IdType.AUTO)
    private Integer pid;

    /**
     * 角色id
     */
    private Integer rid;

    /**
     * 权限名称
     */
    private String pname;

    /**
     * 描述
     */
    private String permissionsremarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 权限id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 角色id
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 角色id
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 权限名称
     */
    public String getPname() {
        return pname;
    }

    /**
     * 权限名称
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 描述
     */
    public String getPermissionsremarks() {
        return permissionsremarks;
    }

    /**
     * 描述
     */
    public void setPermissionsremarks(String permissionsremarks) {
        this.permissionsremarks = permissionsremarks;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permissions other = (Permissions) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getPermissionsremarks() == null ? other.getPermissionsremarks() == null : this.getPermissionsremarks().equals(other.getPermissionsremarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getPermissionsremarks() == null) ? 0 : getPermissionsremarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", rid=").append(rid);
        sb.append(", pname=").append(pname);
        sb.append(", permissionsremarks=").append(permissionsremarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}