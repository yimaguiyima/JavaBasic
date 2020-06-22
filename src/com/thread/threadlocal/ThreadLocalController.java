package com.thread.threadlocal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "/threadlocal")
public class ThreadLocalController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置:响应内容类型
        response.setContentType("text/html");

        // 输出文本
        PrintWriter out = response.getWriter();
        out.write("<h1> RequestHolder.getId() " + RequestHolder.getId() + " </h1>");
    }

    @Override
    public void destroy() {
        RequestHolder.remove();
        super.destroy();
    }
}
