package place_class_details_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import place_class_details_mgmt.model.dto.PlaceClassDetail_DTO;
import place_class_details_mgmt.service.I_PlaceClassDetails_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/placeClassDetailsManagement")
public class PlaceClassDetails_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(PlaceClassDetails_Controller.class);

	@Autowired
	private I_PlaceClassDetails_Service placeClassDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<PlaceClassDetail_DTO> newplaceClass(@RequestBody PlaceClassDetail_DTO placeClassDTO) {
		PlaceClassDetail_DTO placeClassDTO2 = placeClassDetailsServ.newPlaceClassDetail(placeClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(placeClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllPlaceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassDetail_DTO>> getAllPlaceClassDetails() {
		ArrayList<PlaceClassDetail_DTO> placeClassDTOs = placeClassDetailsServ.getAllPlaceClassDetails();
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPlaceClasses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassDetail_DTO>> getSelectPlaceClassDetails(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<PlaceClassDetail_DTO> placeClassDTOs = placeClassDetailsServ.getSelectPlaceClassDetails(ids);		
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectPlacesForClasses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassDetail_DTO>> getSelectPlacesForClasses(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<PlaceClassDetail_DTO> placeClassDTOs = placeClassDetailsServ.getSelectPlacesForClasses(ids);		
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectPlaceClassesForParties", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassDetail_DTO>> getSelectPlaceClassesForParties(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<PlaceClassDetail_DTO> placeClassDTOs = placeClassDetailsServ.getSelectPlaceClassesForParties(ids);		
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updPlaceClassDetail")
	public void updatePlaceClassDetail(@RequestBody PlaceClassDetail_DTO placeClassDetailsDTO) 
	{
		placeClassDetailsServ.updPlaceClassDetail(placeClassDetailsDTO);	
		return;
	}

	
	@DeleteMapping("/delSelectPlaceClassDetails")
	public void deleteSelectplaceClassDetails(@RequestBody ArrayList<Long> ids)
	{
		placeClassDetailsServ.delSelectPlaceClassDetails(ids);
		return;
	}
	
	@DeleteMapping("/delSelectPlaceClassesForParties")
	public void deleteSelectplaceClassesForParties(@RequestBody ArrayList<Long> ids)
	{
		placeClassDetailsServ.delSelectPlaceClassesForParties(ids);
		return;
	}
	
	@DeleteMapping("/delAllPlaceClassDetails")
	public void deleteAllplaceClassDetails() {
		placeClassDetailsServ.delAllPlaceClassDetails();;
		return;
	}
	}