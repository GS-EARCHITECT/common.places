package place_class_details_mgmt.service;

import java.util.ArrayList;
import place_class_details_mgmt.model.dto.PlaceClassDetail_DTO;

public interface I_PlaceClassDetails_Service
{
    abstract public PlaceClassDetail_DTO newPlaceClassDetail(PlaceClassDetail_DTO placeClassDetailsDTO);
    abstract public ArrayList<PlaceClassDetail_DTO> getAllPlaceClassDetails();
    abstract public ArrayList<PlaceClassDetail_DTO> getSelectPlaceClassDetails(ArrayList<Long> ids);
    abstract public ArrayList<PlaceClassDetail_DTO> getSelectPlacesForClasses(ArrayList<Long> ids);
    abstract public ArrayList<PlaceClassDetail_DTO> getSelectPlaceClassesForParties(ArrayList<Long> ids);
    abstract public void updPlaceClassDetail(PlaceClassDetail_DTO placeClassDetailsDTO);
    abstract public void delAllPlaceClassDetails();
    abstract public void delSelectPlaceClassDetails(ArrayList<Long> ids);
    abstract public void delSelectPlacesForClasses(ArrayList<Long> ids);
    abstract public void delSelectPlaceClassesForParties(ArrayList<Long> ids);
}