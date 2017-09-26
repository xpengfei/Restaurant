package org.sang.Controller;

import org.sang.Beans.Seller;
import org.sang.Dao.Select_seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
public class getsellerController {
    @Resource
    Select_seller select_seller;

    @RequestMapping("/Restaurant/getseller")
    @ResponseBody
    public Seller getSeller(HttpServletRequest req)
    {
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int sellerid = (int)session.getAttribute("sellerId");

        return select_seller.select_by_Id_Re_All(sellerid);
    }
}
