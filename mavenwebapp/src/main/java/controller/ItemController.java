package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Items;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
public class ItemController {
    @RequestMapping(value = "itemList")
    public ModelAndView itemList(){
        List<Items> itemList = new ArrayList<Items>();
        itemList.add(new Items(1, "imac", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(2, "imac1", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(3, "imac2", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(4, "imac3", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(5, "imac4", 20000, new Date(), "卧槽，苹果本很贵啦！"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", itemList);
        modelAndView.setViewName("/itemList");
        return modelAndView;
    }
}
