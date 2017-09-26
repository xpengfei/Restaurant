package org.sang.Controller;

import org.sang.Beans.Comment;
import org.sang.Beans.CommentOutBean;
import org.sang.Beans.Foodorder;
import org.sang.Dao.Select_comment;
import org.sang.Dao.Select_foodorder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komachi on 2017/5/20.
 */
@Controller
public class getCommentListController {
    @Resource
    Select_comment select_comment;
    @Resource
    Select_foodorder select_foodorder;

    @RequestMapping("/Restaurant/getCommentList")
    @ResponseBody
    public List<CommentOutBean> getCommentList(HttpServletRequest req){
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        //int sellerid = (int)session.getAttribute("sellerId");
        int sellerid = 42;

        //查找商家对应的订单
        List<Foodorder> orderlist = select_foodorder.select_by_sellerId_Re_All(sellerid);
        //获取订单id
        List<Integer> orderidlist = new ArrayList<>();
        for(int i=0;i<orderlist.size();i++)
        {
            orderidlist.add(Integer.parseInt(String.valueOf(orderlist.get(i).getId())));
        }
        //查找对应的评论
        List<CommentOutBean> commentlist = new ArrayList<CommentOutBean>();
        for(int i=0;i<orderlist.size();i++)
        {
            //System.out.println("orderid:"+orderidlist.get(i));
            try {
                Comment com = select_comment.select_by_Id_Re_All(orderidlist.get(i));
                CommentOutBean commentOutBean = new CommentOutBean(com.getId(),com.getFoodname(),com.getJudcon(),com.getJudtime().toString(),com.getUserid(),com.getFoodimg());
                commentlist.add(commentOutBean);
            }
            catch (Exception e){
                continue;
            }
        }

        return  commentlist;
    }
}
