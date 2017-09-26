package org.sang.Controller;

import org.sang.Beans.ResponseBean;
import org.sang.Dao.Update_seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
public class logoutAccountController {
    @Resource
    Update_seller update_seller;

    @RequestMapping(value = "/Restaurant/logoutAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean logoutAccount(HttpServletRequest req) throws UnsupportedEncodingException {
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int sellerid = (int)session.getAttribute("sellerId");
        int result = 0;

        result = update_seller.delete_by_id(sellerid);
        ResponseBean responseBean = new ResponseBean();
        if (result == 1) {
            //删除成功
            responseBean.setState("ok");
            responseBean.setMsg("删除成功");
        } else {
            responseBean.setState("error");
            responseBean.setMsg("删除失败");
        }
        return  responseBean;
    }
}
