package place_class_mgmt.service;

import java.util.ArrayList;

import place_class_mgmt.model.dto.PlaceClassMaster_DTO;

public interface I_PlaceClassMaster_Service
{
    abstract public PlaceClassMaster_DTO newPlaceClass(PlaceClassMaster_DTO placeClassMasterDTO);
    abstract public ArrayList<PlaceClassMaster_DTO> getAllPlaceClasses();    
    abstract public ArrayList<PlaceClassMaster_DTO> getSelectPlaceClasses(ArrayList<Long> ids);
    abstract public void updPlaceClass(PlaceClassMaster_DTO placeClassMasterDTO);
    abstract public void delAllPlaceClasses();    
    abstract public void delSelectPlaceClasses(ArrayList<Long> ids);
}