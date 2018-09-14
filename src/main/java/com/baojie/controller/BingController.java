package com.baojie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baojie.entity.BingImg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BingController extends BaseController {

    /**
     * 获取8天的bing图片json数据
     */
    @PostMapping("/getBingImgJson.html")
    public String getBingImgJson(String piexl) throws Exception {
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
            String urlSub = img.getString("url").trim();
            String imgUrl = urlSub.substring(0, urlSub.length() - 13) + piexl + urlSub.substring(urlSub.length() - 4);
            bingImg.setUrl("https://cn.bing.com" + imgUrl);
            bingImg.setCopyright(img.getString("copyright").trim());
            bingImgs.add(bingImg);
        }
        return JSON.toJSONString(bingImgs);
    }

    @RequestMapping("/downLoadImg.html")
    public void downLoadImg(String imgUrl, String imgName, HttpServletResponse response) throws IOException {
        // 获取扩展名
        String extension = imgUrl.substring(imgUrl.lastIndexOf("."));
        String name = URLEncoder.encode(imgName += extension, "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + name);

        HttpURLConnection con;
        URL urlAddress = new URL(imgUrl);
        //打开链接
        con = (HttpURLConnection) urlAddress.openConnection();
        //创建输入流
        try (BufferedInputStream inputStream = new BufferedInputStream(con.getInputStream());
             // 创建输出流
             ServletOutputStream servletOutputStream = response.getOutputStream();
        ) {
            // 缓存数组
            byte[] by = new byte[1024];
            //input读取的字节数
            int len;
            while ((len = inputStream.read(by)) != -1) {
                servletOutputStream.write(by, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
}
