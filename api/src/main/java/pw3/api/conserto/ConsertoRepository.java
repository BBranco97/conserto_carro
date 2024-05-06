package pw3.api.conserto;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto,Long> {

    Page<Conserto> findAllByAtivoTrue(Pageable paginacao);
}
