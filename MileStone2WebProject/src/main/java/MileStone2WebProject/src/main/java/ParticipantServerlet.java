package MileStone2WebProject.src.main.java;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MileStone2WebProject.src.main.java.Batch;
import MileStone2WebProject.src.main.java.Participant;
import MileStone2WebProject.src.main.java.BatchService;
import MileStone2WebProject.src.main.java.ParticipantService;

@WebServlet("/ParticipantServerlet")
public class ParticipantServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    ParticipantService ps = new ParticipantService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet called with a get");
        if (request.getParameter("operation").equals("seeParticipant")) {
            seeParticipants(request, response);
        } else if (request.getParameter("operation").equals("batchInfo")) {
            batchInfo(request, response);
        }else if (request.getParameter("operation").equals("getParticipant")) {
            getParticipant(request, response);
        }
	}
    public void seeParticipants(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In ParticipantInfo");
        PrintWriter pw = response.getWriter();
		ParticipantService ps = new ParticipantService();
        List<Participant> listOfParticipant = ps.getAllParticipants();
        System.out.println("participantList"+listOfParticipant);
		request.setAttribute("participantList", listOfParticipant);
		RequestDispatcher rd = request.getRequestDispatcher("seeAllParticipants.jsp");
        rd.forward(request, response);
    }
    public void batchInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In batchInfo");
        PrintWriter pw = response.getWriter();
		BatchService bs = new BatchService();
		List<Batch> listOfBatch = bs.allBatchDetails();
        List<Integer> batchListID=new ArrayList<>();
        if (listOfBatch != null) {
        	System.out.println("we in bois");
            for (Batch batch : listOfBatch) {
            	System.out.println("batch.getBatchID() +"+batch.getBatchID());
                batchListID.add(batch.getBatchID());
            }
        }else {
        	System.out.println("we not in bois");
        }
        System.out.println("batchListID"+batchListID);
		request.setAttribute("batchList", batchListID);
		RequestDispatcher rd = request.getRequestDispatcher("addParticipant.jsp");
        rd.forward(request, response);
    }

    public void getParticipant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In getParticipant");
        PrintWriter pw = response.getWriter();
        int participantid = Integer.parseInt(request.getParameter("participantId"));
        Participant pp = ps.getParticipant(participantid);
        System.out.println("pp"+pp);
        request.setAttribute("participant", pp);
                request.setAttribute("participant", pp);
        request.setAttribute("participantId", pp.getPartID());
        request.setAttribute("participantName", pp.getPartName());
        request.setAttribute("participantAge", pp.getPartAge());
        request.setAttribute("phoneNumber", pp.getPartPhoneNumber());
        request.setAttribute("batchId", pp.getBatchInt());
        
        BatchService bs = new BatchService();
		List<Batch> listOfBatch = bs.allBatchDetails();
        List<Integer> batchListID=new ArrayList<>();
        if (listOfBatch != null) {
        	System.out.println("we in bois");
            for (Batch batch : listOfBatch) {
            	System.out.println("batch.getBatchID() +"+batch.getBatchID());
                batchListID.add(batch.getBatchID());
            }
        }else {
        	System.out.println("we not in bois");
        }
        System.out.println("batchListID"+batchListID);
		request.setAttribute("batchList", batchListID);
        RequestDispatcher rd = request.getRequestDispatcher("updateParticipant.jsp");
        rd.forward(request, response);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		if(operation.equals("add")) {
            addParticipant(request, response);
		} else if(operation.equals("delete")) {
            deleteParticipant(request, response);
        }else if(operation.equals("update")) {
            updateParticipant(request, response);
        }
	}
    
    public void addParticipant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In addParticipant");
  

        PrintWriter pw = response.getWriter();
        int participantid = Integer.parseInt(request.getParameter("participantId"));
        //add a check to see if the participant already exists
        if(ps.getParticipant(participantid)!= null) {
            pw.println("Participant already exists");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            response.setContentType("text/html");
            rd.include(request, response);
            return;
        }
        String pname = request.getParameter("participantName");
        int age  = Integer.parseInt(request.getParameter("participantAge"));
        
        String phonenumber = request.getParameter("phoneNumber");
        System.out.println(request.getParameter("batchId"));
        int batchd = Integer.parseInt(request.getParameter("batchId"));
        Participant pp = new Participant();
            pp.setPartID(participantid);
            pp.setPartName(pname);
            pp.setPartAge(age);
            pp.setPartPhoneNumber(phonenumber);
            pp.setBatchInt(batchd);

            String result = ps.storeParticipatns(pp);
            pw.println(result);
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            response.setContentType("text/html");
            rd.include(request, response);
    }

    public void deleteParticipant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In deleteParticipant");
        PrintWriter pw = response.getWriter();
        int participantid = Integer.parseInt(request.getParameter("participantId"));
        String result = ps.deleteParticipant(participantid);
        pw.println(result);
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        response.setContentType("text/html");
        rd.include(request, response);
    }

    // we will be getting only changed values from the form, so we need to find out what variables are not null then 
    // update those values in the database. If the value is null, then we don't update that value in the database.
    // TODO: ADD A CHECK TO MAKE SURE VALUES ARE NOT NULL
    public void updateParticipant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In updateParticipant");
        
        PrintWriter pw = response.getWriter();
        int participantid = Integer.parseInt(request.getParameter("participantId"));
        String pname = request.getParameter("participantName");
        int age  = Integer.parseInt(request.getParameter("participantAge"));
        String phonenumber = request.getParameter("phoneNumber");
        int batchd = Integer.parseInt(request.getParameter("batchId"));
        Participant pp = new Participant();
        pp.setPartID(participantid);
        pp.setPartName(pname);
        pp.setPartAge(age);
        pp.setPartPhoneNumber(phonenumber);
        pp.setBatchInt(batchd);
        String result = ps.updateParticipant(pp);
        pw.println(result);
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        response.setContentType("text/html");
        rd.include(request, response);
    }


}