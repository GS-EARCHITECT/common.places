package place_class_details_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import place_class_details_mgmt.model.dto.PlaceClassDetail_DTO;
import place_class_details_mgmt.model.master.PlaceClassDetail;
import place_class_details_mgmt.model.master.PlaceClassDetailPK;
import place_class_details_mgmt.model.repo.PlaceClassDetails_Repo;

@Service("placeClassDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PlaceClassDetail_Service implements I_PlaceClassDetails_Service 
{

	@Autowired
	private PlaceClassDetails_Repo placeClassDetailsRepo;

	public PlaceClassDetail_DTO newPlaceClassDetail(PlaceClassDetail_DTO lDetails) 
	{
		Optional<PlaceClassDetail> placeClassDetails = null;
		PlaceClassDetail_DTO placeClassDetailsDTO = null;
		PlaceClassDetailPK placeClassDetailsPK = new PlaceClassDetailPK();
		placeClassDetailsPK.setPlaceSeqNo(lDetails.getPlaceSeqNo());
		placeClassDetailsPK.setPlaceClassSeqNo(lDetails.getPlaceClassSeqNo());
		placeClassDetailsPK.setPartySeqNo(lDetails.getPartySeqNo());
		placeClassDetailsPK.setParPlaceSeqNo(lDetails.getParPlaceSeqNo());	
		placeClassDetails = placeClassDetailsRepo.findById(placeClassDetailsPK);
		
		if(!placeClassDetails.isPresent())
		{
		placeClassDetails.get().setId(placeClassDetailsPK);	
		placeClassDetailsDTO = 	getPlaceClassDetail_DTO(placeClassDetailsRepo.save(placeClassDetails.get()));
		}
		return placeClassDetailsDTO;
	}

	public ArrayList<PlaceClassDetail_DTO> getAllPlaceClassDetails() {
		ArrayList<PlaceClassDetail> placeList = (ArrayList<PlaceClassDetail>) placeClassDetailsRepo.findAll();
		ArrayList<PlaceClassDetail_DTO> lDetails = new ArrayList<PlaceClassDetail_DTO>();
		lDetails = placeList != null ? this.getPlaceClassDetail_DTOs(placeList) : null;
		return lDetails;
	}

    
	public ArrayList<PlaceClassDetail_DTO> getSelectPlacesForClasses(ArrayList<Long> ids)
    {
		ArrayList<PlaceClassDetail> lDetails = placeClassDetailsRepo.getSelectPlacesForClasses(ids);
		ArrayList<PlaceClassDetail_DTO> placeClassDetailsDTOs = null;
		placeClassDetailsDTOs = lDetails != null ? this.getPlaceClassDetail_DTOs(lDetails) : null;
		return placeClassDetailsDTOs;
	}

	public ArrayList<PlaceClassDetail_DTO> getSelectPlaceClassesForParties(ArrayList<Long> ids)
    {
		ArrayList<PlaceClassDetail> lDetails = placeClassDetailsRepo.getSelectPlaceClassesForParties(ids);
		ArrayList<PlaceClassDetail_DTO> placeClassDetailsDTOs = null;
		placeClassDetailsDTOs = lDetails != null ? this.getPlaceClassDetail_DTOs(lDetails) : null;
		return placeClassDetailsDTOs;
	}

	
	public ArrayList<PlaceClassDetail_DTO> getSelectPlaceClassDetails(ArrayList<Long> ids)
    {
		ArrayList<PlaceClassDetail> lDetails = placeClassDetailsRepo.getSelectPlaceClassDetails(ids);
		ArrayList<PlaceClassDetail_DTO> placeClassDetailsDTOs = null;
		placeClassDetailsDTOs = lDetails != null ? this.getPlaceClassDetail_DTOs(lDetails) : null;
		return placeClassDetailsDTOs;
	}
		
	public void updPlaceClassDetail(PlaceClassDetail_DTO lDetails) 
	{
		PlaceClassDetailPK placeClassDetailsPK = new PlaceClassDetailPK();
		placeClassDetailsPK.setPlaceSeqNo(lDetails.getPlaceSeqNo());
		placeClassDetailsPK.setPartySeqNo(lDetails.getPartySeqNo());
		placeClassDetailsPK.setPlaceClassSeqNo(lDetails.getPlaceClassSeqNo());	
		placeClassDetailsPK.setParPlaceSeqNo(lDetails.getParPlaceSeqNo());
						
		if (placeClassDetailsRepo.existsById(placeClassDetailsPK)) 
			{			
			placeClassDetailsRepo.save(this.setPlaceClassDetail(lDetails));			
		}
		return;
	}

	
	public void delAllPlaceClassDetails() {
		placeClassDetailsRepo.deleteAll();
	}

	public void delSelectPlaceClassDetails(ArrayList<Long> ids) 
	{
		if (ids != null) 
		{
			placeClassDetailsRepo.delSelectPlaceClassDetails(ids);
		}
	}
	
	public void delSelectPlacesForClasses(ArrayList<Long> ids) 
	{
		if (ids != null) 
		{
			placeClassDetailsRepo.delSelectPlacesForClasses(ids);
		}
	}

	public void delSelectPlaceClassesForParties(ArrayList<Long> ids) 
	{
		if (ids != null) 
		{
			placeClassDetailsRepo.delSelectPlacesClassesForParties(ids);
		}
	}
	
	private ArrayList<PlaceClassDetail_DTO> getPlaceClassDetail_DTOs(ArrayList<PlaceClassDetail> lDetails) {
		PlaceClassDetail_DTO lDTO = null;
		ArrayList<PlaceClassDetail_DTO> lDetailsDTOs = new ArrayList<PlaceClassDetail_DTO>();		
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getPlaceClassDetail_DTO(lDetails.get(i));			
			lDetailsDTOs.add(lDTO);
		}
		return lDetailsDTOs;
	}

	private PlaceClassDetail_DTO getPlaceClassDetail_DTO(PlaceClassDetail lDetails) 
	{		
		PlaceClassDetail_DTO lDTO = new PlaceClassDetail_DTO();		
		lDTO.setPlaceSeqNo(lDetails.getId().getPlaceSeqNo());
		lDTO.setPlaceClassSeqNo(lDetails.getId().getPlaceClassSeqNo());
		lDTO.setPartySeqNo(lDetails.getId().getPartySeqNo());
		lDTO.setParPlaceSeqNo(lDetails.getId().getParPlaceSeqNo());		
		return lDTO;
	}

	private PlaceClassDetail setPlaceClassDetail(PlaceClassDetail_DTO lDTO) 
	{
		PlaceClassDetail lDetails = new PlaceClassDetail();
		PlaceClassDetailPK placeClassDetailsPK = new PlaceClassDetailPK();
		placeClassDetailsPK.setPlaceSeqNo(lDTO.getPlaceSeqNo());
		placeClassDetailsPK.setPlaceClassSeqNo(lDTO.getPlaceClassSeqNo());
		placeClassDetailsPK.setPartySeqNo(lDTO.getPartySeqNo());
		placeClassDetailsPK.setParPlaceSeqNo(lDTO.getParPlaceSeqNo());						
		lDetails.setId(placeClassDetailsPK);
		return lDetails;
	}
}