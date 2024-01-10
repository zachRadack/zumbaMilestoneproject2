package MileStone2WebProject.src.main.java;

public class Participant {
    private int partID;
	private String partName;
    private int partAge;
    private String partPhoneNumber;
    private int BatchInt;

	public Participant() {
		super();
	}
    public Participant(int partID, String partName, int partAge, String partPhoneNumber, int BatchInt) {
        super();
        this.partID = partID;
        this.partName = partName;
        this.partAge = partAge;
        this.partPhoneNumber = partPhoneNumber;
        this.BatchInt = BatchInt;
    }

    public int getPartID() {
        return partID;
    }
    public void setPartID(int partID) {
        this.partID = partID;
    }
    public String getPartName() {
        return partName;
    }
    public void setPartName(String partName) {
        this.partName = partName;
    }
    public int getPartAge() {
        return partAge;
    }
    public void setPartAge(int partAge) {
        this.partAge = partAge;
    }
    public String getPartPhoneNumber() {
        return partPhoneNumber;
    }
    public void setPartPhoneNumber(String partPhoneNumber) {
        this.partPhoneNumber = partPhoneNumber;
    }
    public int getBatchInt() {
        return BatchInt;
    }
    public void setBatchInt(int BatchInt) {
        this.BatchInt = BatchInt;
    }


}
