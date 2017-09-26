package org.sang;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

;

/**
 * Created by xpengfei on 2017/5/20.
 */
public class Seller_logState_Filter  implements Filter{
    /*
     *根据获取的session对象，用来判断seller的登录状态，完成页面访问控制
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        获取要访问的路径；
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
//        获取session对象
        String  result = (String) session.getAttribute("result");
        if ("/SellerLogin.html".equals(servletPath) || "/SellerReg.html".equals(servletPath) || servletPath.startsWith("/static") || servletPath.contains("hello") || servletPath.contains("img/")
//                下列改为controller中设置的@RequestMapping
                || servletPath.contains("/admin/register") || servletPath.contains("/admin/login")
                || "/UserLogin.html".equals(servletPath) || "/UserReg.html".equals(servletPath) || servletPath.contains("/register") || servletPath.contains("/login")) {
//            请求继续向下传递
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
//            需要进行权限控制的页面
            if (result==null || result.equals("Error") || result.equals("userError") ) {
                System.out.println("start1!!!");
//                未登录，跳转到登录界面；
//                服务器端跳转；
//                request.getRequestDispatcher("/SellerLogin.html").forward(servletRequest,servletResponse);
//                  客户端跳转；
                ((HttpServletResponse) servletResponse).sendRedirect("/UserLogin.html");

            }else if(result == ("userError")){
                ((HttpServletResponse) servletResponse).sendRedirect("/SellerLogin.html");
            }
            else if(result.equals("userOK") && servletPath.contains("Seller")) {
                ((HttpServletResponse) servletResponse).sendRedirect("/SellerLogin.html");
            }
            else
            {
//                已登录
                System.out.println("start2!!!");
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
    @Override
    public void destroy() {

    }
}
