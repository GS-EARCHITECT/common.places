package place_class_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import place_class_details_mgmt.model.master.PlaceClassDetail;
import place_class_details_mgmt.model.master.PlaceClassDetailPK;

@Repository("placeClassDetailsRepo")
public interface PlaceClassDetails_Repo extends CrudRepository<PlaceClassDetail, PlaceClassDetailPK> 
{
	@Query(value = "SELECT * FROM PLACE_CLASS_DETAILS a WHERE (a.place_seq_no in :ids) order by place_seq_no", nativeQuery = true)
	ArrayList<PlaceClassDetail> getSelectPlaceClassDetails(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM PLACE_CLASS_DETAILS a WHERE (a.party_seq_no in :ids) order by place_seq_no", nativeQuery = true)
	ArrayList<PlaceClassDetail> getSelectPlaceClassesForParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM PLACE_CLASS_DETAILS a WHERE (a.place_class_seq_no in :ids) order by place_seq_no", nativeQuery = true)
	ArrayList<PlaceClassDetail> getSelectPlacesForClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PLACE_CLASS_DETAILS WHERE (a.place_seq_no in :ids)", nativeQuery = true)
	void delSelectPlaceClassDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PLACE_CLASS_DETAILS a WHERE (a.place_class_seq_no in :ids)", nativeQuery = true)
	void delSelectPlacesForClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PLACE_CLASS_DETAILS a WHERE (a.party_seq_no in :ids)", nativeQuery = true)
	void delSelectPlacesClassesForParties(@Param("ids") ArrayList<Long> ids);
	
}
