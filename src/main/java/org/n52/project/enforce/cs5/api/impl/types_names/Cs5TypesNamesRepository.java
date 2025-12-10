package org.n52.project.enforce.cs5.api.impl.types_names;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Data repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs5TypesNamesRepository extends JpaRepository<Cs5TypesNames, Integer> {    

    @Query("select d from Cs5TypesNames as d where d.name ilike :name")
    Optional<Cs5TypesNames> findByName(@Param("name") String name);
}
