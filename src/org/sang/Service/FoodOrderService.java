package org.sang.Service;

import org.sang.Beans.Foodorder;
import org.sang.Dao.Select_foodorder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Komachi on 2017/5/19.
 */
@Service
public class FoodOrderService {
    @Resource
    Select_foodorder select_foodorder;


    public List<Foodorder> getALL(int sellerid){
        return select_foodorder.select_by_sellerId_Re_All_unfinish(sellerid);
    }
}
