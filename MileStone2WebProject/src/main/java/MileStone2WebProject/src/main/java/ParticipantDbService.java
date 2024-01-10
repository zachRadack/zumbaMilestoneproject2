package MileStone2WebProject.src.main.java;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import MileStone2WebProject.src.main.java.sqlDatabase;
import MileStone2WebProject.src.main.java.Participant;

public class ParticipantDbService {
	public int addParticipants(Participant participant) {
		try {
		Connection con = sqlDatabase.getDbConnection();	
		PreparedStatement pstmt = con.prepareStatement("insert into participant values(?,?,?,?,?)");
		pstmt.setInt(1, participant.getPartID());
        pstmt.setString(2, participant.getPartName());
        pstmt.setInt(3, participant.getPartAge());
        pstmt.setString(4, participant.getPartPhoneNumber());
        pstmt.setInt(5, participant.getBatchInt());

		
		return pstmt.executeUpdate();
		} catch (Exception e) {
				System.err.println(e);
				return 0;
		}
	}

    public List<Participant> getAllParticipants(){
        List<Participant> participantList = new ArrayList<Participant>();
        try {
            Connection con = sqlDatabase.getDbConnection();
            PreparedStatement pst = con.prepareStatement("select * from participant");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Participant participant = new Participant();
                participant.setPartID(rs.getInt(1));
                participant.setPartName(rs.getString(2));
                participant.setPartAge(rs.getInt(3));
                participant.setPartPhoneNumber(rs.getString(4));
                participant.setBatchInt(rs.getInt(5));
                participantList.add(participant);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return participantList;
    }

    // remove participant
    public int removeParticipant(int partID) {
        int count = 0;
        try {
            Connection con = sqlDatabase.getDbConnection();
            PreparedStatement pst = con.prepareStatement("delete from participant where partID=?");
            pst.setInt(1, partID);
            count = pst.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return count;
    }

    // update participant
    public int updateParticipant(Participant participant) {
        int count = 0;
        try {
            Connection con = sqlDatabase.getDbConnection();
            PreparedStatement pst = con.prepareStatement("update participant set partName=?, partAge=?, partPhoneNumber=?, batchInt=? where partID=?");
            pst.setString(1, participant.getPartName());
            pst.setInt(2, participant.getPartAge());
            pst.setString(3, participant.getPartPhoneNumber());
            pst.setInt(4, participant.getBatchInt());
            pst.setInt(5, participant.getPartID());
            count = pst.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return count;
    }

    public Participant getParticipant(int partID) {
        Participant participant = new Participant();
        try {
            Connection con = sqlDatabase.getDbConnection();
            PreparedStatement pst = con.prepareStatement("select * from participant where partID=?");
            pst.setInt(1, partID);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                participant.setPartID(rs.getInt(1));
                participant.setPartName(rs.getString(2));
                participant.setPartAge(rs.getInt(3));
                participant.setPartPhoneNumber(rs.getString(4));
                participant.setBatchInt(rs.getInt(5));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return participant;
    }
}
