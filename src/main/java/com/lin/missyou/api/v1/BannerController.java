package com.lin.missyou.api.v1;

import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Banner;
import com.lin.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author WeiMao
 * @create 2020-04-11 18:49
 */


@Controller
@ResponseBody
@RequestMapping("banner")
public class BannerController {


    @Autowired
    BannerService bannerService;

    @GetMapping("/get/{name}")
    public Banner test(@PathVariable String name)  {

        Banner byName = bannerService.findByName(name);
        if (byName == null) {
            throw new NotFoundException(30005);
        }
        return byName;
    }
}
