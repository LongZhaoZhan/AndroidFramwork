package mvc.bean;

/**
 * 作者：zhaolong
 * 日期：2017/11/8
 * 时间：11:19
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=> 首页资讯信息
 */

public class HomeInfo extends BaseBean{

    private String icon;
    private String imgUrl;
    private String clickUrl;
    private String title;
    private String content;

    public HomeInfo(){

    }

    public HomeInfo(String icon,String imgUrl,String clickUrl,String title,String content){
        this.icon = icon;
        this.imgUrl = imgUrl;
        this.clickUrl = clickUrl;
        this.title = title;
        this.content = content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
