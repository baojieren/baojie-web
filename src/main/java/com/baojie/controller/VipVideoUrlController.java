package com.baojie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baojie
 */
@RestController
@RequestMapping("/vipVideoUrl")
public class VipVideoUrlController extends BaseController {

    // @PostMapping("/vipVideoUrlList.html")
    // public String getVipVideoUrlList() {
    //     ResultBean resultBean = new ResultBean();
    //     try {
    //         List<VipVideoUrl> vipVideoUrlList = vipVideoUrlService.getVipVideoUrlList();
    //         if(CollectionUtils.isNotEmpty(vipVideoUrlList)){
    //             resultBean.setData(vipVideoUrlList);
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return JSONObject.toJSONString(resultBean);
    // }

}
