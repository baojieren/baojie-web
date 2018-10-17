package com.baojie.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSONObject;
import com.baojie.entity.ResultBean;
import com.baojie.entity.VipVideoUrl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author baojie
 */
@RestController
@RequestMapping("/vipVideoUrl")
public class VipVideoUrlController extends BaseController {

    @PostMapping("/vipVideoUrlList.html")
    public String getVipVideoUrlList() {
        ResultBean resultBean = new ResultBean();
        try {
            List<VipVideoUrl> vipVideoUrlList = vipVideoUrlService.getVipVideoUrlList();
            if(CollectionUtils.isNotEmpty(vipVideoUrlList)){
                resultBean.setData(vipVideoUrlList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(resultBean);
    }

}
