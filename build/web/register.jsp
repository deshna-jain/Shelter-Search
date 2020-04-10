

<%@page  import="java.sql.ResultSet,java.sql.Connection" %>
<%@page  import="java.sql.PreparedStatement,java.sql.DriverManager" %>

<%
            String user=request.getParameter("user");
            String name=request.getParameter("name");
            String id=request.getParameter("email");
            String dob=request.getParameter("dob");
            String mobilenum=request.getParameter("mobilenum");
            String password=request.getParameter("password");
            String gender=request.getParameter("gender");
//            if(id.equals(""))
//            {
//                out.println("id is required");    
//            }
//            if(category.equals("select category"))
//            {
//            out.println("please select valid choice");    
//            }
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        PreparedStatement st=con.prepareStatement("insert into "+user+"(name,id,dob,mobilenum,password,gender) values(?,?,?,?,?,?)");
        st.setString(1, name);
        st.setString(2,id);
        st.setString(3,dob);
        st.setString(4,mobilenum);
        st.setString(5,password);
        st.setString(6,gender);
        
        st.executeUpdate();
         response.sendRedirect("index.html");
%>