package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.List;

public class MealServlet extends HttpServlet {
    public static MealsUtil mealsUtil = new MealsUtil();
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    private List<MealTo> mealTo = MealsUtil.filteredByStreams(MealsUtil.getMeals(), LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);

    public List<MealTo> getMealTo() {
        return mealTo;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        log.debug("redirect to meals");
        response.sendRedirect("meals.jsp");
        */
        request.setAttribute("size", mealTo.size());
        request.setAttribute("name", "IGOR");
        request.setAttribute("list", mealTo);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }
}
