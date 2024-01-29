import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class patientServlet
 */
public class patientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String doa = req.getParameter("doa");
		String coa = req.getParameter("coa");
		String doctor = req.getParameter("doctor");
		String treatment = req.getParameter("treatment");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String db = "jdbc:mysql://localhost:3306/tshirt";
		String user = "root";
		String pass = "password";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(db,user,pass);
			stmt = conn.prepareStatement("insert into patient values (?, ?, ?, ?, ?, ?, ?);");
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setString(4, doa);
			stmt.setString(5,coa);
			stmt.setString(6, doctor);
			stmt.setString(7, treatment);
			
			int reff = stmt.executeUpdate();
			if(reff > 0) {
				System.out.println("Inserted successfully!");
			}
			
			PreparedStatement rest=conn.prepareStatement("select * from patient");
			
			rs=rest.executeQuery();
			while(rs.next()){
				System.out.println("id : "+rs.getString(1)+" name : "+rs.getString(2));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("patientInput.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
