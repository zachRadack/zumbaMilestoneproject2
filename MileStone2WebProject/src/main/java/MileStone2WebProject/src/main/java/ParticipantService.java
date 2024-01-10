package MileStone2WebProject.src.main.java;
import java.util.List;

import MileStone2WebProject.src.main.java.Participant;
import MileStone2WebProject.src.main.java.ParticipantDbService;

public class ParticipantService {

	ParticipantDbService pd = new ParticipantDbService();
	
	public String storeParticipatns(Participant participant) {
		if(pd.addParticipants(participant)>0) {
			return "Participants details added successfully";
		}else {
			return "Participant details didn't add";
		}
	}

    public List<Participant> getAllParticipants() {
        return pd.getAllParticipants();
    }

    // remove participant
    public String deleteParticipant(int partID) {
        if (pd.removeParticipant(partID) > 0) {
            return "Participant removed successfully";
        } else {
            return "Participant not removed";
        }
    }

    public String updateParticipant(Participant participant) {
        if (pd.updateParticipant(participant) > 0) {
            return "Participant updated successfully";
        } else {
            return "Participant not updated";
        }
    }


    public Participant getParticipant(int partID) {
        return pd.getParticipant(partID);
    }
}

