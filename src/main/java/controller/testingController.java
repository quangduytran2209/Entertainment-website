package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import Entity.User;
import JpaUntils.getConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class testingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = JpaUntils.getConnection.getEntityManger();
		String sql = "Select o FROM user o ";
		TypedQuery<User> query = em.createQuery(sql,User.class);
		List<User> list =  query.getResultList();
//		for (User user : list) {
//			System.out.println(user.getUsername());
//		}
	}
}
