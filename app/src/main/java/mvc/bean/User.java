package mvc.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：zhaolong
 * 日期：2017/10/31
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=>
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "NICKNAME")
    private String nickName;
    @Property(nameInDb = "ICONURL")
    private String iconUrl;
    @Generated(hash = 128356280)
    public User(Long id, String name, String nickName, String iconUrl) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.iconUrl = iconUrl;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getIconUrl() {
        return this.iconUrl;
    }
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}