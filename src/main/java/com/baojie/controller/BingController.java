package com.baojie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baojie.entity.BingImg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BingController {

    /**
     * 获取8天的bing图片json数据
     */
    @PostMapping("/getBingImgJson.html")
    public String getBingImgJson() throws Exception {
        URL url = new URL("https://cn.bing.com/HPImageArchive.aspx?format=js&idx=-1&n=8");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder bing = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null) {
            bing.append(inputLine);
        }

        List<BingImg> bingImgs = new ArrayList<>();

        JSONObject jsonObject = JSON.parseObject(bing.toString());
        String images = jsonObject.getString("images");
        JSONArray jsonArray = JSON.parseArray(images);
        for (Object o : jsonArray) {
            BingImg bingImg = new BingImg();
            JSONObject img = JSON.parseObject(o.toString());
            bingImg.setUrl("https://cn.bing.com" + img.getString("url").trim());
            bingImg.setCopyright(img.getString("copyright").trim());
            bingImgs.add(bingImg);
        }
        return JSON.toJSONString(bingImgs);
    }
}
