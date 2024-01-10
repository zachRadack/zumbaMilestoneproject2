package MileStone2WebProject.src.main.java;

import java.util.List;

import MileStone2WebProject.src.main.java.Batch;
import MileStone2WebProject.src.main.java.BatchDbService;

public class BatchService {

	BatchDbService bd = new BatchDbService();
	
	public String storeBatch(Batch batch) {
        
		if(bd.addBatch(batch)>0) {
			return "Batch details added successfully";
		}else {
			return "Batch details didn't add";
		}
	}
	
	public List<Batch> allBatchDetails() {
        
        List<Batch> batchList = bd.getAllBatches();
        System.out.println("In allBatchDetails"+ batchList);
		return batchList;
	}
}
