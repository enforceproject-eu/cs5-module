package org.n52.project.enforce.cs5.api.impl.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>
 * Data repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs5DataRepository extends JpaRepository<Cs5Data, Integer> {
    
    /**
     * <p>
     * getGeoJson.
     * </p>
     * 
     * @return a {@link String} object
     */
    @Query("select ST_Cs5DataToGeoJson()")
    String getGeoJson();
}
