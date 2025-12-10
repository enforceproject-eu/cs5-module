package org.n52.project.enforce.cs5.api.impl.types;

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
public interface Cs5TypesRepository extends JpaRepository<Cs5Types, Integer> {    

    @Query("select d from Cs5Types as d where (d.type = :type) and (d.name ilike :name)")
    Optional<Cs5Types> findByTypeAndName(@Param("type") Integer type, @Param("name") String name);
}
