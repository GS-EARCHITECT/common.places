package place_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import place_class_structure_mgmt.model.master.PlaceClassStructure;
import place_class_structure_mgmt.model.master.PlaceClassStructurePK;

@Repository("placeClassStructureRepo")
public interface PlaceClassStructure_Repo extends CrudRepository<PlaceClassStructure, PlaceClassStructurePK> 
{
	@Query(value = "SELECT * FROM PLACE_CLASS_STRUCTURE a WHERE (a.place_class_seq_no in :ids and a.par_place_class_seq_no in :pids) order by place_class_seq_no", nativeQuery = true)
	ArrayList<PlaceClassStructure> getSelectPlaceClassStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM PLACE_CLASS_STRUCTURE a WHERE a.par_place_class_seq_no in :ids order by place_class_seq_no", nativeQuery = true)
	ArrayList<PlaceClassStructure> getSelectPlaceClassesByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PLACE_CLASS_STRUCTURE WHERE (a.place_class_seq_no in :ids and a.par_place_class_seq_no in :pids)", nativeQuery = true)
	void delSelectPlaceClassStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);
}
