package MileStone2WebProject.src.main.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MileStone2WebProject.src.main.java.Batch;
import MileStone2WebProject.src.main.java.BatchDbService;

/**
 * Servlet implementation class BatchServlet
 */
@WebServlet("/BatchServlet")
public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet called with a get");

        System.out.println("In seeBatches");
        List<Batch> batchList = bs.allBatchDetails();
        request.setAttribute("batchList", batchList);
        RequestDispatcher rd = request.getRequestDispatcher("seeAllBatches.jsp");
        rd.forward(request, response);

    }

    BatchService bs = new BatchService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String operation = request.getParameter("operation");
        if (operation.equals("add")) {
            Batch batch = new Batch();
            int batchId = Integer.parseInt(request.getParameter("batchid"));
            String typeofbatch = request.getParameter("typeofbatch");
            String time = request.getParameter("time");

            batch.setBatchID(batchId);
            batch.setBatchType(typeofbatch);
            batch.setBatchTime(time);
            String result = bs.storeBatch(batch);
            pw.println(result);
            RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
            response.setContentType("text/html");
            rd.include(request, response);
        }

    }

}
