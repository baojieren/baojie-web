package com.baojie.entity;

/**
 * Bing图片po
 *
 * @author 大宝杰
 */
public class BingImg {
    private String url;
    private String copyright;

    @Override
    public String toString() {
        return "BingImg{" +
                "url='" + url + '\'' +
                ", copyright='" + copyright + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
