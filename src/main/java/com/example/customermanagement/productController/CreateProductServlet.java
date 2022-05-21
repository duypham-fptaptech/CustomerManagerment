package com.example.customermanagement.productController;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.model.MySqlStudentModel;
import com.t2010a.hellot2010aagain.model.StudentModel;
import com.t2010a.hellot2010aagain.util.DateTimeHelper;
import com.t2010a.hellot2010aagain.util.ValidationUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CreateStudentServlet extends HttpServlet {

    private StudentModel studentModel;

    public CreateStudentServlet() {
        this.studentModel = new MySqlStudentModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("student", new Student());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String rollNumber = req.getParameter("rollNumber");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String stringBirthday = req.getParameter("birthday");
        System.out.println(fullName);
        Student student = new Student(rollNumber, fullName, email, phone);
        HashMap<String, String> errors = new HashMap<>();
        if (stringBirthday != null && stringBirthday.length() > 0) {
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
            student.setDob(birthday);
        }
        // validate dữ liệu theo kiểu cùi bắp.
        if (rollNumber == null || rollNumber.length() == 0) {
            errors.put("rollNumber", "Please enter rollnumber");
        }
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Please enter fullname");
        }
        if (email == null || email.length() == 0) {
            errors.put("email", "Please enter email");
        } else if (!ValidationUtil.checkEmail(email)) {
            errors.put("email", "Invalid email, please enter real email. For example: admin@gmail.com");
        }
        if (phone == null || phone.length() == 0) {
            errors.put("phone", "Please enter phone");
        }
        if (errors.size() > 0) {
            req.setAttribute("student", student);
            req.setAttribute("action", 1);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
            return;
        }
        if (studentModel.save(student) != null) {
            resp.sendRedirect("/admin/students/list");
        } else {
            req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
        }
    }
}