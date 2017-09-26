package org.sang.Controller;

import org.sang.Beans.Food;
import org.sang.Dao.Select_food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Komachi on 2017/5/21.
 */
@Controller
public class getAllFoodListController {
    @Resource
    Select_food select_food;

    @RequestMapping("/user/getAllFoodList")
    @ResponseBody
    public List<Food> getAllFoodList()
    {
        return select_food.select_by_all_Re_All();
    }
}
