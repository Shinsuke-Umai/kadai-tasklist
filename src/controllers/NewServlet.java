package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //Taskのインスタンスを生成
        Task t = new Task();

        //tの各フィールドにデータを挿入//カラムの中のIDは自動生成
        Timestamp currentTime = new Timestamp(System.currentTimeMillis()); //現在の日時を取得
        t.setCreated_at(currentTime); //作成日時
        t.setUpdated_at(currentTime); //更新日時

        //contentのデータ
        String context = "hello";
        t.setContent(context);

        //データベースの保存//em=データベース
        em.getTransaction().begin();
        em.persist(t); //データベースにデータを保存
        em.getTransaction().commit();//データを確定(コミット)

        //自動生成されたIDの値を表示
        response.getWriter().append(Integer.valueOf(t.getId()).toString());

        em.close();
    }

}
