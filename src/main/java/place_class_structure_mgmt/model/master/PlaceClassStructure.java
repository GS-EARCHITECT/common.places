package place_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PLACE_CLASS_STRUCTURE database table.
 * 
 */
@Entity
@Table(name = "PLACE_CLASS_STRUCTURE")
public class PlaceClassStructure implements Serializable 
{
	private static final long  serialVersionUID = 1L;

	@EmbeddedId
	private PlaceClassStructurePK id;

	public PlaceClassStructure() {
	}

	public PlaceClassStructurePK getId() {
		return this.id;
	}

	public void setId(PlaceClassStructurePK id) {
		this.id = id;
	}

	public PlaceClassStructure(PlaceClassStructurePK id) {
		super();
		this.id = id;
	}

}