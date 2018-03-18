package com.lingang.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

/**
 * 搜索界面的搜索记录实体
 */
@Entity(generateConstructors = false)
public class SearchHistory {
    @Id
    @Property(nameInDb = "R_ID")
    Long id;

    @NotNull
    @Property(nameInDb = "R_Title")
    String title;  //搜索记录内容

    @Property(nameInDb = "R_Time")
    long createTime; //搜索时间


    public SearchHistory() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }



}
