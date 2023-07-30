package place_class_structure_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import place_class_structure_mgmt.model.dto.PlaceClassStructure_DTO;
import place_class_structure_mgmt.model.master.PlaceClassStructure;
import place_class_structure_mgmt.model.master.PlaceClassStructurePK;
import place_class_structure_mgmt.model.repo.PlaceClassStructure_Repo;

@Service("placeClassStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PlaceClassStructureService implements I_PlaceClassStructure_Service {

	@Autowired
	private PlaceClassStructure_Repo placeClassStructureRepo;

	public PlaceClassStructure_DTO newPlaceClassStructure(PlaceClassStructure_DTO lStructure) 
	{
		Optional<PlaceClassStructure> placeClassStructure = null;
		PlaceClassStructure_DTO placeClassStructureDTO = null;
		PlaceClassStructurePK placeClassStructurePK = new PlaceClassStructurePK();
		placeClassStructurePK.setParPlaceClassSeqNo(lStructure.getParPlaceClassSeqNo());
		placeClassStructurePK.setPlaceClassSeqNo(lStructure.getPlaceClassSeqNo());
		placeClassStructure = placeClassStructureRepo.findById(placeClassStructurePK);
		
		if(!placeClassStructure.isPresent())
		{
		placeClassStructure.get().setId(placeClassStructurePK);	
		placeClassStructureDTO = 	getPlaceClassStructure_DTO(placeClassStructureRepo.save(placeClassStructure.get()));
		}
		return placeClassStructureDTO;
	}

	public ArrayList<PlaceClassStructure_DTO> getAllPlaceClassStructures() {
		ArrayList<PlaceClassStructure> placeList = (ArrayList<PlaceClassStructure>) placeClassStructureRepo.findAll();
		ArrayList<PlaceClassStructure_DTO> lStructuress = new ArrayList<PlaceClassStructure_DTO>();
		lStructuress = placeList != null ? this.getPlaceClassStructure_DTOs(placeList) : null;
		return lStructuress;
	}

    
	public ArrayList<PlaceClassStructure_DTO> getSelectPlaceClassesByParents(ArrayList<Long> ids)
    {
		ArrayList<PlaceClassStructure> lStructures = placeClassStructureRepo.getSelectPlaceClassesByParents(ids);
		ArrayList<PlaceClassStructure_DTO> placeClassStructureDTOs = null;
		placeClassStructureDTOs = lStructures != null ? this.getPlaceClassStructure_DTOs(lStructures) : null;
		return placeClassStructureDTOs;
	}

	public ArrayList<PlaceClassStructure_DTO> getSelectPlaceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids)
    {
		ArrayList<PlaceClassStructure> lStructures = placeClassStructureRepo.getSelectPlaceClassStructures(ids,pids);
		ArrayList<PlaceClassStructure_DTO> placeClassStructureDTOs = null;
		placeClassStructureDTOs = lStructures != null ? this.getPlaceClassStructure_DTOs(lStructures) : null;
		return placeClassStructureDTOs;
	}
		
	public void updPlaceClassStructure(PlaceClassStructure_DTO lStructure) 
	{
		PlaceClassStructurePK placeClassStructurePK = new PlaceClassStructurePK();
		placeClassStructurePK.setParPlaceClassSeqNo(lStructure.getParPlaceClassSeqNo());
		placeClassStructurePK.setPlaceClassSeqNo(lStructure.getPlaceClassSeqNo());	
		
		if (placeClassStructureRepo.existsById(placeClassStructurePK)) 
			{			
			placeClassStructureRepo.save(this.setPlaceClassStructure(lStructure));			
		}
		return;
	}

	
	public void delAllPlaceClassStructures() {
		placeClassStructureRepo.deleteAll();
	}

	public void delSelectPlaceClassStructures(ArrayList<Long> ids,ArrayList<Long> pids) 
	{
		if (ids != null && pids != null) 
		{
			placeClassStructureRepo.delSelectPlaceClassStructures(ids, pids);
		}
	}

	
	private ArrayList<PlaceClassStructure_DTO> getPlaceClassStructure_DTOs(ArrayList<PlaceClassStructure> lStructures) {
		PlaceClassStructure_DTO lDTO = null;
		ArrayList<PlaceClassStructure_DTO> lStructureDTOs = new ArrayList<PlaceClassStructure_DTO>();		
		for (int i = 0; i < lStructures.size(); i++) {
			lDTO = getPlaceClassStructure_DTO(lStructures.get(i));			
			lStructureDTOs.add(lDTO);
		}
		return lStructureDTOs;
	}

	private PlaceClassStructure_DTO getPlaceClassStructure_DTO(PlaceClassStructure lStructure) 
	{		
		PlaceClassStructure_DTO lDTO = new PlaceClassStructure_DTO();		
		lDTO.setParPlaceClassSeqNo(lStructure.getId().getParPlaceClassSeqNo());
		lDTO.setPlaceClassSeqNo(lStructure.getId().getPlaceClassSeqNo());		
		return lDTO;
	}

	private PlaceClassStructure setPlaceClassStructure(PlaceClassStructure_DTO lDTO) 
	{
		PlaceClassStructure lStructure = new PlaceClassStructure();
		PlaceClassStructurePK placeClassStructurePK = new PlaceClassStructurePK();
		placeClassStructurePK.setParPlaceClassSeqNo(lDTO.getParPlaceClassSeqNo());
		placeClassStructurePK.setPlaceClassSeqNo(lDTO.getPlaceClassSeqNo());
		lStructure.setId(placeClassStructurePK);
		return lStructure;
	}
}