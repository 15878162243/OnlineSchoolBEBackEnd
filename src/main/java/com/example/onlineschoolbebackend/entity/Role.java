package com.example.onlineschoolbebackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName role
 */
@TableName(value ="role")
public class Role implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer rid;

    /**
     * 角色
     */
    private String rname;

    /**
     * 描述
     */
    private String roleremarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * id
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 角色
     */
    public String getRname() {
        return rname;
    }

    /**
     * 角色
     */
    public void setRname(String rname) {
        this.rname = rname;
    }

    /**
     * 描述
     */
    public String getRoleremarks() {
        return roleremarks;
    }

    /**
     * 描述
     */
    public void setRoleremarks(String roleremarks) {
        this.roleremarks = roleremarks;
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
        Role other = (Role) that;
        return (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getRname() == null ? other.getRname() == null : this.getRname().equals(other.getRname()))
            && (this.getRoleremarks() == null ? other.getRoleremarks() == null : this.getRoleremarks().equals(other.getRoleremarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getRname() == null) ? 0 : getRname().hashCode());
        result = prime * result + ((getRoleremarks() == null) ? 0 : getRoleremarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", rname=").append(rname);
        sb.append(", roleremarks=").append(roleremarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}