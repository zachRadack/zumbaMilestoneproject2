package MileStone2WebProject.src.main.java;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MileStone2WebProject.src.main.java.sqlDatabase;

public class BatchDbService {
    
    /**
     * This method returns a list of all the batches in the database
     * @param batch
     * @return 
     */
    public int addBatch(Batch batch){
        // count represents the number of rows affected by an insert/update/delete
        int count = 0;
        try {
            Connection con = sqlDatabase.getDbConnection();
            PreparedStatement pst = con.prepareStatement("insert into batch values(?,?,?)");
            pst.setInt(1, batch.getBatchID());
            pst.setString(2, batch.getBatchType());
            pst.setString(3, batch.getBatchTime());
            count = pst.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return count;
    }

    /**
     * This method returns a list of all the batches in the database
     * @param batch
     * @return 
     */
    public List<Batch> getAllBatches(){
        List<Batch> batchList = new ArrayList<Batch>();
        try {
            Connection con = sqlDatabase.getDbConnection();
            PreparedStatement pst = con.prepareStatement("select * from batch");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Batch batch = new Batch();
                batch.setBatchID(rs.getInt(1));
                batch.setBatchType(rs.getString(2));
                batch.setBatchTime(rs.getString(3));
                batchList.add(batch);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return batchList;
    }
}
