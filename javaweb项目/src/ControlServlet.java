import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ControlServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        String sign = request.getParameter("sign");
        HttpSession session = request.getSession();
        if (sign == null) {
            if (name.equals("万家欣") && pwd.equals("123")) {
                session.setAttribute("flag", "ok");
            }

            else
                session.setAttribute("flag", "error");
        } else {
            Cookie[] c = request.getCookies();
            if (c != null) {
                for (int i = 0; i < c.length; i++) {
                    if (URLDecoder.decode(c[i].getName(), "utf-8").equals("万家欣") && c[i].getValue() != null) {
                        if (URLDecoder.decode(c[i].getName(), "utf-8").equals("万家欣") && c[i].getValue().equals("1234"))
                            session.setAttribute("flag", "ok");
                        else
                            session.setAttribute("flag", "error");
                    } else {
                        Cookie c1 = new Cookie(URLEncoder.encode(name, "UTF-8"), "123456");
                        c1.setMaxAge(60);
                        response.addCookie(c1);
                        if (name.equals("万家欣") && pwd.equals("123")) {
                            session.setAttribute("flag", "ok");
                        } else
                            session.setAttribute("flag", "error");
                    }
                }
            } else {
                if (name.equals("万家欣") && pwd.equals("123")) {
                    session.setAttribute("flag", "ok");
                } else
                    session.setAttribute("flag", "error");
                Cookie c1 = new Cookie(URLEncoder.encode(name, "UTF-8"), "123");
                c1.setMaxAge(60);
                response.addCookie(c1);

            }

        }
        request.getRequestDispatcher("/transf.jsp").forward(request, response);
    }

}
