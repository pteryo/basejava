package com.learnjava.web;

import com.learnjava.Config;
import com.learnjava.model.Resume;
import com.learnjava.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ResumeServlet extends HttpServlet {

    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Writer writer = response.getWriter();
        writer.write(
                """
                        <html>
                        <head>
                            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                            <link rel="stylesheet" href="css/style.css">
                            <title>Список всех резюме</title>
                        </head>
                        <body>
                        <section>
                        <table border="1" cellpadding="8" cellspacing="0">
                            <tr>
                                <th>uuid</th>
                                <th>fullName</th>
                            </tr>
                        """);
        for (Resume resume : storage.getAllSorted()) {
            writer.write(
                    "<tr>\n" +
                            "     <td>" + resume.getUuid() + "</td>\n" +
                            "     <td>" + resume.getFullName() + "</td>\n" +
                            "</tr>\n");
        }
        writer.write("""
                </table>
                </section>
                </body>
                </html>
                """);
    }
}