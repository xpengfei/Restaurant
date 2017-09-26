package org.sang.Controller;

import org.sang.Beans.Comment;
import org.sang.Beans.ResponseBean;
import org.sang.Dao.Insert_comment;
import org.sang.Dao.Update_foodorder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Komachi on 2017/5/21.
 */
@Controller
public class commentOrderController {
    @Resource
    Insert_comment insert_comment;
    @Resource
    Update_foodorder update_foodorder;

    @RequestMapping(value = "/user/commentOrder",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean commentOrder(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int userid = (int)session.getAttribute("userId");
        //int userid = 222;

        System.out.println("start!!!");
        String orderid_str = req.getParameter("orderId");
        String foodname = req.getParameter("foodName");
        String commentmsg = req.getParameter("commentMsg");
        String foodimg = req.getParameter("foodImg");
        System.out.println(orderid_str);
        int orderid = Integer.parseInt(orderid_str);
        Date date = new Date();
        Timestamp tt = new Timestamp(date.getTime());

        Comment comment = new Comment();
        comment.setFoodimg(foodimg);
        comment.setFoodname(foodname);
        comment.setJudcon(commentmsg);
        comment.setUserid(String.valueOf(userid));
        comment.setId((long) orderid);
        comment.setJudtime(tt);


        int result = insert_comment.add_comment(comment);
        ResponseBean responseBean = new ResponseBean();
        if (result == 1) {
            //插入成功
            //修改订单状态为已完成
            try {
                update_foodorder.update_isFinish_by_id(1, orderid);
            }catch (Exception e){e.printStackTrace();}

            responseBean.setState("ok");
            responseBean.setMsg("评论成功");
        } else {
            responseBean.setState("error");
            responseBean.setMsg("评论失败");
        }
        return responseBean;
    }
}
