package place_class_structure_mgmt.controller;

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

import place_class_structure_mgmt.model.dto.PlaceClassStructure_DTO;
import place_class_structure_mgmt.service.I_PlaceClassStructure_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/placeClassManagement")
public class PlaceClassStructure_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(PlaceClassStructure_Controller.class);

	@Autowired
	private I_PlaceClassStructure_Service placeClassStructureServ;
	
	@PostMapping("/new")
	public ResponseEntity<PlaceClassStructure_DTO> newplaceClass(@RequestBody PlaceClassStructure_DTO placeClassDTO) {
		PlaceClassStructure_DTO placeClassDTO2 = placeClassStructureServ.newPlaceClassStructure(placeClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(placeClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllPlaceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassStructure_DTO>> getAllPlaceClassStructures() {
		ArrayList<PlaceClassStructure_DTO> placeClassDTOs = placeClassStructureServ.getAllPlaceClassStructures();
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPlaceClasses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassStructure_DTO>> getSelectPlaceClassStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids) 
	{
		ArrayList<PlaceClassStructure_DTO> placeClassDTOs = placeClassStructureServ.getSelectPlaceClassStructures(ids, pids);		
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectPlaceClassesByParents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassStructure_DTO>> getSelectPlaceClassStructuresByParents(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<PlaceClassStructure_DTO> placeClassDTOs = placeClassStructureServ.getSelectPlaceClassesByParents(ids);		
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updPlaceClassStructure")
	public void updatePlaceClassStructure(@RequestBody PlaceClassStructure_DTO placeClassStructureDTO) 
	{
		placeClassStructureServ.updPlaceClassStructure(placeClassStructureDTO);	
		return;
	}

	
	@DeleteMapping("/delSelectPlaceClassStrucures")
	public void deleteSelectplaceClassStrucures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		placeClassStructureServ.delSelectPlaceClassStructures(ids, pids);
		return;
	}
	
	@DeleteMapping("/delAllplaceClass")
	public void deleteAllplaceClasss() {
		placeClassStructureServ.delAllPlaceClassStructures();;
		return;
	}
	}