package MileStone2WebProject.src.main.java;
public class Batch {

    private int batchID;
    private String batchType;
    private String BatchTime;
	public Batch() {
		super();
	}

    public Batch(int batchID, String batchType, String BatchTime) {
        super();
        this.batchID = batchID;
        this.batchType = batchType;
        this.BatchTime = BatchTime;
    }

    public int getBatchID() {
        return batchID;
    }
    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }
    public String getBatchType() {
        return batchType;
    }
    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }
    public String getBatchTime() {
        return BatchTime;
    }
    public void setBatchTime(String BatchTime) {
        this.BatchTime = BatchTime;
    }


}
