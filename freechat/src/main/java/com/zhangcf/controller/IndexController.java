package com.zhangcf.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.zhangcf.init.ChatServer;
import com.zhangcf.init.FCont;

@Path
public class IndexController {
    @GetRoute("/")
    public String index() {
        return "index.html";
    }

    @PostRoute("opt")
    public void opt(@Param String pwd, @Param String opt) {
        if (FCont.ADM_PWD.equals(pwd)) {
            if ("shutdown".equals(opt)) {
                ChatServer.stop();
            }
            if ("startup".equals(opt)) {
                ChatServer.startup();
            }
        }
    }
}
