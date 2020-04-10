

<%@page  import="java.sql.ResultSet,java.sql.Connection" %>
<%@page  import="java.sql.PreparedStatement,java.sql.DriverManager" %>

<%
    
            String id =request.getParameter("username");
            String password =request.getParameter("t2");
            String user = request.getParameter("user");
            
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        PreparedStatement st=con.prepareStatement("select * from "+user+" where id=? and password=?");
        st.setString(1,id);
        st.setString(2,password);
        ResultSet rs= st.executeQuery();
         
        if(rs.next())
        {
            String name = rs.getString(1);
            session.setAttribute("username",name);
            response.sendRedirect("dashboard.html");
            return;
        }
        else
        {
            out.println("invalid id/password");
            return;
        }
%>