package place_class_structure_mgmt.service;

import java.util.ArrayList;

import place_class_structure_mgmt.model.dto.PlaceClassStructure_DTO;


public interface I_PlaceClassStructure_Service
{
    abstract public PlaceClassStructure_DTO newPlaceClassStructure(PlaceClassStructure_DTO placeClassStructureDTO);
    abstract public ArrayList<PlaceClassStructure_DTO> getAllPlaceClassStructures();    
    abstract public ArrayList<PlaceClassStructure_DTO> getSelectPlaceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);
    abstract public ArrayList<PlaceClassStructure_DTO> getSelectPlaceClassesByParents(ArrayList<Long> ids);
	abstract public void updPlaceClassStructure(PlaceClassStructure_DTO placeClassStructureDTO);
    abstract public void delAllPlaceClassStructures();
    abstract public void delSelectPlaceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);    
}